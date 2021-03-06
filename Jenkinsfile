def branch
def pullRequest
def refspecs

node {
    cleanWs()
    ansiColor('xterm') {
        branch = env.BRANCH_NAME.replaceAll(/\//, "-")
        env.PROJECT = "selenified"
        def branchCheckout
        pullRequest = env.CHANGE_ID
        if (pullRequest) {
            branchCheckout = "pr/${pullRequest}"
            refspecs = '+refs/pull/*/head:refs/remotes/origin/pr/*'
        } else {
            branchCheckout = env.BRANCH_NAME
            refspecs = '+refs/heads/*:refs/remotes/origin/*'
        }
        stage('Checkout Selenified') {
            // Get the test code from GitHub repository
            checkout([
                    $class           : 'GitSCM',
                    branches         : [[name: "*/${branchCheckout}"]],
                    userRemoteConfigs: [[
                                                url    : 'https://github.com/Coveros/selenified.git',
                                                refspec: "${refspecs}"
                                        ]]
            ])
            sh "mkdir results"
        }
        try {
            stage('Run Unit Tests') {
                try {
                    sh "mvn clean test"
                } catch (e) {
                    throw e
                } finally {
                    sh "cat target/coverage-reports/jacoco-ut.exec >> jacoco-ut.exec;"
                    sh "mkdir -p results/unit; mv target results/unit/"
                    archiveArtifacts artifacts: 'results/unit/target/surefire-reports/**'
                    junit 'results/unit/target/surefire-reports/TEST-*.xml'
                }
            }
            wrap([$class: 'Xvfb']) {
                stage('Execute HTMLUnit Tests') {
                    try {
                        sh 'mvn clean verify -Dskip.unit.tests -Dbrowser=htmlunit -Dheadless'
                    } catch (e) {
                        throw e
                    } finally {
                        sh "cat target/coverage-reports/jacoco-it.exec >> jacoco-it.exec;"
                        sh "mkdir -p results/htmlunit; mv target results/htmlunit/"
                        archiveArtifacts artifacts: 'results/htmlunit/target/failsafe-reports/**'
                        junit 'results/htmlunit/target/failsafe-reports/TEST-*.xml'
                    }
                }
                stage('Execute Local Tests') {
                    try {
                        sh 'mvn clean verify -Dskip.unit.tests -Dbrowser=chrome -Dfailsafe.groups.exclude="services" -Dheadless'
                    } catch (e) {
                        throw e
                    } finally {
                        sh "cat target/coverage-reports/jacoco-it.exec >> jacoco-it.exec;"
                        sh "mkdir -p results/browserLocal; mv target results/browserLocal/"
                        archiveArtifacts artifacts: 'results/browserLocal/target/failsafe-reports/**'
                        junit 'results/browserLocal/target/failsafe-reports/TEST-*.xml'
                    }
                }
            }
        } finally {
            withCredentials([
                    string(
                            credentialsId: 'sonar-token',
                            variable: 'sonartoken'
                    ),
                    string(
                            credentialsId: 'sonar-github',
                            variable: 'SONAR_GITHUB_TOKEN'
                    )
            ]) {
                stage('Perform SonarQube Analysis') {
                    def sonarCmd = "mvn clean compile sonar:sonar -Dsonar.login=${env.sonartoken} -Dsonar.junit.reportPaths='results/unit/target/surefire-reports,results/htmlunit/target/failsafe-reports,results/browserLocal/target/failsafe-reports,results/browserRemote/target/failsafe-reports' -Dsonar.jacoco.reportPaths=jacoco-ut.exec,jacoco-it.exec"
                    if (branch == 'develop' || branch == 'master') {
                        sh "${sonarCmd} -Dsonar.branch=${branch}"
                    } else {
                        if (pullRequest) {
                            sh "${sonarCmd} -Dsonar.analysis.mode=preview -Dsonar.branch=${branch} -Dsonar.github.pullRequest=${pullRequest} -Dsonar.github.repository=Coveros/${env.PROJECT} -Dsonar.github.oauth=${SONAR_GITHUB_TOKEN}"
                        } else {
                            sh "${sonarCmd} -Dsonar.analysis.mode=preview"
                        }
                    }
                }
            }
            stage('Publish Coverage Results') {
                jacoco()
            }
            withCredentials([
                    usernamePassword(
                            credentialsId: 'saperstone-slack',
                            usernameVariable: '',
                            passwordVariable: 'botToken'
                    )
            ]) {
                stage('Send Notifications') {
                    emailextrecipients([culprits(), developers(), requestor()])
                    // send slack notifications
                    def message = "Selenified%20build%20completed%20for%20`${env.BRANCH_NAME}`.%20It%20was%20a%20${currentBuild.currentResult}.%20Find%20the%20details%20at%20${env.BUILD_URL}."
                    sh "curl -s -X POST 'https://slack.com/api/chat.postMessage?token=${env.botToken}&channel=%23selenified&text=${message}'"
                }
            }
        }
    }
}
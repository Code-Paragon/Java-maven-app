pipeline {
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "Testing..."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("build jar") {
            when {
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "building jar"
                }
            }
        }
        stage("deploy") {
            when {
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "deploying"
                }
            }
        }
    }
}

pipeline {
    agent any

    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('123')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                echo "building version ${NEW_VERSION}"
            }
        }
        stage('Test') {
            when {
                expression {
                    env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main'
                }
            }
            steps {
                echo 'Testing the application...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                echo "user = ${SERVER_CREDENTIALS_USR}"
            }
        }
    }

    post {
        always {
            echo 'Ce bloc s exécute toujours'
        }
        success {
            echo 'Build réussi'
        }
        failure {
            echo 'Build échoué'
        }
    }
}

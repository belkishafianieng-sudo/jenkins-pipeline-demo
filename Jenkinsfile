def gscript

pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Version à déployer')
        choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: 'Environnement')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Lancer les tests ?')
    }

    stages {
        stage('Load Script') {
            steps {
                script {
                    gscript = load 'script.groovy'
                }
            }
        }
        stage('Build') {
            steps {
                bat 'mvn --version'
                script {
                    gscript.buildApp()
                }
            }
        }
        stage('Test') {
            when {
                expression { params.executeTests == true }
            }
            steps {
                script {
                    gscript.testApp()
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "user = ${SERVER_CREDENTIALS_USR}"
                script {
                    gscript.deployApp(params.VERSION, params.ENV)
                }
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

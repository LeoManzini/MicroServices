pipeline {
    agent {
        label 'WindowsNode'
    }
    stages {
        stage('Git-checkout') {
            steps {
                echo "Checking out from git repo";
                git branch: 'main', url: 'https://github.com/LeoManzini/MicroServices.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the checked-out project";
                bat 'Build.bat'
            }
        }

        stage('Unit-Test') {
            steps {
                echo "Running JUnit tests";
                bat 'Unit.bat'
            }
        }

        stage('Quality-gate') {
            steps {
                echo "Verifying quality gates";
                bat 'Quality.bat'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to stahe environment for more tests";
                bat 'Deploy.bat'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        } 
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will rin only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing bur is now successful'
        }
    }
}
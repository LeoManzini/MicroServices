pipeline {
    agent any
    stages {
        stage('Git-checkout') {
            steps {
                echo "Checking out from git repo";
            }
        }

        stage('Build') {
            steps {
                echo "Building the checked-out project";
            }
        }

        stage('Unit-Test') {
            steps {
                echo "Running JUnit tests";
            }
        }

        stage('Quality-gate') {
            steps {
                echo "Verifying quality gates";
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to stahe environment for more tests";
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
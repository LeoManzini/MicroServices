pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                echo "Compiled successfully";
            }
        }

        stage ('JUnit') {
            steps {
                echo "JUnit passed successfully";
            }
        }

        stage ('Quality-Gate') {
            steps {
                echo "SonarQube Quality Gate passed successfully";
                /*sh exit ("1");*/
            }
        }

        stage ('Deploy') {
            steps {
                echo "Pass";
            }
        }
    }

    post {
        always {
            echo 'Here it will pass ever, independent of the stage result'
        }
        success {
            echo 'Here it will pass only after the stages execution, they all are with success'
        }
        failure {
            echo 'Here will run just if the stages block are with errors'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will compare the actual run with the last made '
            echo ' and if there are differences between then run this clause'
        }
    }
}
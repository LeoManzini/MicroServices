pipeline {
    agent none
    stages {
        stage('Non-parallel stage') {
            agent {
                label "master"
            }
            steps {
                echo "This stage will be executed first";
            }
        }

        stage('Run tests') {
            parallel {
                stage('Tests on Windows') {
                    agent {
                        label "WindowsNode"
                    } 
                    steps {
                        echo "First agent task"
                    }
                }
                stage('Tests on master') {
                    agent {
                        label "master"
                    } 
                    steps {
                        echo "First master task"
                    }
                }
            }
        }
    }
}

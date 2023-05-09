#!/usr/bin/env groovy

def call() {
    echo "building the docker image..ghc."
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "sudo usermod -aG docker ${USER}"
        
        sh "sudo docker build -t rahulkumarpaswan/demo-app:jma-1.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "sudo docker push rahulkumarpaswan/demo-app:jma-1.0"
    }

}

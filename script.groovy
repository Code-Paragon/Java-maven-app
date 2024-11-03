def buildJar() {
    echo "building the application"
    sh 'mvn package'
}

def buildDeployImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t retr0009/demo-app:jma-2.1 . '
        sh '''
        echo "$PASS" | docker login -u "$USER" --password-stdin
        '''
        sh 'docker push retr0009/demo-app:jma-2.1'
    }
}

def deployApp() {
    echo "Deploying the application..."
}

return this

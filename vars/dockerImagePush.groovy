def call (String dockerhubUser, String ImageName, String ImageTag ) {

    sh """
        withCredentials([usernameColonPassword(credentialsId: 'dockerhub-auth', variable: 'dockerhubpass')]) {

            docker image push ${dockerhubUser}/${ImageName}:${ImageTag}
            docker image push ${dockerhubUser}/${ImageName}:latest
            docker rmi ${dockerhubUser}/${ImageName}:latest
        }

    """
}
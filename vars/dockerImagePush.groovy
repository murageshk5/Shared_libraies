def call (String dockerhubUser, String ImageName, String ImageTag ) {


        withCredentials([usernameColonPassword(credentialsId: 'dockerhub-auth', variable: 'dockerhubpass')]) {
        sh """
            docker image push ${dockerhubUser}/${ImageName}:${ImageTag}
            docker image push ${dockerhubUser}/${ImageName}:latest
            docker rmi ${dockerhubUser}/${ImageName}:latest
        """
        }

}
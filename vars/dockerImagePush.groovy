def call (String dockerhubUser, String ImageName, String ImageTag ) {


    withCredentials([usernamePassword(credentialsId: 'dockerhub-auth', passwordVariable: 'DOCKERHUBPASS', usernameVariable: 'DOCKERHUB')]) {

        sh """
            docker login -u $DOCKERHUB -p $DOCKERHUBPASS
            docker image push ${dockerhubUser}/${ImageName}:${ImageTag}
            docker image push ${dockerhubUser}/${ImageName}:latest
            docker rmi ${dockerhubUser}/${ImageName}:${ImageTag}
            docker rmi ${dockerhubUser}/${ImageName}:latest
        """
        }

}
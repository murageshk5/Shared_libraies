def call (String dockerhubUser, String ImageName, String ImageTag ) {

    sh """

        docker image build -t ${dockerhubUser}/${ImageName} .
        docker image tag ${dockerhubUser}/${ImageName} ${dockerhubUser}/${ImageName}:${ImageTag} 
        docker image tag ${dockerhubUser}/${ImageName} ${dockerhubUser}/${ImageName}:latest

    """
}
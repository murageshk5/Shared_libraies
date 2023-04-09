def call (String dockerhubUser, String ImageName, String ImageTag ) {

    sh """

        docker image build -t ${dockerhubUser}/${ImageName} .
        docker image -t ${dockerhubUser}/${ImageName}:${ImageTag} 
        docker image build -t ${dockerhubUser}/${ImageName}:latest

    """
}
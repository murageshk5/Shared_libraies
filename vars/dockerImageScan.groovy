def call (String dockerhubUser, String ImageName, String ImageTag ) {

    sh """
        trivy image ${dockerhubUser}/${ImageName}:latest > scan.txt
        cat scan.txt
    """
}
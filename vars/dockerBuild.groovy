// def call (String dockerhubUser, String ImageName, String ImageTag ) {

//     sh """

//         docker image build -t ${dockerhubUser}/${ImageName} .
//         docker image tag ${dockerhubUser}/${ImageName} ${dockerhubUser}/${ImageName}:${ImageTag} 
//         docker image tag ${dockerhubUser}/${ImageName} ${dockerhubUser}/${ImageName}:latest

//     """
// }

def call (String aws_accout_id, String region, String ecr_reponame ) {

    sh """

        docker build -t ${ecr_reponame} .
        docker tag ${ecr_reponame} ${aws_accout_id}.dkr.ecr.${region}.amazonaws.com/${ecr_reponame}:latest

    """
}




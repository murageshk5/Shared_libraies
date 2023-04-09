// def call (String dockerhubUser, String ImageName, String ImageTag ) {

//     sh """
//         trivy image ${dockerhubUser}/${ImageName}:latest > scan.txt
//         cat scan.txt
//     """
// }


def call  (String aws_accout_id, String region, String ecr_reponame ) {

    sh """
        trivy image ${aws_accout_id}.dkr.ecr.${region}.amazonaws.com/${ecr_reponame}:latest > scan.txt
        cat scan.txt
    """
}
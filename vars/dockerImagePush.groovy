// def call (String dockerhubUser, String ImageName, String ImageTag ) {


//     withCredentials([usernamePassword(credentialsId: 'dockerhub-auth', passwordVariable: 'DOCKERHUBPASS', usernameVariable: 'DOCKERHUB')]) {

//         sh """
//             docker login -u $DOCKERHUB -p $DOCKERHUBPASS
//             docker image push ${dockerhubUser}/${ImageName}:${ImageTag}
//             docker image push ${dockerhubUser}/${ImageName}:latest
//             docker rmi ${dockerhubUser}/${ImageName}:${ImageTag}
//             docker rmi ${dockerhubUser}/${ImageName}:latest
//         """
//         }

// }


def call (String aws_accout_id, String region, String ecr_reponame ) {


        sh """

            aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_accout_id} .dkr.ecr.${region}.amazonaws.com
            docker push ${aws_accout_id}.dkr.ecr.${region}.amazonaws.com/${ecr_reponame}:latest
            docker rmi ${aws_accout_id}.dkr.ecr.${region}.amazonaws.com/${ecr_reponame}:latest
            docker rmi ${ecr_reponame}

        """
        }





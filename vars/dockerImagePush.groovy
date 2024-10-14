// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }


def call(String aws_account_id, String Region, String ECR_REPO_NAME){
    
    sh """
     aws ecr get-login-password --region ${Region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${Region}.amazonaws.com
     docker push ${aws_account_id}.dkr.ecr.${Region}.amazonaws.com/${ECR_REPO_NAME}:latest
    """
}
// def call(String project, String ImageTag, String hubUser){
    
//     sh """   
//      trivy image ${hubUser}/${project}:latest > scan.txt
//      cat scan.txt
//     """
// }

def call(String aws_account_id, String Region, String ECR_REPO_NAME){
    
    sh """
    trivy image ${aws_account_id}.dkr.ecr.${Region}.amazonaws.com/${ECR_REPO_NAME}:latest > scan.txt
    cat scan.txt
    """
}   
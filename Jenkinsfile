pipeline {
    agent { 
        label 'qa' // Replace with the label for your EC2 agent
    }

    environment {
        AWS_REGION = 'us-east-1'  // Adjust to your region
        AWS_ACCESS_KEY_ID = credentials('1c458e9c-8554-4334-849c-a7a415a9b559') // Use your credential ID
        AWS_SECRET_ACCESS_KEY = credentials('1c458e9c-8554-4334-849c-a7a415a9b559') // Ensure the ID is valid for both
        //TERRAFORM_DIR = 'D:\\Project\\JenkinsMsaterSlave' // Adjusted path for the directory
    } 

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kailas135/JenkinsMsaterSlave.git'
            }
        }

        stage('Terraform Init') {
            steps {
                script {
                    sh 'terraform init'
                }
            }
        }

        stage('Terraform Plan') {
            steps {
                script {
                    sh 'terraform plan'
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                dir("${TERRAFORM_DIR}") { // Ensure TERRAFORM_DIR is defined
                    script {
                        sh 'terraform apply -auto-approve'
                    }
                }
            }
        }        
    }
}

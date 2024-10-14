@Library('my_shared_lib') _
pipeline {
    agent { 
        label 'qa'
    }

        parameters{
        choice(name: 'action', choices: 'create\ndelete', description: 'choose create/Destroy' ) 
        string(name: 'ImageName', description: 'name of the docker build', defaultValue: 'springboot')
        string(name: 'ImageTag', description: 'tag of the docker build', defaultValue: 'v1')
        string(name: 'DockerHubUser', description: 'name of the appliction', defaultValue: 'prafullb007')
        }

    environment {
        AWS_REGION = 'us-east-1'
        AWS_ACCESS_KEY_ID = credentials('1c458e9c-8554-4334-849c-a7a415a9b559')
        AWS_SECRET_ACCESS_KEY = credentials('1c458e9c-8554-4334-849c-a7a415a9b559')
    } 

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kailas135/JenkinsMsaterSlave.git'
            }
        }

        // stage('Terraform Init') {
        //     steps {
        //         script {
        //             sh 'terraform init'
        //         }
        //     }
        // }

        // stage('Terraform Plan') {
        //     steps {
        //         script {
        //             sh 'terraform plan'
        //         }
        //     }
        // }

        // stage('Terraform Apply') {
        //     steps {
        //         script {
        //                 sh 'terraform apply -auto-approve'
        //             }
                
        //     }
        // }
        // stage('Terraform Destroy') {
        //     steps {
        //         sh 'terraform destroy -auto-approve'
        //         }
        //     }
        stage('Unit Test maven') {
            when { 
                expression { params.action == 'create' } 
            }

            steps {
                script {
                    mvnTest()
                }
            }
        }

        stage('Integration Test maven'){
         when { expression {  params.action == 'create' } }
            steps{
               script{                   
                   mvnIntegrationTest()
               }
            }
        }
        stage('Static code analysis: Sonarqube'){
         when { expression {  params.action == 'create' } }
            steps{
               script{
                   def SonarQubecredentialsId = 'sonar-api'
                   statiCodeAnalysis(SonarQubecredentialsId)
               }
            }
        }
        // stage('Quality Gate Status Check : Sonarqube'){
        //  when { expression {  params.action == 'create' } }
        //     steps{
        //        script{
        //            def SonarQubecredentialsId = 'sonar-api'
        //            qualityGateStatus(SonarQubecredentialsId)
        //        }
        //     }
        // }
    }
}




def call(credentialsId) {
    // Assuming you already passed the credentials during the SonarQube scan
    waitForQualityGate abortPipeline: false
}


// def call(credentialsId){

// waitForQualityGate abortPipeline: false, credentialsId: credentialsId


// }



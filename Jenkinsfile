pipeline{
    agent any
    tools{
        maven 'maven-3.9.6'
    }
    stages{
        stage('Git Checkout'){
            steps{
                git url:'https://github.com/AntaBeye/projetdevops.git',branch:'main'
            }
        }
        stage('Build Maven'){
            steps{
                bat 'start /B mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
      steps{
        withSonarQubeEnv(installationName: 'sonarqube-10.3.0.82913', credentialsId: 'jenkins-sonar-token') {
        bat 'mvn sonar:sonar'
      }
    }
    }
        stage('Upload Jar File'){
            steps{
                nexusArtifactUploader artifacts: [
                    [artifactId: 'demo', 
                    classifier: '', 
                    file: 'target/demo-1.0-SNAPSHOT.jar', 
                    type: 'jar']
                    ], 
                    credentialsId: 'nexus-credentials', 
                    groupId: 'sn.dev', 
                    nexusUrl: 'localhost:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'demo', 
                    version: '1.0'
            }
        }
    }
}

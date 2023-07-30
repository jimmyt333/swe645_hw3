pipeline {
  agent any

  stages {
    stage('Checkout GitHub Repository') {
      steps {
        checkout scm
      }
    }
    
    stage('Build Docker Image') {
      steps {
        script {
            sh 'cd /Demo'
            sh 'rm -rf /target'
            sh './mvnw clean package'
            sh 'echo $BUILD_NUMBER'
            sh 'sudo docker login -u kelvintlu -p JnsJicMQb8J!mjA?'
            sh 'sudo docker build -t kelvintlu/swe645_hw3:$BUILD_NUMBER .'
        }
      }
    }
    
    stage('Push to Docker Hub') {
      steps {
        script {
            sh 'sudo docker push kelvintlu/swe645_hw3:$BUILD_NUMBER'
          }
        }
      }
    
    stage('Deploy to Rancher') {
      steps {
        script {
          sh 'kubectl set image deployment/swe645deployment container-0=kelvintlu/swe645_hw3:$BUILD_NUMBER'
        }
      }
    }
  }
}
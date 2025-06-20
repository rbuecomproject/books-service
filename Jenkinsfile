pipeline {
  agent any

  environment {
    GIT_CREDENTIALS_ID = 'github-token'     // Jenkins credential ID for GitHub PAT
  }

  stages {
    stage('Checkout Code') {
      steps {
        git credentialsId: "${GIT_CREDENTIALS_ID}",
            url: 'https://github.com/rbuecomproject/books-service.git',
            branch: 'main'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Docker Build & Push') {
      steps {
        sh '''
        docker build -t rbutechnologies/books-service:latest .
        docker push rbutechnologies/books-service:latest
        '''
      }
    }

    stage('Deploy to Minikube') {
      steps {
        sh '''
        kubectl config use-context minikube
        kubectl apply -f k8s/books-deployment.yaml
        kubectl rollout status deployment/books-deployment
        '''
      }
    }
  }
}

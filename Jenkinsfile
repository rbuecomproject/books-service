pipeline {
    agent any

    environment {
        DOCKER_USERNAME = 'rbutechnologies'
        IMAGE_NAME = 'books-service'
    }

    stages {
        stage('Checkout Code') {
			steps {
				git branch: 'main', 
				credentialsId: 'github-token', 
				url: 'https://github.com/rbuecomproject/books-service.git'
				  }
			}

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build & Push') {
            steps {
                bat "docker build -t %DOCKER_USERNAME%/%IMAGE_NAME%:latest ."
                bat "docker push %DOCKER_USERNAME%/%IMAGE_NAME%:latest"
            }
        }

        stage('Deploy to Minikube') {
            steps {
                bat 'kubectl config use-context minikube'
                bat 'kubectl apply -f k8s/books-deployment.yaml'
                bat 'kubectl rollout status deployment/books-dp'
            }
        }
    }
}

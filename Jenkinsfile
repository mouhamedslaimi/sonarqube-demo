pipeline {
  agent any

  tools {
    maven 'maven3'
  }
  		environment {
      		DOCKERHUB_CREDENTIALS=credentials('Docker-hub')
      	}
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('build') {
      steps {
        withMaven(globalMavenSettingsConfig: 'b4febe6b-7e35-4582-8550-0b05805e27e1', maven: 'maven3', traceability: false) {
          sh "mvn clean install -DskipTests"
        }
      }
    }
		stage('Build Docker image') {

			steps {
				//sh 'docker login -u "slaimimed" --password "estjuveca10A" '
				//sh 'docker image build -t slaimimed/sonarqube-demo:latest .'
				//sh 'docker push slaimimed/sonarqube-demo:latest'
				sh 'docker run -u 0 --privileged --name  slaimimed -it -d -p 8180:8180 -p 50000:50000 \
                    -v /var/run/docker.sock:/var/run/docker.sock \
                    -v $(which docker):/usr/bin/docker \
                    -v /home/jenkins_home:/var/jenkins_home \
                    slaimimed/sonarqube-demo:latest'
			}
		}

    /*
    stage('Tests Integration') {
      steps {
        withMaven(globalMavenSettingsConfig: 'b4febe6b-7e35-4582-8550-0b05805e27e1', maven: 'maven3', traceability: false) {
          sh "mvn verify"
        }
      }
    }
  
            stage('Quality') {

              environment {
                SCANNER_HOME = tool 'sonar-scanner'
              }
              steps {
                withSonarQubeEnv('sonarqube') {
                  sh "${SCANNER_HOME}/bin/sonar-scanner"
                }
              }
            }
 

    stage('deploy') {
      steps {
        withMaven(globalMavenSettingsConfig: 'b4febe6b-7e35-4582-8550-0b05805e27e1', maven: 'maven3', traceability: false) {
          sh "mvn deploy -DskipTests"
        }
      }
    }
*/
  }
  
}

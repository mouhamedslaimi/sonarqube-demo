pipeline {
  agent any

  tools {
    maven 'maven3'
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
    stage('Tests Integration') {
      steps {
        withMaven(globalMavenSettingsConfig: 'b4febe6b-7e35-4582-8550-0b05805e27e1', maven: 'maven3', traceability: false) {
          sh "mvn verify"
        }
      }
    }
        stage("Qua & Secu") {
            parallel {

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


            }
        }
  
 /*
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

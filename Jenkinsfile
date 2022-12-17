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
        withMaven(globalMavenSettingsConfig: 'ab5e38bd-cacd-4b18-9f8f-b6a2760730e5', maven: 'maven3', traceability: false) {
          sh "mvn verify"
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

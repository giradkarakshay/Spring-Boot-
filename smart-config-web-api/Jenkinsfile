pipeline {
  agent {
    node {
      label 'openstack'
    }
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -s settings.xml -gs settings.xml clean install -DskipTests=true'
      }
    }
    stage('Test') {
      steps {
            sh 'mvn -s settings.xml -gs settings.xml test'
      }
    }
    stage('Publish Artifacts') {
      when {
        branch 'master'
      }
      steps {
        sh 'git rev-parse HEAD > .git/commit-id'
        script {
          GIT_COMMIT = readFile('.git/commit-id').trim()
        }

        sh "mvn -s settings.xml -gs settings.xml versions:set -DgenerateBackupPoms=false -DnewVersion=${GIT_COMMIT}"
        sh "mvn -s settings.xml -gs settings.xml clean deploy -DskipTests=true"
   }
   }
   /*
   stage('Sonar Analysis') {
        when {
          branch 'master'
        }
        steps {
         sh "mvn -s settings.xml -gs settings.xml clean verify jacoco:report org.pitest:pitest-maven:mutationCoverage sonar:sonar -Denv.SONAR_USR=${CLOUD_FOUNDRY_USR} -Denv.SONAR_PWD=${CLOUD_FOUNDRY_PSW}"
       }
     }
     */
    stage('Deploy') {
    	when {
    		branch 'master'
    	}
    	steps {
    		sh "wget --user ${ARTIFACTORY_USR} --password ${ARTIFACTORY_PSW} -O target/smart-test-config.war -nv https://repository.deere.com/artifactory/it-manufacturing-release/com/deere/it/mfg/smart-test-config/${GIT_COMMIT}/smart-test-config-${GIT_COMMIT}.war --server-response --"
    		sh "cf login -a https://api.cf1.ic.deere.com -u ${CLOUD_FOUNDRY_USR} -p ${CLOUD_FOUNDRY_PSW}"
			sh "cf target -o manufacturing -s smart-test-dev"
			sh "cf push --no-start smart-test-config-devl"
            sh "cf set-env smart-test-config-devl jasypt.encryptor.password ${DB_PASSWORD_PSW}"
            sh "cf start smart-test-config-devl"
    	}
   	}
  }

  tools {
    maven 'M3'
  }
  environment {
    ARTIFACTORY = credentials('a904085-artifactory')
    GIT_COMMIT = ''
    CLOUD_FOUNDRY = credentials('a904085-cloudfoundry')
    DB_PASSWORD = credentials('smarttestdbkey')
    XLDEPLOY = credentials('a904085-cloudfoundry')
  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '10'))
    disableConcurrentBuilds()
  }
  post {
    failure {
      mail to: 'PatelChinmaya@JohnDeere.com',
      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
      body: "Something is wrong with ${env.BUILD_URL}"
    }
  }
}

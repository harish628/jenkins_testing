pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Build your project here
            }
        }
    }
    
    post {
        always {
            // Define the email recipient(s)
            def to = 'harish.gundimeda@gmail.com'
            
            // Define the email subject
            def subject = "Jenkins build ${currentBuild.fullDisplayName} has completed"
            
            // Define the email body
            def body = "Build details:\n\n" +
                       "Status: ${currentBuild.result}\n" +
                       "Duration: ${currentBuild.durationString}\n" +
                       "Build log: ${env.BUILD_URL}console\n\n" +
                       "Thanks,\n" +
                       "Jenkins"
            
            // Send the email using the Jenkins Mailer plugin
            mail to: to,
                 subject: subject,
                 body: body
        }
    }
}

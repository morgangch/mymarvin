pipelineJob('Disk Space Check') {
    definition {
        cps {
            script("""
                pipeline {
                    agent any
                    stages {
                        stage('Check Disk Space') {
                            steps {
                                sh 'df'
                            }
                        }
                    }
                }
            """.stripIndent())
        }
    }
}
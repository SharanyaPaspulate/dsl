freeStyleJob('sample_dsl') {
    
    description("Do not change this config directly.")
    label 'linux'
    authenticationToken('patchupdate')
    parameters { 
        stringParam('myEnv')
        }
    scm {
        git {
            remote {
                url("https://github.com/SharanyaPaspulate/dsl.git")
            }
            branch '*/master'
        }
    }
    // antInstallation('Ant-1.9.0')
    triggers {
        githubPush()
        scm("* * * * *")
    }

    steps {
      shell("echo hello world")
    }
    
    publishers {
        downstream('test', thresholdName = 'SUCCESS')
            }
}


freeStyleJob('sample') {
    
    description("Do not change this config directly.")
    label 'linux'
    logRotator(-1, 10000, 5, -1)
    parameters { 
    stringParam('hostname')
  }
    scm {
        git {
            remote {
                url("https://github.com/SharanyaPaspulate/dsl.git")
            }
            branch '*/master'
        }
    }
    // antInstallation('Ant-1.9.0')
    triggers {
        githubPush()
        scm("* * * * *")
    }

    steps {
      shell("echo hello SharanyaPaspulate")
    }
}

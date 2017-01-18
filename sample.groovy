freeStyleJob('sample_dsl') {
    
    description("Do not change this config directly.")
    label 'linux'
    logRotator(-1, 10000, 5, -1)
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
    postBuildSteps {
        job(String sample, Closure closure  = null)
    configure { it <<
        'runPostStepsIfResult' {
            name('SUCCESS')
        }
    }
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

job('Disk Space Check') {
    steps {
        shell('df -h')
    }
}

job('A Daily Dose of Satisfaction') {
    parameters {
        stringParam('NAME', '', 'Enter your name')
    }
    steps {
        shell('echo "Hello $NAME"')
        shell('date')
        shell('echo "This is your DDoS number $BUILD_NUMBER"')
    }
}

folder('Tools') {
    description('Folder for miscellaneous tools.')
}

job('Tools/clone-repository') {
    parameters {
        stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    wrappers {
        preBuildCleanup()
    }

    steps {
        shell('git clone $GIT_REPOSITORY_URL')
    }
}
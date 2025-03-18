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

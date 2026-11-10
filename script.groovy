def buildApp() {
    echo 'Building the application via Groovy script...'
}

def testApp() {
    echo 'Testing the application via Groovy script...'
}

def deployApp(String version, String env) {
    echo "Deploying version ${version} on ${env} via Groovy script..."
}

return this

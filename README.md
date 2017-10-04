# example-hello-world

This is the simplest possible Hypercrud application, it uses only the I/O client to talk to a Hypercrud service, bring your own UI code.

## Service

    boot build
    java -jar target/project.jar

Confirm in browser: http://localhost:8080/

    Hypercrud Server Running!

## Runtime

    yarn
    NODE_ENV=production node_modules/.bin/webpack
    boot build     # artifacts in `target`

    cd target
    python -m SimpleHTTPServer 8000

View in your browser: http://localhost:8000/

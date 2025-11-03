
# About

This java app builds a war file that can be deployed in Tomcat.

# Building

`./gradlew assemble`

Then look in build/lib for `kit-builder.war` or something. Copy that 
war to a tomcat webapps dir.

# Usage

This microservice has one route:

`/kit`

it returns a json blob that looks like this:

# Dependents
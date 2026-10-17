#!/bin/bash

set -e

set -o allexport
source .env
set +o allexport


# Run Spring Boot
mvn clean
mvn spring-boot:run

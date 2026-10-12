set -o allexport
source .env
set +o allexport

# Run maven tests
mvn clean
mvn test
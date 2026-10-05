#!/bin/bash 
export EIA_API_KEY="8ZBnp76iq8ffcJda8JdKUnmOXiu9igAuUEIdUGJi"                 
export EIA_BASE_URL="https://api.eia.gov/v2"


# Run Spring Boot
mvn clean
mvn spring-boot:run

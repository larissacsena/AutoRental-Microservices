#!/bin/bash

# Define a função para criar o API Gateway
create_api_gateway() {
    # Criar o API Gateway
    API_ID=$(aws --endpoint-url=http://localhost:4566 apigateway create-rest-api --name 'AutoRentalAPI' --query 'id' --output text)
    echo "API Gateway criado: $API_ID"

    # Obter o ID do recurso raiz
    ROOT_RESOURCE_ID=$(aws --endpoint-url=http://localhost:4566 apigateway get-resources --rest-api-id $API_ID --query 'items[0].id' --output text)

    # Criar recursos para cada serviço
    RESOURCE_RENTAL_ID=$(aws --endpoint-url=http://localhost:4566 apigateway create-resource --rest-api-id $API_ID --parent-id $ROOT_RESOURCE_ID --path-part 'rental' --query 'id' --output text)
    RESOURCE_PERSON_ID=$(aws --endpoint-url=http://localhost:4566 apigateway create-resource --rest-api-id $API_ID --parent-id $ROOT_RESOURCE_ID --path-part 'person' --query 'id' --output text)
    RESOURCE_INSURANCE_ID=$(aws --endpoint-url=http://localhost:4566 apigateway create-resource --rest-api-id $API_ID --parent-id $ROOT_RESOURCE_ID --path-part 'insurance' --query 'id' --output text)
    RESOURCE_VEHICLE_ID=$(aws --endpoint-url=http://localhost:4566 apigateway create-resource --rest-api-id $API_ID --parent-id $ROOT_RESOURCE_ID --path-part 'vehicle' --query 'id' --output text)

    # Adicionar métodos para os serviços
    # Método GET para rental-service
    aws --endpoint-url=http://localhost:4566 apigateway put-method --rest-api-id $API_ID --resource-id $RESOURCE_RENTAL_ID --http-method GET --authorization-type NONE
    aws --endpoint-url=http://localhost:4566 apigateway put-integration --rest-api-id $API_ID --resource-id $RESOURCE_RENTAL_ID --http-method GET --integration-http-method GET --type HTTP --uri "http://rental-service:8081/api/rentals"

    # Método GET para person-service
    aws --endpoint-url=http://localhost:4566 apigateway put-method --rest-api-id $API_ID --resource-id $RESOURCE_PERSON_ID --http-method GET --authorization-type NONE
    aws --endpoint-url=http://localhost:4566 apigateway put-integration --rest-api-id $API_ID --resource-id $RESOURCE_PERSON_ID --http-method GET --integration-http-method GET --type HTTP --uri "http://person-service:8083/api/persons"

    # Método GET para insurance-service
    aws --endpoint-url=http://localhost:4566 apigateway put-method --rest-api-id $API_ID --resource-id $RESOURCE_INSURANCE_ID --http-method GET --authorization-type NONE
    aws --endpoint-url=http://localhost:4566 apigateway put-integration --rest-api-id $API_ID --resource-id $RESOURCE_INSURANCE_ID --http-method GET --integration-http-method GET --type HTTP --uri "http://insurance-service:8082/api/insurances"

    # Método GET para vehicle-service
    aws --endpoint-url=http://localhost:4566 apigateway put-method --rest-api-id $API_ID --resource-id $RESOURCE_VEHICLE_ID --http-method GET --authorization-type NONE
    aws --endpoint-url=http://localhost:4566 apigateway put-integration --rest-api-id $API_ID --resource-id $RESOURCE_VEHICLE_ID --http-method GET --integration-http-method GET --type HTTP --uri "http://vehicle-service:8084/api/vehicles"

    # Deploy do API
    aws --endpoint-url=http://localhost:4566 apigateway create-deployment --rest-api-id $API_ID --stage-name prod
    echo "API Gateway configurado e implantado."
}

# Chamar a função para criar o API Gateway
create_api_gateway

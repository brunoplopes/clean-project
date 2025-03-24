## Para subir a aplicação local com Datadog

Crie uma conta na região **US5 - Central** para ativar plano FREE

    https://us5.datadoghq.com/account/login?next=%2F
    
Com a APP_KEY criada, altere o arquivo docker-compose.yml.

    ...
    datadog:
        image: "gcr.io/datadoghq/agent:7"
        environment:
          - DD_API_KEY=${DATADOG_APP_KEY}
    ...

Para criar a applicationKey 

    https://docs.datadoghq.com/account_management/api-app-keys/
    

Crie um arquivo local.env para configurar as variáveis do docker-compose

    AWS_DEFAULT_REGION=us-east-1
    AWS_REGION=us-east-1
    AWS_ACCESS_KEY_ID=XXXXX
    AWS_SECRET_ACCESS_KEY=XXXX
    DATADOG_APPLICATION_KEY=XXXXXXXXXXX
    DATADOG_APP_KEY=XXXXXXXXXXXXXXXXXX

Para subir o Datadog e localstack execute

    docker compose --env-file local.env up


Configure as ENVs abaixo para subir a aplicação

    DATADOG_APPLICATION_KEY=XXXXXXXXXXXXXXXXX
    DATADOG_APP_KEY=XXXXXXXXXXXXXXXXXX


Informe os parametros abaixo para subir e rodar com profile local

    spring-boot:run -Dspring-boot.run.profiles=local





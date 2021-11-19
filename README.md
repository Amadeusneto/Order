# API Order

## Tecnologias utilizadas
 - [X] Springboot
 - [X] Spring Data
 - [X] Docker
 - [X] Maven
 - [X] JUnit
 - [X] Cucumber
 - [X] Mockito
 - [X] Swagger
 

***
### Testes Funcionais com Cucumber
Fora realizado a execução de testes funcionais por meio do Cucumber.
Segue algumas razões pelo qual escolher testes com cucumber:

 - Linguagem mais próxima ao cliente, mostrando os passos executados para testar.
 - Facilidade ao escrever testes, pois ficam bem estruturados, etc.

Para rodar os testes deverá ser executado a classe RunCucumberTest.

***

***
### Testes Unitários com JUnit
Fora realizado a execução de testes unitários por meio do JUnit.
Segue algumas razões pelo qual escolher testes com JUnit:

- Junit é uma estrutura de teste amplamente usada em conjunto com a linguagem de programação Java.
- Facilidade na estruturação de automação para os testes de unidade e de interface do usuário.
- Ajuda a definir o fluxo de execução do código com diferentes anotações.

Para rodar os testes deverá ser executado as classes:

- BaseOrderPlaceServiceTest
- CreateOrderServiceTest
- DeleteOrderServiceTest
- FindOrderServiceTest
- UpdateOrderServiceTest

***


## Documentação

### Exemplo do uso do endpoint

 - Obs: Os endpoints podem ser executados no serviço do Swagger da seguinte URL: http://localhost:8080/swagger-ui.html

#### POST 
- Endpoint: /v1/orders

```
{
    "id": "1",
    "controlNumber": "3",
    "registrionDate": "18-11-2021",
    "name": "PIZZA",
    "valor": 23.5,
    "quantity": 5,
    "clientCode": 10
}
```

***


### Deploy com docker

Fora aplicado uma imagem Docker com Alpine, dado que é a imagem mais limpa e mais otimizada para manter 
a aplicação.

Para fazer o deploy da aplicação e execução do projeto via container utilizando docker, deverá executar 
os passos abaixo no terminal:

```
./mvnw clean package -DskipTests

docker-compose up -d
```
Após a conclusão validar se o container estará disponível no endereço: http://localhost:8080/swagger-ui.html

***

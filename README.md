<h1 align="center">
Teste de seleção para vaga de Java
</h1>

# 💻 Tecnologia utilizada:

![Badge](https://img.shields.io/badge/Swagger-springdoc--openapi--ui%201.6.9-green)
![Badge](https://img.shields.io/badge/Springboot-2.7.1-green)
![Badge](https://img.shields.io/badge/H2-dba-green)
<!--ts-->
   * [Spring boot](https://spring.io/)
   * [Swagger](http://localhost:8080/swagger-ui/index.html#/)
   * [H2](http://localhost:8080/h2-console/login.jsp?jsessionid=b5181ad0d167adf0e9050d58dab9d426)
   * [Actuator](http://localhost:8080/actuator/health)
<!--te-->

<!--ts-->
# 🌐 Como acessar
## Após inicializar o Spring boot:
  * [Clique aqui](http://localhost:8080/h2-console/login.jsp?jsessionid=b5181ad0d167adf0e9050d58dab9d426) para acessar a database do H2
    * (JDBC URL: jdbc:h2:mem:testdb)
    * ```http://localhost:8080/h2-console/login.jsp?jsessionid=b5181ad0d167adf0e9050d58dab9d426```
  * [Clique aqui](http://localhost:8080/swagger-ui/index.html#/) Para acesssar o swagger
    * ```http://localhost:8080/swagger-ui/index.html#/```
<!--te-->

# 💠 [Pré-requisitos](https://github.com/cd2tec/JavaTest)

### Regras de negócio:
  - [x] CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
  - [x] CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
  - [x] CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
  - [x] O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
  - [x] input de entrada deve ser “peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“
  - [x] anotações: @Repository, @Entity e @Controller
  - [x] Documentação API (Swagger)
  - [x] Endpoint
    - Possuir: “vlTotalFrete” e “dataPrevistaEntrega”, “cepOrigem” e “cepDestino”
    - Ser persistido no banco os valores da cotação os valores consultados: “peso”, “cepOrigem”, “cepDestino”, “nomeDestinatario”, “vlTotalFrete”, “dataPrevistaEntrega” e “dataConsulta”
- ### Critérios de avaliação:
  - [x] Implementação das regras de negócios para o cálculo do frete
  - [x] Boas práticas de programação, arquitetura e padrões de projetos



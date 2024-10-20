# Desafio Microserviços Solutis
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-green)
![Static Badge](https://img.shields.io/badge/aws-amazon-orange)





## Sobre o projeto

Este repositório contém a resolução do Desafio de Refatoração para microserviços,
desenvolvido como parte do processo de admissão para o programa Solutis Dev Trail 2024.

## Tecnologias Utilizadas
- Spring Boot:
  
Utilizado para a criação dos microserviços.

- Spring Cloud:
  
Facilita a gestão de microserviços, incluindo service discovery, configuração distribuída, entre outros.

- Spring Data JPA:
  
Para persistência de dados.

- API Gateway:
  
Para roteamento de requisições aos serviços corretos.

- Eureka ou Consul:
  
Para Service Discovery.

- SQS ou Kafka:
  
Utilizados para a mensageria e comunicação assíncrona entre microserviços.

## Arquitetura de Microserviços

![ms (2)](https://github.com/user-attachments/assets/614fadf7-905c-446a-a370-1eec4f10467d)

### Estrutura de Microserviços

### 1. Serviço de Pessoas (PessoaService)

Responsável por gerenciar as informações de pessoas, como motoristas e funcionários.

### Entidades:
- `Pessoa` (classe base)
- `Motorista`
- `Funcionario`

### Endpoints:
- `GET /pessoas/{id}`: Obtém os dados de uma pessoa pelo ID.
- `POST /pessoas`: Cria uma nova pessoa.
- `PUT /pessoas/{id}`: Atualiza uma pessoa existente.
- `DELETE /pessoas/{id}`: Remove uma pessoa do sistema.

### Banco de Dados:
- Tabela central para armazenar os dados compartilhados.
- Tabelas específicas para motoristas e funcionários.

---

### 2. Serviço de rentalModel (rentalModel)

Gerencia os aluguéis de veículos.

### Entidades:
- `rentalModel`
- `ApoliceSeguro` (relacionada a cada rentalModel)

### Endpoints:
- `GET /alugueis/{id}`: Obtém os dados de um rentalModel.
- `POST /alugueis`: Registra um novo rentalModel.
- `PUT /alugueis/{id}`: Atualiza um rentalModel existente.
- `DELETE /alugueis/{id}`: Exclui um rentalModel.

### Banco de Dados:
- Tabelas para armazenar aluguéis e apólices de seguro.

---

### 3. Serviço de Veículos (VeiculoService)

Gerencia os veículos disponíveis para rentalModel.

### Entidades:
- `Carro`
- `Acessorio`
- `ModeloCarro`
- `Fabricante`

### Endpoints:
- `GET /veiculos/{id}`: Obtém os dados de um veículo.
- `POST /veiculos`: Adiciona um novo veículo.
- `PUT /veiculos/{id}`: Atualiza os dados de um veículo.
- `DELETE /veiculos/{id}`: Remove um veículo.
- `GET /veiculos/{id}/acessorios`: Lista os acessórios disponíveis para o veículo.

### Banco de Dados:
- Tabelas separadas para carros, acessórios, modelos e fabricantes.

---

### 4. Serviço de Catálogo (CatalogoService)

Gerencia as categorias de veículos.

### Endpoints:
- `GET /categorias`: Lista todas as categorias.
- `POST /categorias`: Cria uma nova categoria.
- `PUT /categorias/{id}`: Atualiza uma categoria existente.
- `DELETE /categorias/{id}`: Remove uma categoria.

### Banco de Dados:
- Tabela única para armazenar categorias de veículos.

---

### 5. Serviço de Seguros (SeguroService)

Gerencia as apólices de seguro associadas aos aluguéis.

### Endpoints:
- `GET /seguros/{id}`: Obtém os dados de uma apólice de seguro.
- `POST /seguros`: Cria uma nova apólice de seguro.
- `PUT /seguros/{id}`: Atualiza uma apólice existente.
- `DELETE /seguros/{id}`: Exclui uma apólice de seguro.

### Banco de Dados:
- Tabela dedicada para armazenar as apólices de seguro.

---

### Comunicação entre Microserviços

### API Gateway:
- Gerencia todas as requisições externas e roteia para o serviço apropriado.

### Serviço de Mensageria:
- Comunicação assíncrona entre os microserviços para eventos como "rentalModel criado" ou "apólice gerada". Tecnologias sugeridas incluem Amazon SQS ou Apache Kafka.

### Banco de Dados:
- Cada microserviço possui seu próprio banco de dados para garantir independência e consistência, seguindo o padrão de `database per service`.



## Estrutura do Projeto
```
locadora-veiculos/            <- Diretório raiz do projeto de locadora de veículos.
│
├── pessoa-service/            <- Serviço para gerenciamento de pessoas (Motoristas e Funcionários).
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/pessoa/
│   │   │   │       ├── controller/    <- Contém os controladores da API de pessoas.
│   │   │   │       ├── model/         <- Contém as classes de modelo (entidades).
│   │   │   │       ├── service/       <- Lógica de negócio do serviço de pessoas.
│   │   │   │       ├── repository/    <- Interfaces de persistência (repositories).
│   │   │   │       └── PessoaServiceApplication.java  <- Classe principal do serviço de pessoas.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do serviço de pessoas.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o serviço de pessoas.
│
├── rentalModel-service/            <- Serviço para gerenciamento de aluguéis.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/rentalModel/
│   │   │   │       ├── controller/    <- Controladores da API de aluguéis.
│   │   │   │       ├── model/         <- Entidades relacionadas a aluguéis.
│   │   │   │       ├── service/       <- Lógica de negócio do serviço de aluguéis.
│   │   │   │       ├── repository/    <- Repositórios de persistência de dados.
│   │   │   │       └── AluguelServiceApplication.java  <- Classe principal do serviço de aluguéis.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do serviço de aluguéis.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o serviço de aluguéis.
│
├── veiculo-service/            <- Serviço para gerenciamento de veículos, acessórios, modelos e fabricantes.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/veiculo/
│   │   │   │       ├── controller/    <- Controladores da API de veículos.
│   │   │   │       ├── model/         <- Entidades relacionadas a veículos.
│   │   │   │       ├── service/       <- Lógica de negócio do serviço de veículos.
│   │   │   │       ├── repository/    <- Repositórios de persistência de dados.
│   │   │   │       └── VeiculoServiceApplication.java  <- Classe principal do serviço de veículos.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do serviço de veículos.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o serviço de veículos.
│
├── catalogo-service/            <- Serviço para gerenciamento de categorias de veículos.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/catalogo/
│   │   │   │       ├── controller/    <- Controladores da API de categorias.
│   │   │   │       ├── model/         <- Entidades relacionadas a categorias.
│   │   │   │       ├── service/       <- Lógica de negócio do serviço de categorias.
│   │   │   │       ├── repository/    <- Repositórios de persistência de dados.
│   │   │   │       └── CatalogoServiceApplication.java  <- Classe principal do serviço de categorias.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do serviço de categorias.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o serviço de categorias.
│
├── seguro-service/            <- Serviço para gerenciamento de apólices de seguro.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/seguro/
│   │   │   │       ├── controller/    <- Controladores da API de seguros.
│   │   │   │       ├── model/         <- Entidades relacionadas a apólices de seguro.
│   │   │   │       ├── service/       <- Lógica de negócio do serviço de seguros.
│   │   │   │       ├── repository/    <- Repositórios de persistência de dados.
│   │   │   │       └── SeguroServiceApplication.java  <- Classe principal do serviço de seguros.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do serviço de seguros.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o serviço de seguros.
│
├── api-gateway/            <- API Gateway para rotear as requisições entre os microserviços.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/apigateway/
│   │   │   │       └── ApiGatewayApplication.java  <- Classe principal do API Gateway.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do API Gateway.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o API Gateway.
│
├── eureka-server/            <- Eureka Server para service discovery.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/eureka/
│   │   │   │       └── EurekaServerApplication.java  <- Classe principal do Eureka Server.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do Eureka Server.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o Eureka Server.
│
├── config-server/            <- Spring Cloud Config Server para configuração centralizada.
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/locadora/configserver/
│   │   │   │       └── ConfigServerApplication.java  <- Classe principal do Config Server.
│   │   │   └── resources/
│   │   │       ├── application.yml    <- Configurações do Config Server.
│   │   │       └── ...                <- Outros arquivos de recursos.
│   ├── pom.xml                        <- Arquivo de configuração do Maven para o Config Server.
│
└── pom.xml                  <- Arquivo Maven pai para gerenciar dependências e build de todos os serviços.
```

## Desenvolvimento

Este projeto foi desenvolvido em colaboração por uma equipe de 7 pessoas.
Cada membro contribuiu com a implementação e validação das soluções propostas para os exercícios.

### Membros da Equipe

- **Alice Lima** - https://github.com/alsoares086 

- **Larissa Sena** - https://github.com/larissacsena

- **Pietra Almeida** - https://github.com/almeidapietra

- **Vinícius Almada** - https://github.com/AlmadaAlmada

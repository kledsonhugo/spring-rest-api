# Spring REST API

Este projeto é uma API REST desenvolvida com **Spring Boot** e **Java 17**. Ele fornece endpoints para gerenciar informações de clientes e seus investimentos. A API também está documentada com **Swagger** para facilitar a exploração e o uso.

## Resumo

A API permite:
- Listar todos os clientes cadastrados.
- Buscar informações de um cliente específico.
- Listar os investimentos de um cliente.

## Endpoints Disponíveis

### Clientes
- **`GET /api/clientes`**  
  Retorna a lista de todos os clientes cadastrados.

- **`GET /api/clientes/{id}`**  
  Retorna as informações de um cliente específico com base no `id`.

- **`GET /api/clientes/{id}/investimentos`**  
  Retorna a lista de investimentos realizados por um cliente específico com base no `id`.

## Como Usar a API

### Requisitos
- **Java 17** ou superior
- **Maven** instalado

### Passos para Executar
1. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd spring-rest-api
   ```

2. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Acesse a API em `http://localhost:8080`.

### Autenticação

A API utiliza autenticação básica. Use as credenciais abaixo para acessar os endpoints protegidos:

- **Usuário**: `admin`
- **Senha**: `password`

### Documentação Interativa com Swagger

A API está documentada com Swagger. Você pode acessar a interface interativa em:
```
http://localhost:8080/swagger-ui/index.html
```

### Exemplos de Uso

#### Listar todos os clientes
```bash
curl -u admin:password -X GET http://localhost:8080/api/clientes
```

#### Buscar informações de um cliente específico
```bash
curl -u admin:password -X GET http://localhost:8080/api/clientes/1
```

#### Listar investimentos de um cliente específico
```bash
curl -u admin:password -X GET http://localhost:8080/api/clientes/1/investimentos
```

## Estrutura do Projeto

- **`/src/main/java/com/example/springrestapi/model`**  
  Contém as classes de modelo, como `Cliente` e `Investimento`.

- **`/src/main/java/com/example/springrestapi/service`**  
  Contém a lógica de negócios, como a manipulação de clientes e investimentos.

- **`/src/main/java/com/example/springrestapi/controller`**  
  Contém os controladores que expõem os endpoints da API.

- **`/src/main/java/com/example/springrestapi/config`**  
  Contém configurações adicionais, como a configuração do Swagger e segurança.

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT.
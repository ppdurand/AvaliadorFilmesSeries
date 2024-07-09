# Projeto de Sistema de Autenticação e Avaliação de Filmes

## Visão Geral

Este projeto é uma aplicação web RESTful desenvolvida em Java usando o framework Spring Boot. A aplicação oferece funcionalidades de autenticação de usuários, registro de novos usuários, gestão de logs de avaliações de filmes, e consulta de informações sobre filmes.

Observação: Projeto ainda em construção

### Tópicos 
- [Endpoints](#Endpoints)
- [API Externa](#api-externa)

## Endpoints

### AuthenticationController

- `POST /auth/login`: Autentica um usuário com base nas credenciais fornecidas.
  - **Request Body**: `AuthenticationDTO` (username, password)
  - **Response**: Token de autenticação
  - **Role**: Aberto para todos

- `POST /auth/register`: Registra um novo usuário.
  - **Request Body**: `RegisterUserDTO` (username, password, role, name, bio)
  - **Response**: Mensagem de sucesso ou erro
  - **Role**: Aberto para todos

### LogController

- `GET /log`: Retorna todos os logs de avaliações.
  - **Response**: Lista de logs
  - **Role**: Apenas usuários administradores podem acessar esse endpoint

- `POST /log/newLog/{title}`: Cria um novo log de avaliação para um filme específico.
  - **Path Variable**: `title` (título do filme)
  - **Request Params**: `stars` (nota), `critic` (crítica), `userId` (ID do usuário)
  - **Response**: Mensagem de sucesso ou erro
  - **Role**: Qualquer usuário autenticado pode acessar esse endpoint

- `DELETE /log/delete/{id}`: Exclui um log de avaliação pelo ID.
  - **Path Variable**: `id` (ID do log)
  - **Response**: Void
  - **Role**: Qualquer usuário autenticado pode acessar esse endpoint

### MovieController

- `GET /api/search/{title}`: Busca informações sobre um filme pelo título.
  - **Path Variable**: `title` (título do filme)
  - **Response**: Informações do filme
  - **Role**: Apenas usuários administradores podem acessar esse endpoint


### UserController

- `GET /users`: Retorna todos os usuários registrados.
  - **Response**: Lista de usuários
  - **Role**: Apenas usuários administradores podem acessar esse endpoint


- `PUT /users/edit/{id}`: Atualiza informações de um usuário específico.
  - **Path Variable**: `id` (ID do usuário)
  - **Request Params**: `name` (nome), `bio` (biografia)
  - **Response**: Void
  - **Role**: Qualquer usuário autenticado pode acessar esse endpoint

- `DELETE /users/delete/{id}`: Exclui um usuário pelo ID.
  - **Path Variable**: `id` (ID do usuário)
  - **Response**: Void
  - **Role**: Qualquer usuário autenticado pode acessar esse endpoint
 
  ## API Externa
  Este projeto consome uma API Externa, a OMDB, que fornece informações sobre filmes e séries registrados no IDMB

  - Documentação da API: https://www.omdbapi.com
  - Chave da API: Para conseguir sua chave da API e utilizar nesse projeto, basta se cadastrar no site e mandaram uma chave via e-mail
 
  ## Camada de Segurança
  O projeto possui uma camada de segurança que autentica os usuários e autoriza o acessso a determinadas funcionalidades a determinados usuários.
  Tecnologias usadas: Spring Security 6 e JWT token

  Endpoints que qualquer pessoa pode acessar:
  - POST /auth/login
  - POST /auth/register
 
  Para todos os outros Endpoints, basta o usuario estar autenticado. Porém, "GET /api/search/{title}", endpoint que faz contato direto com a OMDB API, éreservado administradores

  

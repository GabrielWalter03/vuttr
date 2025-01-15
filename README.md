# api-vuttr

Este projeto é uma API desenvolvida com Spring Boot para gerenciar ferramentas (tools) no estilo do "VUTTR" (Very Useful Tools List). Ele permite criar, ler, atualizar e deletar ferramentas de forma simples e eficiente.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Docker**

## Funcionalidades

A API implementa um conjunto básico de operações CRUD (Create, Read, Update, Delete) para o gerenciamento de ferramentas:

- **POST /tools**: Criar uma nova ferramenta.
- **GET /tools**: Listar todas as ferramentas.
- **GET /tools/{id}**: Obter uma ferramenta específica pelo ID.
- **PUT /tools/{id}**: Atualizar uma ferramenta existente.
- **DELETE /tools/{id}**: Deletar uma ferramenta pelo ID.

## Pré-requisitos

Antes de começar, verifique se você tem os seguintes itens instalados:

- **Java 17 ou superior**: [Instalar Java](https://openjdk.java.net/)
- **Docker**: [Instalar Docker](https://www.docker.com/get-started)
- **MySQL** (para o banco de dados): [Instalar MySQL](https://dev.mysql.com/downloads/installer/)

## Body
{
  "title": "Editor de Texto",
  "link": "https://example.com",
  "description": "Ferramenta útil para edição de texto.",
  "tags": ["editor", "texto", "programação"]
}


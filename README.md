# CRUD - Java

Este projeto é um exemplo de aplicação CRUD (Create, Read, Update, Delete) em Java, utilizando JavaFX para a interface gráfica e JDBC para a interação com o banco de dados.

## Funcionalidades

- Adicionar novos registros
- Listar registros existentes
- Editar registros
- Excluir registros

## Estrutura do Projeto

- `src/main/java/com/example/connection`: Contém classes de conexões com o banco de dados.
- `src/main/java/com/example/controller`: Contém os controladores da aplicação, responsáveis por gerenciar a interação entre a interface gráfica e a lógica de negócios.
- `src/main/java/com/example/dao`: Contém as classes de acesso a dados (DAO), responsáveis por realizar operações no banco de dados.
- `src/main/java/com/example/forms`: Contém as classes de modelo, que representam os dados da aplicação.
- `src/main/java/com/example/helper`: Contém classes auxiliares, como validações.
- `src/main/java/com/example/icons`: Contém as imagens e icones utilizados pela interface gráfica.
- `src/main/java/com/example/styles`: Contém os arquivos de estilo (.CSS).
- `src/main/java/com/example/view`: Contém os arquivos FXML e outros recursos utilizados pra interface gráfica.

## TO-DOs

- `src/main/java/com/example/styles/Register.css`
- O arquivo de estilo (.CSS) foi editado apenas para uma melhor visualização na hora de montar o FXML e codar;

## Requisitos

- Java 11 ou superior
- JavaFX 11 ou superior

## Configuração

1. Clone o repositório:
    ```sh
    git clone https://github.com/FakeKus/CRUD-Java.git
    ```

2. Importe o projeto em sua IDE de preferência (Eclipse, IntelliJ, etc.).

3. Configure a conexão com o banco de dados no arquivo `ConnectionFactory.java`:
    ```java
    // Exemplo de configuração para MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";
    ```

- `DB/crud.db`: Por padrão já vem configurado pra acesar uma tabela Local criada com SQLite:

4. Execute a aplicação a partir da classe principal (Main.java).

## Uso

### Adicionar um novo registro

1. Clique no botão "Adicionar".
2. Preencha os campos do formulário.
3. Clique no botão "Salvar".

### Editar um registro existente

1. Selecione um registro na tabela.
2. Clique no botão "Editar".
3. Altere os campos desejados.
4. Clique no botão "Salvar".

### Excluir um registro

1. Selecione um registro na tabela.
2. Clique no botão "Excluir".

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.


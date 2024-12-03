# Pokémon Info Viewer

## Descrição do Projeto

O **Pokémon Info Viewer** é uma aplicação web desenvolvida em **Spring Boot** que consome dados da [PokeAPI](https://pokeapi.co). O objetivo do projeto é permitir que os usuários pesquisem informações detalhadas sobre qualquer Pokémon pelo nome, utilizando uma interface simples e intuitiva.

Este projeto faz parte de um trabalho acadêmico para consolidar conhecimentos em **Programação Orientada a Objetos** e explorar as funcionalidades do **Spring Framework**, com foco no consumo de APIs externas utilizando o **Spring WebClient**.

---

## Funcionalidades

- Busca por Pokémon pelo nome.
- Exibição de informações detalhadas do Pokémon, incluindo:
    - ID na Pokédex.
    - Nome
    - Peso e altura.
- Tratamento de erros, como Pokémon não encontrado.

---

## Tecnologias Utilizadas

- **Java 17** (ou superior)
- **Spring Boot** 3.x
    - **Spring WebClient**: Consumo da PokeAPI.
    - **Thymeleaf**: Renderização do front-end.
- **Maven**: Gerenciamento de dependências.
- **Git/GitHub**: Controle de versão.
- **IDE**: IntelliJ IDEA, Eclipse, ou outra IDE Java.

---

## Arquitetura Proposta

### Visão Geral
A aplicação segue o padrão **MVC (Model-View-Controller)** para organizar as responsabilidades:

- **Model**: Representação dos dados do Pokémon retornados pela PokeAPI.
- **Controller**: Lida com requisições do usuário e chama os serviços necessários.
- **Service**: Realiza a comunicação com a PokeAPI e processa os dados.
- **View**: Renderiza as informações usando Thymeleaf.

### Fluxo de Dados
1. O usuário insere o nome do Pokémon na interface web.
2. A requisição é enviada ao **Controller**.
3. O **Controller** chama o **Service**, que utiliza o **Spring WebClient** para buscar os dados na PokeAPI.
4. Os dados retornados são processados e enviados para a **View**.
5. A interface exibe as informações ao usuário.

### Diagrama de Componentes

    Usuário (Browser)
       ↓
    [Front-End (HTML/Thymeleaf)]
       ↓
    [Controller (Spring Boot)]
       ↓
    [Service (Spring Boot - WebClient)]
       ↓
    [PokeAPI]

---

## Protótipo Básico

### Wireframe Inicial

#### Página Inicial:
- Campo de texto para busca por nome de Pokémon.
- Botão "Buscar".

#### Página de Resultados:
- Nome e ID do Pokémon.
- Estatísticas básicas.

---

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone <https://github.com/PudimTI/app_pokemon.git>
   cd pokemon-info-viewer
2. Certifique-se de ter o **Java 17** e o **Maven** instalados.

3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
4. Acesse a aplicação no navegador:
   ```bash
   http://localhost:8080

---

## Contribuidores

- Gabriel Janotto Pereira
- João Pedro Vaz dos Santos Silva
- Kelvyn Cortez Lovato

---


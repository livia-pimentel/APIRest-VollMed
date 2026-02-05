# Voll.med API 🩺

A **Voll.med** é uma API Rest desenvolvida em Spring Boot para a gestão de clínica médica. O projeto foca em organizar o fluxo de trabalho entre médicos e pacientes, garantindo integridade de dados e performance.

---

## 🛠️ Tecnologias e Ferramentas

O projeto utiliza as melhores práticas do ecossistema Java:

* **Java 17+**
* **Spring Boot 4.0.2**
* **Spring Data JPA**: Abstração de persistência.
* **MySQL**: Banco de dados relacional.
* **Flyway**: Controle de versionamento do banco de dados (Migrations).
* **Lombok**: Redução de código boilerplate (getters, setters, construtores).
* **Bean Validation (Hibernate Validator)**: Regras de validação de dados nos DTOs.
* **Maven**: Gerenciamento de dependências.

---

## 🚀 Funcionalidades

A API fornece um CRUD completo para as seguintes entidades:

### 👨‍⚕️ Médicos
* **Cadastro:** Validação automática de CRM e especialidade.
* **Listagem:** Retorno paginado e ordenado.
* **Atualização:** Edição de dados específicos (nome, telefone, endereço).
* **Exclusão Lógica:** Mantém o histórico no banco, mas inativa o registro para a API.

### 👩‍Pacientes
* **Cadastro:** Controle de CPF e dados de contato.
* **Listagem:** Exibição detalhada dos pacientes ativos.
* **Atualização:** Manutenção de endereços e contatos.
* **Exclusão:** Sistema de inativação (Soft Delete).

---

## 🏗️ Configuração do Ambiente

Para rodar o projeto localmente, siga estes passos:

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/livia-pimentel/APIRest-VollMed.git](https://github.com/livia-pimentel/APIRest-VollMed.git)
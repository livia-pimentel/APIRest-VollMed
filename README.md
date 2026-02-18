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

A API fornece um sistema completo de gestão e agendamento:

### 👨‍⚕️ Médicos
* **Cadastro:** Validação automática de CRM e especialidade.
* **Listagem:** Retorno paginado e ordenado.
* **Atualização:** Edição de dados específicos (nome, telefone, endereço).
* **Exclusão Lógica:** Mantém o histórico no banco, mas inativa o registro para a API.

### 👩‍💼 Pacientes
* **Cadastro:** Controle de CPF e dados de contato.
* **Listagem:** Exibição detalhada dos pacientes ativos.
* **Atualização:** Manutenção de endereços e contatos.
* **Exclusão:** Sistema de inativação (Soft Delete).

### 📅 Agendamento de Consultas
* **Agendamento:** Permite marcar consultas escolhendo médico, paciente e data.
* **Escolha de Médico:** Caso um médico específico não seja escolhido, o sistema seleciona automaticamente um médico disponível da especialidade desejada.
* **Cancelamento:** Permite o cancelamento de consultas, exigindo a justificativa do motivo (paciente desistiu, médico cancelou, outros).

---

## ⚖️ Regras de Negócio (Agendamento)

O sistema conta com validações rigorosas para garantir a consistência das agendas:

* **Antecedência:** Consultas devem ser agendadas com no mínimo 30 minutos de antecedência.
* **Horário de Funcionamento:** A clínica atende de segunda a sábado, das 07:00 às 19:00.
* **Paciente Ativo:** Apenas pacientes ativos no sistema podem agendar consultas.
* **Médico Ativo:** Apenas médicos ativos podem ter consultas agendadas.
* **Conflitos de Horário:** O sistema impede que um médico ou paciente tenha duas consultas no mesmo horário.
* **Limite Diário:** O paciente não pode agendar mais de uma consulta no mesmo dia.
* **Regra de Cancelamento:** Uma consulta só pode ser cancelada com antecedência mínima de 24 horas.

---

## 🏗️ Configuração do Ambiente

Para rodar o projeto localmente, siga estes passos:

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/livia-pimentel/APIRest-VollMed.git

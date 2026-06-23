# Lead Scoring Engine

API REST para pontuação automática de leads de marketing, construída com Java 21 e Spring Boot 3.

🚀 **Deploy disponível em:** [lead-scoring-engine-up38.onrender.com](https://lead-scoring-engine-up38.onrender.com)

> O plano gratuito do Render adormece após 15 minutos de inatividade. A primeira requisição pode levar até 50 segundos para o serviço acordar.

---

## O problema que resolve

Times de marketing gastam horas qualificando leads manualmente. Este sistema automatiza esse processo recebendo os dados de um lead e retornando instantaneamente uma pontuação e classificação baseada em critérios de negócio configuráveis, permitindo que o time de vendas priorize os contatos com maior potencial de conversão.

---

## Como funciona

O sistema aplica regras de pontuação sobre os atributos do lead, como cargo, setor, origem da campanha e comportamento no site. Com base na soma dos pontos, o lead é classificado automaticamente como **HOT**, **WARM** ou **COLD**.

A lógica de pontuação é implementada com **Records do Java 21** combinados com **Predicates funcionais**, uma abordagem idiomática do Java moderno que permite definir regras de negócio como objetos imutáveis e composíveis, com checagem de tipos em tempo de compilação.

---

## Tecnologias

- Java 21 LTS
- Spring Boot 3
- Maven
- Docker
- Render (deploy contínuo via push na branch main)

---

## Endpoint

### POST /api/leads/score

**Request:**
```json
{
    "nome": "João Silva",
    "cargo": "diretor",
    "setor": "tecnologia",
    "origemCampanha": "linkedin",
    "visitouPagina": true,
    "baixouMaterial": true
}
```

**Response:**
```json
{
    "nomeLead": "João Silva",
    "score": 100,
    "classificacao": "HOT",
    "criteriosAplicados": [
        "Cargo de alto nível: +30 pontos",
        "Setor tech: +20 pontos",
        "Origem LinkedIn: +15 pontos",
        "Visitou página: +10 pontos",
        "Baixou material: +25 pontos"
    ]
}
```

---

## Regras de pontuação

| Critério | Pontos |
|----------|--------|
| Cargo diretor ou CEO | +30 |
| Cargo gerente | +20 |
| Setor tecnologia | +20 |
| Origem LinkedIn | +15 |
| Baixou material | +25 |
| Visitou página | +10 |

## Classificação

| Score | Classificação |
|-------|---------------|
| 70 ou mais | HOT |
| 40 a 69 | WARM |
| Abaixo de 40 | COLD |

---

## Como rodar localmente

```bash
# Clone o repositório
git clone https://github.com/Gustassis/lead-scoring-engine

# Entre na pasta
cd lead-scoring-engine

# Rode o projeto
./mvnw spring-boot:run
```

---

## Estrutura do projeto

```
src/
└── main/
    └── java/
        └── com/leadscoring/
            ├── LeadScoringEngineApplication.java
            ├── LeadController.java
            ├── Lead.java
            ├── ScoreResult.java
            └── LeadScoringService.java
```

---

## Sobre o desenvolvimento

Este projeto faz parte do desafio **#100DaysOfCodeWithAngie**, 100 dias de estudo contínuo de Java.

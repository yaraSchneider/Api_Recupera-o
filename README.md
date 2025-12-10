# 🚚 API de Cálculo de Fretes — Recuperação de Programação Orientada a Objetos

Esta aplicação foi desenvolvida como parte da **Prova de Recuperação de Programação Orientada a Objetos**, atendendo aos requisitos de:

- ✔️ Polimorfismo  
- ✔️ Princípio Aberto/Fechado (OCP)  
- ✔️ Encapsulamento  
- ✔️ Manipulação de arquivos (log)  
- ✔️ API REST com Spring Boot  
- ✔️ Documentação com Swagger  
- ✔️ Tratamento de erros  
- ✔️ Boas práticas e organização de código  

A API simula o cálculo de fretes para uma transportadora, permitindo a adição de novos tipos de frete sem modificar o código já existente.

---

# 📸 Tela da Aplicação Rodando

A aplicação inicia corretamente na porta **9090**, conforme imagem abaixo:

<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/fe128e0e-d669-45c9-8201-61e15a03ff4a" />

---

# 📂 Arquitetura do Projeto

```
src/main/java
└── com.recuperacao.API
    ├── controller
    │     └── FreteController.java
    ├── service
    │     ├── FreteService.java
    │     ├── FreteEconomico.java
    │     ├── FreteExpresso.java
    │     └── FreteFactory.java
    ├── model
    │     ├── Pedido.java
    │     └── ResultadoFrete.java
    └── util
          └── LogWriter.java
```

A API estará disponível em:

➡ **http://localhost:9090**

---

# 📝 Endpoints da API

## 🔵 POST `/api/fretes/calcular`
Calcula o frete com base na distância e no tipo informado.

### ✔️ 1. Frete Econômico  
**POST →** `http://localhost:9090/api/fretes/calcular`

**Body:**
```json
{
  "distancia": 100,
  "tipoFrete": "economico"
}
```

---

### 🔴 2. Frete Expresso  
**POST →** `http://localhost:9090/api/fretes/calcular`

**Body:**
```json
{
  "distancia": 200,
  "tipoFrete": "expresso"
}
```

---

### ⚠️ 3. Exemplo de Erro  
**POST →** `http://localhost:9090/api/fretes/calcular`

**Body:**
```json
{
  "distancia": -50,
  "tipoFrete": "economico"
}
```

A API retorna:
```
"Distância deve ser maior que zero."
```

---

## 📘 GET `/api/fretes/tabela`
Retorna os tipos de frete disponíveis.

---

# 📚 Documentação — Swagger

Acesse em:

➡ **http://localhost:9090/swagger-ui.html**

# Vegan-Food


Uma API para sistema de controle de gastos pessoais.

## Endpoints

- Despesas
    - [cadastrar](#cadastrar-despesas)
    - apagar
    - listar todas
    - alterar
    - [mostrar detalhes](#detalhes-da-despesa)
- Contas
    - cadastrar
    - apagar
    - listar todas
    - alterar
    - mostrar detalhes

---

### Cadastrar Despesas

`POST` /meujulius/api/despesa

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|valor | decimal | sim | o valor da despesa, deve ser maior que zero
|data | data | sim | a data da despesa
|conta_id| int | sim | o id da conta previamente cadastrada
|categoria_id | int | sim | o id de uma categoria previamente cadastrada
| descricao | texto | não | um texto sobre a despesa

**Exemplo de corpo de requisição**

```js
{
    valor: 100.00,
    data: '2023-03-03',
    conta_id: 1,
    categoria_id: 1,
    descricao: "conta de luz do estabelecimento"

    {
    valor: 50.00,
    data: '2023-03-03',
    conta_id: 2,
    categoria_id: 2,
    descricao: "conta de agua do estabelecimento"

    valor: 300.00,
    data: '2023-03-03',
    conta_id: 3,
    categoria_id: 3,
    descricao: "potes termicos para que podem ir no freezer para o microondas"

    valor: 2000.00,
    data: '2023-03-03',
    conta_id: 4,
    categoria_id: 4,
    descricao: "gasto com mercado e feiras mensal"

    valor: 1800.00,
    data: '2023-03-03',
    conta_id: 5,
    categoria_id: 5,
    descricao: "funcionario ajudante de cozinha"
}
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | despesa cadastrada com sucesso
| 400 | campos inválidos

----

### Detalhes da Despesa

`GET` /meujulius/api/despesa/{id}

**Exemplo de corpo de resposta**

```js
{
    valor: 100.00,
    data: '2023-03-03',
    conta {
        conta_id: 1,
        nome: "c6 bank"
    },
    categoria: {
        categoria_id: 1,
        nome: "luz"
    }
    descricao: "conta de luz do estabelecimento"
}

{
    valor: 50.00,
    data: '2023-03-03',
    conta {
        conta_id: 2,
        nome: "bradesco"
    },
    categoria: {
        categoria_id: 2,
        nome: "agua"
    }
    descricao: "conta de agua do estabelecimento"

    
    valor: 300.00,
    data: '2023-03-03',
    conta {
        conta_id: 3,
        nome: "itau"
    },
    categoria: {
        categoria_id: 3,
        nome: "Potes"
    }
    descricao: "potes termicos para que podem ir no freezer para o microondas"

    
    valor: 2000.00,
    data: '2023-03-03',
    conta {
        conta_id: 4,
        nome: "inter"
    },
    categoria: {
        categoria_id: 4,
        nome: "alimentos"
    }
    descricao: "gasto com mercado e feiras mensal"

    valor: 1800.00,
    data: '2023-03-03',
    conta {
        conta_id: 5,
        nome: "inter"
    },
    categoria: {
        categoria_id: 5,
        nome: "funcionario"
    }
    descricao: "funcionario ajudante de cozinha"
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados da despesa retornados
| 404 | não existe despesa com o id informado
| 301 | código de despesa já cadastrado

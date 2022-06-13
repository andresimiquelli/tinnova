# Desafio 5 - Cadastro de veículos

Api RESTful para cadastro de veículos desenvolvida com Spring Boot.

- [X] CRUD
- [X] Busca por marca, ano e cor
- [X] Totais de veículos por marca
- [X] Totais de veículos por década
- [X] Totais de veículos não vendidos
- [X] Veículos cadastrados na última semana

## End-points da API

#### GET /veiculos

Retorna lista com os veículos cadastrados.

#### GET /veiculos?marca={marca}&ano={ano}&cor={cor}

Retorna lista com os veículos cadastrados obedecendo os critérios opcionais de busca.

#### POST /veiculos

Cadastra um novo veículo

```
{
    "veiculo" : "Polo",
    "marca" : "Volkswagen",
    "ano" : 2020,
    "cor" : "branco",
    "descricao" : "Polo 1.0 turbo hatch",
    "vendido" : false
}
```

#### PUT /veiculos/{id}

Atualiza um veículo.

#### PATCH /veiculos/{id}

Atualiza campos de um veículo.

#### DELETE /veiculos/{id}

Exclui um veículo.

#### GET /veiculos/total/estoque

Retorna o total de veículos não vendidos.

```
{
    "total" : 100
}
```

#### GET /veiculos/total/decadas

Retorna lista com o total de veículos cadastrados por década.

```
[
    {
        "decada" : 2000,
        "total": 5
    },
     {
        "decada" : 2010,
        "total": 2
    },
]
```

#### GET /veiculos/total/marcas

Retorna lista com o total de veículos cadastrados por marca

```
[
    {
        "marca" : "Toyota",
        "total": 3
    },
     {
        "marca" : "Fiat",
        "total": 5
    }
]
```

#### GET /veiculos/semana

Retorna lista com os veículos cadastrados nos últimos 7 dias.


## 🔧 Instalação
Para rodar o servidor localmente com o Maven, no diretório do projeto, com o prompt de comando execute:

```
mvn clean package
```

Entre no diretório target

```
cd target
```
Execute o pacote .jar
```
java -jar tinnova-veiculos-0.0.1-SNAPSHOT.jar
```

O servidor estará rodando na porta 8080. http://localhost:8080


## 🛠️ Tecnologias & Libs

* Spring Boot
* Spring Security
* Spring Validation
* Spring data JPA


## ✒️ Autor
João André Simiquelli
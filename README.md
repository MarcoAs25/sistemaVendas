# API Vendas

# ℹ Sobre
## *Api criada com finalidade de exercitar meus conhecimentos no ecossistema java*

### INFORMAÇÕES
Na pasta docs é possível encontrar os diagramas utilizados para a criação da api e seu arquiVo collection que pode ser importado no postman para testes de requisições
# REST API
---------------------------------------------------------------------------
# Cliente
## Obtendo uma lista de Clientes
## Requisição
`GET /clientes`
```
curl -X 'GET' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*'
```
## Obtendo um cliente por Id
## Requisição
`GET /clientes/id`
```
curl -X 'GET' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```

## Criando um novo cliente
## Requisição
`POST /clientes`
```
curl -X 'POST' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
   "nome": "string",
   "email": "string",
   "telefone": "string"
    }'
```

## Atualizando um cliente
## Requisição
`PUT /clientes`

```
curl -X 'PUT' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
   "nome": "string",
   "email": "string",
   "telefone": "string"
}'
```

## Removendo um cliente
## Requisição
`DELETE /clientes/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```

---------------------------------------------------------------------------
# Categoria

## Obtendo uma lista de Categorias
## Requisição
`GET /categorias`
```
curl -X 'GET' \
  'http://localhost:8080/categorias' \
  -H 'accept: */*'
```

## Obtendo um categoria por Id
## Requisição
`GET /categorias/id`
```
curl -X 'GET' \
  'http://localhost:8080/categorias/1' \
  -H 'accept: */*'
```

## Criando uma nova categoria
## Requisição
`POST /categorias`
```
curl -X 'POST' \
  'http://localhost:8080/categorias' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "string"
}'
```
## Atualizando uma categoria
## Requisição
`PUT /categorias/id`
```
curl -X 'PUT' \
  'http://localhost:8080/categorias/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "string"
}'
```

## Removendo uma categoria
## Requisição
`DELETE /categorias/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/categorias/1' \
  -H 'accept: */*'
```
---------------------------------------------------------------------------
# Produto
## Obtendo uma lista de Produtos
## Requisição
`GET /produtos`
```
curl -X 'GET' \
  'http://localhost:8080/produtos' \
  -H 'accept: */*'
```


## Obtendo um produto por Id
## Requisição
`GET /produtos/id`
```
curl -X 'GET' \
  'http://localhost:8080/produtos/1' \
  -H 'accept: */*'
```

## Criando um novo produto
## Requisição
`POST /produtos`
```
curl -X 'POST' \
  'http://localhost:8080/produtos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "valorProduto": 0,
  "descricao": "string",
  "nome": "string",
  "categorias": [
    {
      "id": 0
    }
  ]
}'
```

## Atualizando um produto
## Requisição
`PUT /produtos/id`
```
curl -X 'PUT' \
  'http://localhost:8080/produtos/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{

  "valorProduto": 0,
  "descricao": "string",
  "nome": "string",
  "categorias": [
    {
      "id": 1
    }
  ]
}'
```

## Removendo um produto

## Requisição
`DELETE /produtos/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/produtos/1' \
  -H 'accept: */*'
```
---------------------------------------------------------------------------
# Venda
## Obtendo uma lista de Vendas
## Requisição
`GET /vendas`
```
curl -X 'GET' \
  'http://localhost:8080/vendas' \
  -H 'accept: */*'
```

## Obtendo uma venda por Id
## Requisição
`GET /vendas/id`
```
curl -X 'GET' \
  'http://localhost:8080/vendas/id' \
  -H 'accept: */*'
```

## Criando uma nova venda
## Requisição
`POST /vendas`
```
curl -X 'POST' \
  'http://localhost:8080/vendas' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "cliente": {
        "id": 3
    },
    "itens" : [
        {
            "quantidade": 3,
            "produto":{
                "id": 1
            }
        }
    ]
}'
```
---------------------------------------------------------------------------
### Tecnologias Utilizadas
<ul>
	 <li>Java 17</li>
	 <li>Spring Boot 3 e Maven</li>
  <li>Jpa & Hibernate</l1>
  <li>SpringToolSuite4</a></li>
</ul>

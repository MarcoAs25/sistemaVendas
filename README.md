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
## Resposta

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
        "id": 1,
        "nome": "mariano",
        "email": "mariano@gmail.com",
        "telefone": "456546456"
    },
    {
        "id": 3,
        "nome": "joaquim",
        "email": "joaquim@gmail.com",
        "telefone": "789789789"
    }
    ]
## Obtendo um cliente por Id
## Requisição
`GET /clientes/id`
```
curl -X 'GET' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "nome": "mariano",
        "email": "mariano@gmail.com",
        "telefone": "456546456"
    }
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
## Resposta
    HTTP/1.1 201 CREATED
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 201 CREATED
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "nome": "string",
        "email": "string",
        "telefone": "string"
    }
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "nome": "string",
        "email": "string",
        "telefone": "string"
    }
## Removendo um cliente
## Requisição
`DELETE /clientes/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 204 No Content
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 204 No Content
    Connection: close
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
        "id": 1,
        "nome": "string"
    },
    {
        "id": 3,
        "nome": "string"
    }
    ]
## Obtendo um categoria por Id
## Requisição
`GET /categorias/id`
```
curl -X 'GET' \
  'http://localhost:8080/categorias/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 3,
        "nome": "string"
    }
    
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
## Resposta
    HTTP/1.1 201 CREATED
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 201 CREATED
    Connection: close
    Content-Type: application/json
    {
        "id": 3,
        "nome": "string"
    }
    
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "nome": "string"
    }
## Removendo uma categoria
## Requisição
`DELETE /categorias/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/categorias/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 204 No Content
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 204 No Content
    Connection: close
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
        "id": 1,
        "valorProduto": 0.0,
        "descricao": "string",
        "nome": "string",
        "categorias": [
            {
                "id": 1,
                "nome": "string"
            }
        ]
    },
    {
        "id": 3,
        "valorProduto": 2000.0,
        "descricao": "Smart TV Amoled",
        "nome": "TV 45 polegadas",
        "categorias": [
            {
                "id": 4,
                "nome": "Eletronicos"
            }
        ]
    }
    ]
## Obtendo um produto por Id
## Requisição
`GET /produtos/id`
```
curl -X 'GET' \
  'http://localhost:8080/produtos/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "valorProduto": 0.0,
        "descricao": "string",
        "nome": "string",
        "categorias": [
            {
                "id": 1,
                "nome": "string"
            }
        ]
    }
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
      "id": 1
    }
  ]
}'
```
## Resposta
    HTTP/1.1 201 CREATED
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 201 CREATED
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "valorProduto": 0.0,
        "descricao": "string",
        "nome": "string",
        "categorias": [
            {
                "id": 1,
                "nome": "string"
            }
        ]
    }
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "valorProduto": 0.0,
        "descricao": "string",
        "nome": "string",
        "categorias": [
            {
                "id": 1,
                "nome": "string"
            }
        ]
    }
## Removendo um produto

## Requisição
`DELETE /produtos/id`
```
curl -X 'DELETE' \
  'http://localhost:8080/produtos/1' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 204 No Content
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 204 No Content
    Connection: close
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
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
        "id": 1,
        "valorTotal": 6000.0,
        "dataVenda": "2023-03-25T01:31:49Z",
        "cliente": {
            "id": 1,
            "nome": "mariano",
            "email": "mariano@gmail.com",
            "telefone": "977557755"
        },
        "itens": [
            {
                "quantidade": 3,
                "valorProduto": 2000.0,
                "produto": {
                    "id": 1,
                    "valorProduto": 0.0,
                    "descricao": "string",
                    "nome": "string",
                    "categorias": [
                        {
                            "id": 1,
                            "nome": "string"
                        }
                    ]
                },
                "subTotal": 6000.0
            }
        ],
        "pagamento": {
            "id": 1,
            "momentoGeracao": "2023-03-25T01:31:49Z",
            "statusPagamento": "AGUARDANDO_PAGAMENTO"
        }
    }
    ]
## Obtendo uma venda por Id
## Requisição
`GET /vendas/id`
```
curl -X 'GET' \
  'http://localhost:8080/vendas/id' \
  -H 'accept: */*'
```
## Resposta
    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "valorTotal": 6000.0,
        "dataVenda": "2023-03-25T01:31:49Z",
        "cliente": {
            "id": 1,
            "nome": "mariano",
            "email": "mariano@gmail.com",
            "telefone": "977557755"
        },
        "itens": [
            {
                "quantidade": 3,
                "valorProduto": 2000.0,
                "produto": {
                    "id": 1,
                    "valorProduto": 0.0,
                    "descricao": "string",
                    "nome": "string",
                    "categorias": [
                        {
                            "id": 1,
                            "nome": "string"
                        }
                    ]
                },
                "subTotal": 6000.0
            }
        ],
        "pagamento": {
            "id": 1,
            "momentoGeracao": "2023-03-25T01:31:49Z",
            "statusPagamento": "AGUARDANDO_PAGAMENTO"
        }
    }
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
## Resposta
    HTTP/1.1 201 CREATED
    Date: Thu, 24 Feb 2011 12:36:32 GMT
    Status: 201 CREATED
    Connection: close
    Content-Type: application/json
    {
        "id": 1,
        "valorTotal": 6000.0,
        "dataVenda": "2023-03-25T01:31:49Z",
        "cliente": {
            "id": 1,
            "nome": "mariano",
            "email": "mariano@gmail.com",
            "telefone": "977557755"
        },
        "itens": [
            {
                "quantidade": 3,
                "valorProduto": 2000.0,
                "produto": {
                    "id": 1,
                    "valorProduto": 0.0,
                    "descricao": "string",
                    "nome": "string",
                    "categorias": [
                        {
                            "id": 1,
                            "nome": "string"
                        }
                    ]
                },
                "subTotal": 6000.0
            }
        ],
        "pagamento": {
            "id": 1,
            "momentoGeracao": "2023-03-25T01:31:49Z",
            "statusPagamento": "AGUARDANDO_PAGAMENTO"
        }
    }
---------------------------------------------------------------------------
### Tecnologias Utilizadas
<ul>
	 <li>Java 17</li>
	 <li>Spring Boot 3 e Maven</li>
  <li>Jpa & Hibernate</l1>
  <li>SpringToolSuite4</a></li>
</ul>

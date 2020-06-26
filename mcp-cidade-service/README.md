# Microservice para Cidade

## Iniciando o serviço
* 1 - Executar o comando na raiz do projeto: 
    ``` cmd
    mvn clean package  
    ```
* 2 - Executar comando para iniciar o backend: 
    ``` cmd
    java -jar target\mcp-cidade-service-0.0.1-SNAPSHOT.jar
    ```

## Exemplos de requisição

### Cadastrar Cidade
* POST - http://localhost:8084/cidades
```json
{
	"nome": "Recanto",
	"uf": "DF"
}
```

Retorno: 

```json
{
  "data": {
    "id": 4,
    "nome": "Recanto",
    "uf": "DF"
  }
}
```

### Buscar pelo ID
* GET - http://localhost:8084/cidades/4

Retorno:
```json
   {
     "data": {
       "id": 4,
       "nome": "Recanto",
       "uf": "DF"
     }
   }
```

### Buscar pelo NOME
* GET - http://localhost:8084/cidades?nome=Recanto

Retorno:
```json
{
  "data": [
    {
      "id": 4,
      "nome": "Recanto",
      "uf": "DF"
    }
  ]
}
```

### Buscar pelo UF
* GET - http://localhost:8084/cidades?uf=DF

Retorno:
```json
{
  "data": [
    {
      "id": 4,
      "nome": "Recanto",
      "uf": "DF"
    }
  ]
}
```

### Buscar pelo NOME e UF
* GET - http://localhost:8084/cidades?nome=Recanto&uf=DF

Retorno:
```json
{
  "data": [
    {
      "id": 4,
      "nome": "Recanto",
      "uf": "DF"
    }
  ]
}
```

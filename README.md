# Gerador Nota Fiscal

Aplicação responsável por gerar uma nota fiscal para pessoa física e júridica.

## Pré-requisitos

Antes de começar, verifique se você tem os seguintes requisitos:
- JDK (Java Development Kit) 17 ou superior instalado
- Maven 3.x ou superior (opcional, se você não usar uma IDE que suporte Maven)
- Spring Boot 2.6.2 ou superior

## Instalação e Configuração

1. **Clonar o repositório:**
```java
git clone https://github.com/pedroinacio11/geradornotafiscal.git
cd geradornotafiscal
```
3. **Compilar o projeto:**
```java
mvn clean install
```
3. **Executar o projeto:**
```java
mvn spring-boot:run
```

## Rotas

### `POST: /api/pedido/gerarNotaFiscal`

#### Exemplo de Requisição

```java
curl --request POST \
  --url http://localhost:8080/api/pedido/gerarNotaFiscal \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/8.6.0' \
  --data '{"id_pedido":1,"data":"2022-05-01","valor_total_itens":300,"valor_frete":10,"itens":[{"id_item":1,"descricao":"Teclado USB","valor_unitario":100,"quantidade":2}],"destinatario":{"nome":"John Doe","tipo_pessoa":"FISICA","documentos":[{"tipo":"CPF","numero":"88740347095"}],"enderecos":[{"logradouro":"Av do estado","numero":"5533","complemento":"4 anndar b","bairro":"Mooca","cidade":"São Paulo","estado":"SP","pais":"Brasil","cep":"03105003","finalidade":"ENTREGA","regiao":"SUDESTE"}]}}'
```

# GEP - RSS Feed to MongoDB

Projeto desenvolvido para **consumir feeds RSS** de fontes externas, transformar os dados e armazená-los em um banco de dados **MongoDB**.  
O objetivo final é que esses dados sejam consumidos posteriormente por uma **IA** para análise.

---

## 📚 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data MongoDB
- Rome Tools (parser RSS)
- MongoDB (local e cloud)

---

## ⚙️ Como funciona o projeto

1. O sistema recebe uma URL de um feed RSS.
2. Faz a leitura e parsing do feed utilizando a biblioteca **Rome Tools**.
3. Extrai as informações principais de cada notícia:
   - Título
   - Link
   - Descrição
   - Data de publicação
4. Salva esses dados na coleção **`rss`** de um banco de dados **MongoDB**.

---

## 🔥 Como rodar o projeto localmente

### Pré-requisitos:
- Java 17+ instalado
- MongoDB rodando localmente (`localhost:27017`)
- Maven configurado (caso utilize)

### Configuração do banco:
No arquivo `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/blitzkrieg-test




O arquivo dependencias.txt foi obtido executando o seguinte comando:
- ```mvn dependency:tree > demendencias.txt```

Se for necessário baixar novamente as dependências execute o seguinte comando: 
dentro da pasta do projeto
- ```mvn clean install```

Pode-se ainda ser necessário limpar o repositório local do Maven:
- ```rm -rf ~/.m2/repository```

O projeto está funcionando corretamente no servidor (ele subiu na porta 8080), 
a página ou endpoint configurado para a raiz (`/musicas`) e pode ser acessada
pelo navegador. 


Os demais endpoints disponíveis são:
- `POST /musicas?nome=<nome>`: Cadastra uma nova música.
- `GET /musicas`: Lista todas as músicas ordenadas por avaliação e nome.
- `PUT /musicas/{nome}/avaliar?avaliacao=<valor>`: Avalia uma música existente.

#### **2.Os Endpoints Podem Ser Testados Usando as Ferramentas Postman ou cURL**
Como o navegador só faz requisições `GET`, você precisará usar uma ferramenta 
como **Postman**, **cURL** ou qualquer cliente HTTP para testar os endpoints 
`POST` e `PUT`.

##### Vamos realizar testes com cURL como solicitado no trabalho:

1. **Cadastrar uma Música**
   ```bash
   curl -X POST "http://localhost:8080/musicas?nome=Undone%20thing"
   curl -X POST "http://localhost:8080/musicas?nome=Leave%20it" 
   ```

   Resposta esperada:
   ```json
   {
       "id": 1,
       "nome": "Undone thing",
       "avaliacao": 0
   }
     json
   {
       "id": 2,
       "nome": "Leave it",
       "avaliacao": 0
   }
   ```

2. **Listar Todas as Músicas**
   ```bash
   curl -X GET "http://localhost:8080/musicas"
   ```

   Resposta esperada (exemplo):
   ```json
   [
       {
           "id": 1,
           "nome": "Undone thing",
           "avaliacao": 0
       }
       {
           "id": 2,
           "nome": "Leave it",
           "avaliacao": 0
       }
   ]
   ```

3. **Avaliar uma Música**
   ```bash
   curl -X PUT "http://localhost:8080/musicas/Undone%20thing/avaliar?avaliacao=5"
   ```

   Após avaliar, liste novamente as músicas para verificar a atualização.

---

#### **3. Adicionei um Endpoint para a Raiz (`/`)**
Ao acessar a raiz (`http://localhost:8080/`), 
eu criei um novo controlador para exibir uma mensagem de boas-vindas.


Agora, ao acessar `http://localhost:8080/`, você verá a mensagem 
`"Bem-vindo à API de Músicas!"`.

---

#### **4. Verifique o Console do H2 Database**
Se você estiver usando o banco de dados H2 em memória, pode acessar o 
console do H2 para verificar se as tabelas e dados foram criados corretamente.

1. Acesse o console do H2 no navegador:
   ```
   http://localhost:8080/h2-console
   ```

2. Use as seguintes credenciais:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (deixe em branco ou use `password`, dependendo da configuração)

3. Execute consultas SQL para verificar a tabela `musica`:
   ```sql
   SELECT * FROM musica;
   ```

---

### **Conclusão**


1. Testados os endpoints da API (`/musicas`) usando a ferramentas cURL.
2. Adicionado um endpoint para a raiz (`/`) a página inicial.
3. Verifique o banco de dados H2 para garantir que as tabelas e dados foram
 criados corretamente.

Se precisar de mais ajuda, fico a disposição

 
 ########## Quebranco o  dominío em serviços ##########
- Microservice não tem transação asset = (TRANSAÇÃO ASSET) -> pindura os recursos de treards, conexões e no final 
  commita ou tudo dá certo ou executa o rollback.

- Um microservice não tem estado e não lembra o que está acontecendo e de quem é o usuário de está fazendo
  a requisição e não lida com a autenticação e autorização. 
- Um microservice é a implementação de um contexto = Cada contexto da nossa modelagem possui necessidades 
  específicas e sua independência do resto da aplicação induz ao baixo acoplamento. Com isso, temos mais 
  facilidade de lidar com questões técnicas, que são fortemente influenciadas pelos requisitos funcionais 
  e não funcionais do negócio que estamos informatizando.

  ########## Service Registry com Eureka ##########
- A integração entre microsserviços com RestTemplate
  O RestTemplate do Spring permite chamadas HTTP de alto nível
- Um introdução ao Service discovery e Service registry
  Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
  Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
  Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
- A implementação do service registry através do Eureka Server
- Como registrar da Loja e do Fornecedor no Eureka Server
- A resolução do IP/porta através do nome do microsserviço nas requisições

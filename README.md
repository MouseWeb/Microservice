 Microservices com Spring Cloud: Registry, Config Server e Distributed Tracing
 
  <h2>########## Quebranco o  dominío em serviços ##########</h2>

- Um microservice não tem estado e não lembra o que está acontecendo e de quem é o usuário de está fazendo
  a requisição e não lida com a autenticação e autorização. 
- Um microservice é a implementação de um contexto = Cada contexto da nossa modelagem possui necessidades 
  específicas e sua independência do resto da aplicação induz ao baixo acoplamento. Com isso, temos mais 
  facilidade de lidar com questões técnicas, que são fortemente influenciadas pelos requisitos funcionais 
  e não funcionais do negócio que estamos informatizando.
- Microservice não tem transação asset = (TRANSAÇÃO ASSET) -> pindura os recursos de treards, conexões e no final 
  comita ou tudo dá certo ou executa o rollback.

  <h2>########## Service Registry com Eureka ##########</h2>
- A integração entre microsserviços com RestTemplate
  O RestTemplate do Spring permite chamadas HTTP de alto nível.
- Os microsserviços não precisam conhecer o endereço IP das outras aplicações, mas apenas o nome que elas se registraram no Eureka.
- Um introdução ao Service discovery e Service registry
  Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
  Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome.
  Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta.
- Requisições síncronas HTTP do tipo GET, para acessar o Fornecedor pela Loja.
- A implementação do service registry através do Eureka Server.
- Como registrar da Loja e do Fornecedor no Eureka Server.
- A resolução do IP/porta através do nome do microsserviço nas requisições.

  <h2>########## Spring Config Server ##########</h2>
- O RestTemplate, que usamos para fazer uma requisição a uma aplicação, através do seu nome, o Eureka Client, 
  que fornece as instâncias disponíveis de um determinado serviço, e o   Ribbon que, através da anotação @LoadBalanced, 
  aprimora o RestTemplate com o processo de Load Balancing.
- O arquivo bootstrap.yml é carregado em um contexto com maior precedência, chamado de Bootstrap Application Context.
  É neste contexto que o Spring Cloud Config Client se conecta ao configuration server, baixa e disponibiliza as variáveis de 
  ambiente para o Spring Application Context, que é o contexto da nossa aplicação.
- Os microsserviços são preparados para um ambiente (cloud), cuja precificação é diretamente relacionada à quantidade de máquinas 
  e ao uso de seus recursos de infraestrutura. Para reduzir esse custo, aplicações de microsserviços se encaixam bem, pois é possível 
  escalar automaticamente, de acordo com a demanda, e em questão de segundos, pedaços do que antes era uma única aplicação. Nesse cenário,
  configurar manualmente os servidores com as configurações necessárias para cada aplicação é impraticável.
- Um servidor de configuração é o lugar central para definir as configurações dos serviços.
- Todas as configurações dos microsserviços devem ficar externalizadas e centralizadas.
- O Spring Config Server é uma implementação do servidor do projeto Spring Cloud.
- Sobre a integração dos microsserviços com o servidor de configuração.
  Para tal, devemos configurar o nome do microsserviço, profile e URL do Config Server
- Repositório de configurações GitHub.

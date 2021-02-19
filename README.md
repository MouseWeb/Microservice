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

  <h2>########## Load Balancer e Spring Feign ##########</h2>
- A cada requisição, o Ribbon rotaciona para uma instância diferente. Todavia, é possível customizar o algoritmo de load balancing.
- Load Balancing é o processo de distribuir as requisições vindas dos usuários para as várias instâncias disponíveis. 
- O Client Side Load Balancing (CSLB) é o cliente HTTP que decide qual microsserviço recebe a requisição. </br>
  Isto é importante, pois pode ter várias instâncias do mesmo serviço no ar. </br>
  A configuração do CSLB é feita a partir da anotação @LoadBalanced, na criação do RestTemplate. </br>
  Como implementação do CSLB, usamos um projeto chamado Ribbon, que faz parte do Spring Cloud Netflix.
- Para descobrir quais clientes existem, podemos injetar a interface DiscoveryClient.
- Como alternativa ao RestTemplate, podemos usar o Spring Feign, que já usa o Ribbon para CSLB.
- O Spring Feign exige apenas uma interface, com a definição e mapeamento dos métodos que executarão a requisição. </br>
  Toda a implementação da interface é gerada pelo Spring Feign.

  <h2>########## Distributed Tracing e Spring Sleuth ##########</h2>
- **Como a geração dos logs são impactados com a arquitetura em microsserviços?**</br>
  uma requisição do usuário bate em várias aplicações diferentes, para que a lógica de negócio requerida seja </br>
  realizada. Com isso, acompanhar os logs gerados em uma transação não é tão simples quanto abrir um único log e ter </br>
  toda a informação disponível.
- **O que ganhamos com agregação de logs e a geração de ID de correlação?**</br>
  Além da facilidade de acessar em um único local todo o log gerado pela aplicação, temos também a possibilidade de filtrar </br>
  os logs em uma única transação. Com isso, através da formatação adequada do log, sabemos não só onde os erros foram gerados, </br>
  mas em que momento aconteceu, pois os logs são escritos com os dados de milissegundos logo no início da linha.
- Como se trata de uma arquitetura distribuída, temos logs distribuídos.</br>
  Ou seja, cada microsserviço (e instância dele) possui o seu log.</br>
  Isso dificulta o acompanhamento e rastreabilidade das requisições.</br>
- Para unificar os logs, precisamos de agregadores de log.</br>
  Como implementação de um agregador, usamos o Papertrail, um agregador como serviço.</br>
- A biblioteca Logback para gerar e enviar os logs ao agregador.</br>
  O Logback possui um appender, que possibilita o envio dos logs.
- Para acompanhar uma transação nos logs, usamos uma correlation-id.</br>
  A correltation-id é um identificador da transação, que é passada de requisição pra requisição.</br>
  Dessa forma, podemos entender quais requisições fazem parte da mesma transação.</br>
- A biblioteca Spring Sleuth, que é usada para gerar a correlation-id.
  ![img_1.png](img_1.png)
- LOG's = https://papertrailapp.com/

  <h2>########## Fallback e Circuit Breaker ##########</h2>
- Impacto na aplicação por problemas de lentidão ao consultar outros microsserviço.
- Os problemas gerados na integração da Loja com o Fornecedor.
- A implementação do Circuit Breaker com Hystrix, limitando o tempo de processamento para 1 segundo</br>
  Como funciona o Fallback Method.
- O uso do Fallback para tratar a interrupção da Thread efetuada pelo Circuit Breaker.
- **É possível forçar que uma requisição seja cancelada após algum tempo, utilizando a técnica de Timeout, </br>
  onde definimos um tempo máximo de processamento daquela requisição. Qual a vantagem do Circuit Breaker, </br>
  em comparação ao uso de Timeout?**</br>
    O Circuit Breaker tem como funcionalidade principal a análise das requisições anteriores, para decidir </br>
  se deve parar de repassar as requisições vindas do cliente para um microsserviço com problemas de performance. </br>
  Enquanto o circuito está fechado, o Hystrix continua tentando a cada 5 segundos, com o objetivo de verificar </br>
  se o servidor voltou a funcionar normalmente.
- **A capacidade que o Hystrix tem com Circuit Breaker pode ser aprimorada pelo Fallback em qual circunstância?** </br>
     O Circuit Breaker implementado pelo Hystrix executa o processamento em uma thread separada. Quando o tempo limite </br>
  é excedido, o Hystrix mata a execução da thread e, caso configurado, repassa a execução para o método de Fallback, </br>
  de forma que este possa implementar livremente um tratamento de erro.

  <h2>########## Bulkhead com Hystrix ##########</h2>
- O Hystrix executa uma gerência de um pool de threads.
- A combinação de um volume alto de requisições para um único serviço de um microsserviço pode indisponibilizar </br>
  as outras requisições.
- Dividido as threads entre os serviços buscaCompra e realizaCompra.
- **Quando temos microsserviços, isso significa que podemos escalar a nossa aplicação horizontalmente, </br>
  ou seja, subir mais máquinas para ter várias instâncias e recursos de hardware disponíveis para estas. </br>
  Além disso, podemos ter várias threads dentro do mesmo microsserviço. Com Bulkhead, ganhamos mais uma 
  funcionalidade de processamento paralelo, que nos traz qual vantagem?**</br>
  Precisamos implementar um microsserviço tolerante a falhas, resiliente a integrações defeituosas e capaz de não </br>
  indisponibilizar toda a aplicação por causa de uma única funcionalidade.

  <h2>########## Lidando com transação e erros ##########</h2>
- Como realizar a compra com os dados do pedido e do voucher do transporte, utilizando os id's fornecidos </br>
  pelos microsserviços.
- O entendimento de que, com microsserviços, uma transação do usuário passa por diversos microsserviços e </br>
  que a gestão dessa transação fica sob a responsabilidade do programador.
- Como tratar os erros na transação, marcando o que foi processado com o uso de estados.

  <h2>########## API Gateway com Spring Zuul ##########</h2>
- **Para que os nossos microsserviços se comuniquem entre si, eles fazem o uso do Eureka, tanto para se </br>
  disponibilizarem como para descobrir instâncias de outros microsserviços. Qual a necessidade do Api </br>
  Gateway, já que os nossos microsserviços se conhecem?** </br>
  Uma aplicação rodando no navegador, ou mesmo em um aplicativo móvel, não deveria ter a inteligência </br>
  de se comunicar com o Eureka, nosso Service Discovery, para descobrir as instâncias disponíveis. Aliás, </br>
  faz sentido expor o Eureka na internet? não.
- **Uma integração entre o Zuul e o Eureka Server. O que ganhamos com essa integração?** </br>
  O Zuul utiliza o Eureka para conhecer as instâncias dos microsserviços e, usando o Ribbon, fazer o </br>
  balanceamento de carga das requisições dos usuários.
- Api Gateway cria um único ponto de acesso à nossa aplicação.

  <h2>########## Autenticação e autorização ##########</h2>
- **Como os microsserviços identificam o usuário logado?** </br>
  Extraindo o token da requisição e consultando os dados do usuário no servidor de autenticação.</br>
  Quando o usuário faz uma requisição para um serviço que demanda que o usuário esteja logado, </br>
  no header da requisição, o usuário envia um token, que ele conseguiu previamente através do </br>
  servidor de autenticação.
- **Como o Spring Security e o Spring Cloud OAuth são integrados?** </br>
- A integração é feita quanto estendemos o WebSecurityConfigurerAdapter e expomos os recursos </br>
  do Spring Security para serem utilizados pelo Spring Cloud OAuth. </br>
  AuthenticationManager e UserDetailService são os beans expostos do Spring Security e injetados </br>
  no Adapter do Spring Cloud OAuth2: o AuthorizationServerConfigurerAdapter. Mais especificamente, </br>
  a integração é feita no método configure deste adapter.
- Criado um servidor de autenticação com Spring Security e Spring Cloud OAuth2.
- A implementação da integração entre o Spring Security e o Spring Cloud OAuth2.
- Gerado e validado tokens no servidor de autenticação.
- Integração dos microsserviços com o servidor de autenticação.
- Repassar o token de autenticação através do Zuul.
- Implementado filtro do Feign para repassar o token do usuário nas chamadas para os microsserviços  </br>
  Fornecedor e Transportador

<h2>########## Endpoints ##########</h2>
- LOJA - compra = http://localhost:8080/compra </br>
- LOJA - pedido = http://localhost:8080/compra/{param} </br>
- FORNECEDOR - info = http://localhost:8081/info/{param} </br>
- FORNECEDOR - produto = http://localhost:8081/produto/{param} </br>
- FORNECEDOR - pedido = http://localhost:8081/pedido </br>
- EUREKA - apps = http://localhost:8761/eureka/apps </br>
- CONFIG-SERVER - fornecedor = http://localhost:8888/fornecedor/default </br>
- API Gateway Zuul - Routes = http://localhost:5555/actuator/routes </br>
- AUTH - token = http://localhost:8088/oauth/token </br>
- AUTH - Access Token = http://localhost:8088/user </br>

</br>Direito autoral: https://cursos.alura.com.br/

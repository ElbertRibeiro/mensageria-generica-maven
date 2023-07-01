# Mensageria Generica

Está lib tem como objetivo facilitar o processo de implementação de mensageria aos
projetos.

Para adicionar mensageria ao seu projeto, basta adicionar a lib:

````
    <dependency>
        <groupId>com.elbertribeiro</groupId>
        <artifactId>mensageria-generica-maven</artifactId>
        <version>1.0</version>
    </dependency>
````


Depois, deve-se encontrar a classe de configuração da aplicação (ConfiguracaoAplicacao.java) que se encontra no modulo api das aplicações, e adicione os seguintes codigos:

Para Kafka: ``@EnableKafka``
Para RabbitMq: ``@EnableRabbit``

Adicione também o seguinte comando: ``@ComponentScan(basePackages = "com.elbertribeiro.mensageria")``


## Logs

Para ignorar os logs gerados no weblogic, adicione no arquivo de logs
os comandos abaixo:

```
log4j.logger.org.springframework.amqp.rabbit.listener=off
log4j.logger.org.springframework.kafka=off
log4j.logger.org.apache.kafka.clients=off
```
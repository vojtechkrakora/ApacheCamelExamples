# Apache Camel Examples
**Spring boot** sandbox for some [Apache Camel](https://camel.apache.org/) routes.

## Camel Mail
**Used route** `CamelMailRoute`.
For mocking a smtp server was used [Fake SMTP Server](https://github.com/gessnerfl/fake-smtp-server).

Actual implementation is using timer for starting the mail route **every 5 seconds**.

## Run
`mvn spring-boot:run`
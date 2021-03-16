# Apache Camel Examples
**Spring boot** sandbox for some [Apache Camel](https://camel.apache.org/) routes.

## Camel Mail
**Used route** `CamelMailRoute`.
For mocking a smtp server was used [FakeSMTP](http://nilhcem.com/FakeSMTP/download.html).

Actual implementation is using timer for starting the mail route **every 5 seconds**.

## Run
`mvn spring-boot:run`
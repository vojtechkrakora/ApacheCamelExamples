# Apache Camel Examples
**Spring boot** sandbox for some [Apache Camel](https://camel.apache.org/) routes.

## Camel Mail
**Used route** `CamelMailRoute`.
For mocking a smtp server was used [Fake SMTP Server](https://github.com/gessnerfl/fake-smtp-server).

Actual implementation is using timer for starting the mail route **every 5 seconds**.

### Invoke
To send an Email to `smtp://localhost:5025` is used REST Get method on address
`http://localhost:8080/camel-mail/send`

### Description
After start is created a route `CamelMailRoute`. This route uses custom processor 
`SimpleMailProcessor`. The processor sets body a and headers like email subject etc.

To send an email is used REST api with GET method (returns nothing only SC = 200). 
This method is (for now) without some service layer calling `ProducerTemplate` to
invoke send mail endpoint.

## Run
`mvn spring-boot:run`

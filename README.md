# Apache Camel Examples
**Spring boot** sandbox for some [Apache Camel](https://camel.apache.org/) routes.

## Camel Mail
**Used route** `CamelMailRoute`.
For mocking a smtp server was used [Fake SMTP Server](https://github.com/gessnerfl/fake-smtp-server).

### Invoke
To send an Email to `smtp://localhost:5025` is used REST Get method on address
`http://localhost:8080/camel-mail/send/SIMPLE`

### Description
After start is created a route `CamelMailRoute`. This route uses custom processor 
`SimpleMailProcessor`. The processor sets body a and headers like email subject etc. and
adds an attachment (small png image from resources `attachment/ok_small.png`).

To send an email is used REST api with GET method (returns nothing only SC = 200). 
This method is (for now) without some service layer calling `ProducerTemplate` to
invoke send mail endpoint.

## Run
`mvn spring-boot:run`

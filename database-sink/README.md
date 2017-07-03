# Simple Log Sink

This is an example [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
Sink application to demonstrate the general structure and best practices
around authoring Sink applications. This type of application is meant to be composed into streams using
[Spring Cloud Data Flow](http://cloud.spring.io/spring-cloud-dataflow/).

## Logging messages

Message received on the default input channel are simply logged using the `INFO` log level.

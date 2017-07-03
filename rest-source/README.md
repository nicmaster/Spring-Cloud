# Simple RESTful Source

This is an example [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
Source application to demonstrate the general structure and best practices
around authoring Source applications. This type of application is meant to be composed into streams using
[Spring Cloud Data Flow](http://cloud.spring.io/spring-cloud-dataflow/).

## Resource endpoints

The current RESTful resources are available:

### `/messages`

Any text posted to the `/messages` resource will simply send that message over the default output channel.

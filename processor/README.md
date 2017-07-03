# Simple Filtering Processor

This is an example [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
Processor application to demonstrate the general structure and best practices
around authoring Processor applications. This type of application is meant to be composed into streams using
[Spring Cloud Data Flow](http://cloud.spring.io/spring-cloud-dataflow/).

## Filtering messages

Messages (`String`) are filtered based on a regular expression specified in the `filtering.regex` configuration
property. If the configured regular expression matches then the message sent to the default output channel will have
a value of `[filtered]`. If there is no match then the incoming message is used as is.

The default regex expression `(.*?)` matches all values.

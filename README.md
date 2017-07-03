# Stream Application

This is a demo application.
It consists of the following modules:

* [Rest Source](rest-source) - a RESTful Source application that accepts a HTTP POST and forwards the request body to the output channel
* [Processor](processor) - a stream processor that process message object
* [Database sink Sink](database-sink) - a Sink application that persist message object received on it's input channel

### Dependencies

You will need the following to run this project:

* Docker IBM image -
* Lombok plugin

### Domain Message

Message object
{
  "applicationName": "sharp",
  "transactionType": "cheque",
  "messageType": "client message",
  "transactions": [
    {
      "transactionReference": "fgh44556kkh",
      "clientName": "nick bike shop",
      "clientAccount": "3390990909",
      "transactionDate": ""
    }
  ]
}

### Rest Source

Rest end point for rest-source project http://localhost:8081/message


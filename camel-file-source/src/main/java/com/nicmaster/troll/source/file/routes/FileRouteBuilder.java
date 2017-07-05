package com.nicmaster.troll.source.file.routes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicmaster.troll.source.file.service.FileService;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.util.List;

import static java.lang.String.format;

@Component
public class FileRouteBuilder extends RouteBuilder {

    private FileService fileService;
    @Autowired
    private Jaxb2Marshaller Unmarshalling;

    @Autowired
    public FileRouteBuilder(final FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void configure() throws Exception {
        configureFilePathRoute();
    }

    protected RouteDefinition configureFilePathRoute() {

        final RouteDefinition routeDefinition = from(format("file:%s?moveFailed=.error&readLock=%s&readLockCheckInterval=%s",
                fileService.getFileProperties().getFilePath(),
                fileService.getFileProperties().getReadLock(),
                fileService.getFileProperties().getReadLockCheckInterval()))
                .to(format("file:%s/.routed?moveFailed=.error", fileService.getFileProperties().getFilePath()))
                .convertBodyTo(byte[].class)
                .process(processor -> {

                    final Message fileMessage = processor.getIn();
                    final String fileName = fileMessage.getHeader("CamelFileNameOnly", String.class);
                    final Object object = (Object) fileMessage.getBody();

                    fileService.publishObjectEvent(object);

                })
                .routeId(format("%s-incoming-file-path", fileService.getFileProperties().getServiceCode()))
                .log("its working now ==========")
                .autoStartup(Boolean.toString(true));
        return routeDefinition;
    }
}

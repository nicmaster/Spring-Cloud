package com.nicmaster.troll.source.file;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.source.file.configuration.FileConfigurationProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SuppressWarnings("checkstyle:hideutilityclassconstructor")
@SpringBootApplication
@EnableConfigurationProperties(FileConfigurationProperties.class)

public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Message.class);
        marshaller.setSupportJaxbElementClass(true);
        marshaller.setCheckForXmlRootElement(false);
        return marshaller;
    }

    @Bean
    InitializingBean jaxb2Configurer(final Jaxb2Marshaller marshaller) {
        return () -> {
            marshaller.setSupportJaxbElementClass(true);
            marshaller.setCheckForXmlRootElement(false);
            marshaller.setMappedClass(Message.class);
        };
    }
}

package com.nicmaster.troll.source.file.service;

import com.nicmaster.troll.domain.Message;
import com.nicmaster.troll.source.file.configuration.FileConfigurationProperties;
import com.nicmaster.troll.source.file.fileProperties.FileProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);
    private FileConfigurationProperties fileConfigurationProperties;

    public FileService(final FileConfigurationProperties fileConfigurationProperties){
         this.fileConfigurationProperties = fileConfigurationProperties;
    }

    public FileProperties getFileProperties() {
        FileProperties fileProperties = fileConfigurationProperties.getFileProperties();
        return fileProperties;
    }

    public void publishObjectEvent(final Object fileName){

        System.out.println("============================ " + fileName);
    }
}

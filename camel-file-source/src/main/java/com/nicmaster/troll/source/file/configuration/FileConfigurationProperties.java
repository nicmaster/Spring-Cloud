package com.nicmaster.troll.source.file.configuration;

import com.nicmaster.troll.source.file.fileProperties.FileProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("file")
public class FileConfigurationProperties {
    public FileProperties getFileProperties() {
        return fileProperties;
    }

    public void setFileProperties(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
    }

    private FileProperties fileProperties;
}

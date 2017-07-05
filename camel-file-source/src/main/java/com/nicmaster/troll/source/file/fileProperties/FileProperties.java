package com.nicmaster.troll.source.file.fileProperties;

public class FileProperties {
    private String filePath;
    private String serviceCode;
    private String readLock;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(final String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getReadLock() {
        return readLock;
    }

    public void setReadLock(final String readLock) {
        this.readLock = readLock;
    }

    public String getReadLockCheckInterval() {
        return readLockCheckInterval;
    }

    public void setReadLockCheckInterval(final String readLockCheckInterval) {
        this.readLockCheckInterval = readLockCheckInterval;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    private String readLockCheckInterval;
}

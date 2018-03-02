package com.insigma.download.entity;

public class FileResultBean {
    private String path;
    private String name;
    private boolean isDir;

    public FileResultBean() {
    }

    public FileResultBean(String path, boolean isDir) {
        this.path = path;
        this.isDir = isDir;
    }

    public FileResultBean(String path, String name, boolean isDir) {
        this.path = path;
        this.name = name;
        this.isDir = isDir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }
}

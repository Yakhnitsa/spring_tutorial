package com.yurets_y.spring_tutor_001.configuration_profiles;

public class ConnectionService {
    private int port;
    private String host;
    private String databaseUrl;

    public ConnectionService() {
    }

    public ConnectionService(int port, String host, String databaseUrl) {
        this.port = port;
        this.host = host;
        this.databaseUrl = databaseUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public String toString() {
        return "ConnectionService{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", databaseUrl='" + databaseUrl + '\'' +
                '}';
    }
}

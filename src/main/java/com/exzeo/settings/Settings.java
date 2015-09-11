package com.exzeo.settings;

/**
 * Created by dhruvr
 */
public class Settings {

    private int jettyPort;
    private String esClusterName;
    private String esIp;
    private int esPort;

    public int getEsPort() {
        return esPort;
    }

    public void setEsPort(int esPort) {
        this.esPort = esPort;
    }

    public String getEsClusterName() {
        return esClusterName;
    }

    public void setEsClusterName(String esClusterName) {
        this.esClusterName = esClusterName;
    }

    public String getEsIp() {
        return esIp;
    }

    public void setEsIp(String esIp) {
        this.esIp = esIp;
    }

    public int getJettyPort() {
        return jettyPort;
    }

    public void setJettyPort(int jettyPort) {
        this.jettyPort = jettyPort;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "jettyPort=" + jettyPort +
                ", esClusterName='" + esClusterName + '\'' +
                ", esIp='" + esIp + '\'' +
                ", esPort='" + esPort + '\'' +
                '}';
    }
}

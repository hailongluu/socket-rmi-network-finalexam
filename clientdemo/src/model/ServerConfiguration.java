/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hailo
 */
public class ServerConfiguration implements Serializable {
    public static final long serialVersionUID = 3L;
    String rmiServerName;
    int rmiPort;
    int stringServerPort;
    int numericServerPort;
    int code;

    public ServerConfiguration(String rmiServerName, int rmiPort, int stringServerPort, int numericServerPort, int code) {
        this.rmiServerName = rmiServerName;
        this.rmiPort = rmiPort;
        this.stringServerPort = stringServerPort;
        this.numericServerPort = numericServerPort;
        this.code = code;
    }

    public void setRmiServerName(String rmiServerName) {
        this.rmiServerName = rmiServerName;
    }

    public void setRmiPort(int rmiPort) {
        this.rmiPort = rmiPort;
    }

    public void setStringServerPort(int stringServerPort) {
        this.stringServerPort = stringServerPort;
    }

    public void setNumericServerPort(int numericServerPort) {
        this.numericServerPort = numericServerPort;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRmiServerName() {
        return rmiServerName;
    }

    public int getRmiPort() {
        return rmiPort;
    }

    public int getStringServerPort() {
        return stringServerPort;
    }

    public int getNumericServerPort() {
        return numericServerPort;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ServerConfiguration{" + "rmiServerName=" + rmiServerName + ", rmiPort=" + rmiPort + ", stringServerPort=" + stringServerPort + ", numericServerPort=" + numericServerPort + ", code=" + code + '}';
    }
    
    
}

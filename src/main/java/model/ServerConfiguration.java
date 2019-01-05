package model;

import java.io.Serializable;

public class ServerConfiguration implements Serializable {
   public static final long sericalVersionUID = 3L;
    int stringServerPort;
    int numericServerPort;
    int objectServerPort;
    int code;

    public ServerConfiguration(int stringServerPort, int numericServerPort, int objectServerPort, int code) {
        this.stringServerPort = stringServerPort;
        this.numericServerPort = numericServerPort;
        this.objectServerPort = objectServerPort;
        this.code = code;
    }

    public void setStringServerPort(int stringServerPort) {
        this.stringServerPort = stringServerPort;
    }

    public void setNumericServerPort(int numericServerPort) {
        this.numericServerPort = numericServerPort;
    }

    public void setObjectServerPort(int objectServerPort) {
        this.objectServerPort = objectServerPort;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static long getSericalVersionUID() {
        return sericalVersionUID;
    }

    public int getStringServerPort() {
        return stringServerPort;
    }

    public int getNumericServerPort() {
        return numericServerPort;
    }

    public int getObjectServerPort() {
        return objectServerPort;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ServerConfiguration{" +
                "stringServerPort=" + stringServerPort +
                ", numericServerPort=" + numericServerPort +
                ", objectServerPort=" + objectServerPort +
                ", code=" + code +
                '}';
    }
}

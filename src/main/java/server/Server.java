package server;

import control.ObjectServer;
import control.RMIServer;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        RMIServer rmiServer = new RMIServer();
        ObjectServer objectServer = new ObjectServer();
    }
}

package control;

import model.ServerConfiguration;
import model.Student;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class RMIServer extends UnicastRemoteObject implements IRMIServer {
    public RMIServer() throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("Server", this);
    }

    public ServerConfiguration getObjectServerDes(Student student, ServerConfiguration config) {
        Random rand = new Random();
        ServerConfiguration result = new ServerConfiguration(0,0,10000,rand.nextInt(2));
        System.out.println("Student: "+ student.getMaSV()+" "+ student.getHovaten() +"config: " +result.toString());
        return result;
    }

    public ServerConfiguration getStringServerDes(Student student, ServerConfiguration config) {
        Random rand = new Random();
        ServerConfiguration result = new ServerConfiguration(10001,0,0,rand.nextInt(2));
        System.out.println("Student: "+ student.getMaSV()+" "+ student.getHovaten() +"config: " +result.toString());
        return result;
    }

    public ServerConfiguration getNumericServerDes(Student student, ServerConfiguration config) {
        Random rand = new Random();
        ServerConfiguration result = new ServerConfiguration(0,10002,0,rand.nextInt(2));
        System.out.println("Student: "+ student.getMaSV()+" "+ student.getHovaten() +"config: " +result.toString());
        return result;
    }
}

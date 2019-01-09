package control;

import model.ServerConfiguration;
import model.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIServer extends Remote {
    ServerConfiguration getObjectServerDes(Student student, ServerConfiguration config) ;
    ServerConfiguration getStringServerDes(Student student, ServerConfiguration config);
    ServerConfiguration getNumericServerDes(Student student, ServerConfiguration config);

}

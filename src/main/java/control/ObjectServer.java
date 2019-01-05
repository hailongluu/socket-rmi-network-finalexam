package control;

import model.Answer;
import model.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer{
    public ObjectServer() throws IOException {
        System.out.println("Object Server running");
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true){
            try{
                Socket client = serverSocket.accept();
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream ois  = new ObjectInputStream(client.getInputStream());
                Student student = (Student) ois.readObject();
                Answer answer = new Answer(student,null,null,true);
                System.out.println("ObjectServer: \n Registed for:"  + student.getMaSV());
                oos.writeObject(answer);
                oos.flush();
            }
            catch (Exception e){
                System.out.println(e);

            }
        }
    }

}

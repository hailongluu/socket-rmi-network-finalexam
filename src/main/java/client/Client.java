package client;



import control.IRMIServer;
import model.Answer;
import model.ServerConfiguration;
import model.Student;

import java.io.*;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;

public class Client {
    public static void main(String[] args) throws IOException, NotBoundException, ClassNotFoundException {
        Remote lookup = Naming.lookup("rmi://localhost/Server");
        IRMIServer register = (IRMIServer) lookup;
        Student student = new Student("B15DCCN316", "Luu Hai Long","0.0.0.0",1);
        ServerConfiguration configObject = register.getObjectServerDes(student,null);
        ServerConfiguration configString = register.getStringServerDes(student,null);
        ServerConfiguration configNumeric = register.getNumericServerDes(student,null);


        // Ket noi server Object

        connectoObjectServer(student,configObject);

        // Ket noi server String
        connectoStringServer(student,configString);

        // Ket noi server Numeric




    }
    public static void connectoObjectServer(Student student, ServerConfiguration configObject) throws IOException, ClassNotFoundException {
        Socket socketObject = new Socket("localhost",configObject.getObjectServerPort());
        ObjectOutputStream oosObject = new ObjectOutputStream(socketObject.getOutputStream()) ;
        ObjectInputStream oisObject  = new ObjectInputStream(socketObject.getInputStream());
        oosObject.writeObject(student);
        oosObject.flush();
        Answer answer = (Answer) oisObject.readObject();
        System.out.println(answer);
    }
    public static void connectoStringServer(Student student, ServerConfiguration configString) throws IOException, ClassNotFoundException {
        Socket socketString = new Socket("localhost",configString.getStringServerPort());
        ObjectOutputStream oos = new ObjectOutputStream(socketString.getOutputStream());
        DataOutputStream dos = new DataOutputStream(socketString.getOutputStream());
        DataInputStream dis = new DataInputStream(socketString.getInputStream());
        ObjectInputStream ois = new ObjectInputStream(socketString.getInputStream());
        dos.writeUTF(student.getMaSV());
        dos.writeUTF(student.getHovaten());
        dos.writeInt(student.getGroup());
        dos.writeInt(configString.getCode());
        dos.flush();
        switch (configString.getCode()){
            case 0:{
                String ceasar = dis.readUTF();
                int n = dis.readInt();
                dos.writeUTF(ceasarEncode(ceasar,n));
                dos.flush();

                String s = (String) ois.readObject();
                Integer a = (Integer) ois.readObject();
                Integer b = (Integer) ois.readObject();
                dos.writeUTF(s.substring(a,b));
                dos.flush();

                String secondChar = dis.readUTF();
                dos.writeChar(getSecondChar(secondChar));
                dos.flush();
                break;
            }
            case 1:{
                String secondChar = dis.readUTF();
                dos.writeChar(getSecondChar(secondChar));
                dos.flush();

                String s = (String) ois.readObject();
                Integer a = (Integer) ois.readObject();
                Integer b = (Integer) ois.readObject();
                dos.writeUTF(s.substring(a,b));
                dos.flush();

                String ceasar = dis.readUTF();
                int n = dis.readInt();
                dos.writeUTF(ceasarEncode(ceasar,n));
                dos.flush();
                break;
            }
        }

        Answer answerString = (Answer) ois.readObject();
        System.out.println(answerString);
    }
    public static String ceasarEncode(String s, int key){
        String encrypted = "" ;
        for (int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if (Character.isUpperCase(c)){
                c+= (key%26);
                if (c>'Z')
                    c-= 26;
            }
            else if (Character.isLowerCase(c)){
                c+= (key%26);
                if (c>'z')
                    c-= 26;
            }
            encrypted+=(char)c;
        }
        return encrypted;
    }
    public static char getSecondChar(String s){
        int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=0;
        }
        for (int i = 0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }
        int max = 0;
        int second = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>arr[max]){
                max=i;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] < arr[max] && arr[i] > second){
                second=i;
            }
        }
        return (char) second;
    }
}

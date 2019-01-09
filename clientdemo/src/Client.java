
import control.IRMIServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import model.Answer;
import model.ServerConfiguration;
import model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hailo
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NotBoundException {
        ServerConfiguration config = connect2ObjectServer();
        Remote lookup = Naming.lookup("rmi://localhost:10000/getPort");
        IRMIServer register = (IRMIServer) lookup;
        ServerConfiguration cf = new ServerConfiguration("", 0, 0, 0, 0);
        Student student = new Student("B15DCCN316", "Luu Hai Long", "0.0.0.0", 1);
        ServerConfiguration configString = register.getStringServerDes(student, cf);
        ServerConfiguration configNumeric = register.getNumericServerDes(student, cf);
        System.out.println(configString);
        System.out.println(configNumeric);
        connect2StringServer(student, configString);
        connect2NumericServer(student, configNumeric);
    }

    public static ServerConfiguration connect2ObjectServer() throws IOException, ClassNotFoundException {
        Socket objctServerSocket = new Socket("localhost", 12345);
        ObjectOutputStream oos = new ObjectOutputStream(objctServerSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(objctServerSocket.getInputStream());
        Student student = new Student("B15DCCN316", "Luu Hai Long", "0.0.0.0", 1);
        ServerConfiguration config = new ServerConfiguration("", 0, 0, 0, 0);
        oos.writeObject(student);
        oos.writeObject(config);
        oos.flush();
        config = (ServerConfiguration) ois.readObject();
        System.out.println(config);
        return config;
    }

    public static void connect2StringServer(Student student, ServerConfiguration config) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", config.getStringServerPort());

//        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        dos.writeUTF(student.getMaSV());
        dos.writeUTF(student.getHovaten());
        dos.writeInt(student.getGroup());
        dos.writeInt(config.getCode());
        dos.flush();
        switch (config.getCode()) {
            case 0: {
                String xau1 = dis.readUTF();
                int n = dis.readInt();
                dos.writeUTF(ceasarEncode(xau1, n));

                String xau2 = (String) ois.readObject();
                Integer a = (Integer) ois.readObject();
                Integer b = (Integer) ois.readObject();
                dos.writeUTF(xau2.substring(a, b));

                String xau3 = dis.readUTF();
                dos.writeChar(get2String(xau3));
                break;
            }
            case 1: {
                String xau3 = dis.readUTF();
                dos.writeChar(get2String(xau3));

                String xau2 = (String) ois.readObject();
                Integer a = (Integer) ois.readObject();
                Integer b = (Integer) ois.readObject();
                dos.writeUTF(xau2.substring(a, b));

                String xau1 = dis.readUTF();
                int n = dis.readInt();
                dos.writeUTF(ceasarEncode(xau1, n));
                break;
            }
        }
        Answer answer = (Answer) ois.readObject();
        System.out.println(answer);
    }

    public static void connect2NumericServer(Student student, ServerConfiguration config) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", config.getNumericServerPort());

//        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        dos.writeUTF(student.getMaSV());
        dos.writeUTF(student.getHovaten());
        dos.writeInt(student.getGroup());
        dos.writeInt(config.getCode());
        dos.flush();
        switch (config.getCode()) {
            case 0: {
                String xau1 = dis.readUTF();
                String xau2 = dis.readUTF();
                int a = 0;
                int b = 0;
                for (int i = 0; i < xau1.length(); i++) {
                    char c = xau1.charAt(i);
                    a += Character.isDigit(c) ? c : 0;
                }
                for (int i = 0; i < xau2.length(); i++) {
                    char c = xau2.charAt(i);
                    b += Character.isDigit(c) ? c : 0;
                }
                dos.writeBoolean(UCLN(a, b) == 1 ? true : false);

                String xau3 = dis.readUTF();
                System.out.println(xau3);
                String[] s = xau3.split(";");
                for (int i = 0; i < s.length; i++) {
                    System.out.println(s[i]);
                    
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length; i++) {
                    switch (s[i]) {
                        case "mot": {
                            sb.append("1");
                            break;
                        }
                        case "hai": {
                            sb.append("2");

                            break;
                        }
                        case "ba": {
                            sb.append("3");
                            break;
                        }
                        case "bon": {
                            sb.append("4");
                            break;
                        }
                        case "nam": {
                            sb.append("5");
                            break;
                        }
                        case "sau": {
                            sb.append("6");
                            break;
                        }
                        case "bay": {
                            sb.append("7");
                            break;
                        }
                        case "tam": {
                            sb.append("8");
                            break;
                        }
                        case "chin": {
                            sb.append("9");
                            break;
                        }
                    }

                }
                System.out.println(sb.toString());
                int so = Integer.parseInt(sb.toString());
                int tong = 0;
                for (int j = 1; j < so; j++) {
                    if (checkSNT(j)) {
                        tong += j;
                    }
                }
                System.out.println(tong+1);
                dos.writeInt(tong);
                break;
            }
            case 1: {
                String xau3 = dis.readUTF();
                String[] s = xau3.split(";");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length; i++) {
                    switch (s[i]) {
                        case "mot": {
                            sb.append("1");
                            break;
                        }
                        case "hai": {
                            sb.append("2");

                            break;
                        }
                        case "ba": {
                            sb.append("3");
                            break;
                        }
                        case "bon": {
                            sb.append("4");
                            break;
                        }
                        case "nam": {
                            sb.append("5");
                            break;
                        }
                        case "sau": {
                            sb.append("6");
                            break;
                        }
                        case "bay": {
                            sb.append("7");
                            break;
                        }
                        case "tam": {
                            sb.append("8");
                            break;
                        }
                        case "chin": {
                            sb.append("9");
                            break;
                        }
                    }

                }
                int so = Integer.parseInt(sb.toString());
                int tong = 0;
                for (int j = 1; j < so; j++) {
                    if (checkSNT(j)) {
                        tong += j;
                    }
                }
                dos.writeInt(tong);

                String xau1 = dis.readUTF();
                String xau2 = dis.readUTF();
                int a = 0;
                int b = 0;
                for (int i = 0; i < xau1.length(); i++) {
                    char c = xau1.charAt(i);
                    a += Character.isDigit(c) ? c : 0;
                }
                for (int i = 0; i < xau2.length(); i++) {
                    char c = xau2.charAt(i);
                    b += Character.isDigit(c) ? c : 0;
                }
                dos.writeBoolean(UCLN(a, b) == 1 ? true : false);
                break;
            }
            
        }
        
        Answer answer = (Answer) ois.readObject();
        System.out.println(answer);
    }

    public static String ceasarEncode(String s, int key) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                c += (key % 26);
                if (c > 'Z') {
                    c -= 26;
                }
            }
            if (Character.isLowerCase(c)) {
                c += (key % 26);
                if (c > 'z') {
                    c -= 26;
                }
            }
            result += (char) c;
        }
        return result;
    }

    public static char get2String(String s) {
        int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c]++;
        }
        int max = 0;
        int second = 0;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > arr[max] ? i : max;
        }
        for (int i = 0; i < arr.length; i++) {
            second = arr[i] < arr[max] & arr[i] > arr[second] ? i : second;
        }
        return (char) second;
    }

    public static int UCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return UCLN(b, (a % b));
    }

    public static boolean checkSNT(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }

        }
        return true;
    }
}

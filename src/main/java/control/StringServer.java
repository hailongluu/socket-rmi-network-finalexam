package control;

import model.Answer;
import model.Student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StringServer {
    public StringServer() {

    }

    public static void main(String[] args) throws IOException {
        System.out.println("StringServer running... ");
        ServerSocket serverSocket = new ServerSocket(10001);
        while (true){
            try {
                Socket client = serverSocket.accept();
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                DataInputStream dis = new DataInputStream(client.getInputStream());
                int id = dis.readInt();
                String maSV = dis.readUTF();
                String hovaten = dis.readUTF();
                int nhom = dis.readInt();
                Student student = new Student(maSV,hovaten,client.getInetAddress().getHostName(),nhom);
                System.out.println("Connect to: " + student);
                boolean[] isRights = new boolean[3];
                int code = dis.readInt();
                switch (code){
                    case 0:{
                        //ma hoa ceasar
                        String ceasar = "mahoaceasar";
                        dos.writeUTF(ceasar);
                        dos.writeInt(2);
                        dos.flush();
                        String encode = dis.readUTF();
                        if (encode.equals(ceasarEncode("mahoaceasar",2))){
                            isRights[0]=true;
                        }

                        // tim chuoi con
                        String s ="tim chuoi con vi tri thu 2 toi 6";
                        oos.writeObject(s);
                        oos.writeObject(new Integer(2));
                        oos.writeObject(new Integer(6));
                        oos.flush();
                        String subString = dis.readUTF();
                        if (subString.equals(s.substring(2,6))){
                            isRights[1] = true;
                        }

                        // tim ki tu nhieu thu 2
                        String secondChar = "ki tu nhieu thu 2 trong xau nay";
                        dos.writeUTF(secondChar);
                        dos.flush();
                        char kitu = dis.readChar();
                        if (kitu == getSecondChar(secondChar)){
                            isRights[2] = true;
                        }
                        break;
                    }
                    case 1:{
                        // tim ki tu nhieu thu 2
                        String secondChar = "ki tu nhieu thu 2 trong xau nay";
                        dos.writeUTF(secondChar);
                        dos.flush();
                        char kitu = dis.readChar();
                        if (kitu == getSecondChar(secondChar)){
                            isRights[2] = true;
                        }

                        // tim chuoi con
                        String s ="tim chuoi con vi tri thu 2 toi 6";
                        oos.writeObject(s);
                        oos.writeObject(new Integer(2));
                        oos.writeObject(new Integer(6));
                        oos.flush();
                        String subString = dis.readUTF();
                        if (subString.equals(s.substring(2,6))){
                            isRights[1] = true;
                        }

                        //ma hoa ceasar
                        String ceasar = "mahoaceasar";
                        dos.writeUTF(ceasar);
                        dos.writeInt(2);
                        dos.flush();
                        String encode = dis.readUTF();
                        if (encode.equals(ceasarEncode("mahoaceasar",2))){
                            isRights[0]=true;
                        }
                        break;
                    }

                }
                Answer answer = new Answer(student,null,isRights,true);
                oos.writeObject(answer);
                oos.flush();
                System.out.println("done!");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
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

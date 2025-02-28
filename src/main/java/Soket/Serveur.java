package Soket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Serveur {
    public static void main(String[] args) throws IOException {
        ServerSocket serveurSocket=new ServerSocket(9090);
        Socket socket= serveurSocket.accept();
        InputStream is =socket.getInputStream();
        OutputStream os=socket.getOutputStream();

        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        PrintWriter p=new PrintWriter(new OutputStreamWriter(os),true);

        Scanner sc=new Scanner(System.in);
        String receivedMsg;

        do {
            receivedMsg=br.readLine();
            System.out.println("lui : "+receivedMsg);
            System.out.println("moi : ");
            receivedMsg=sc.nextLine();
            p.println(receivedMsg);
        }while (!receivedMsg.equals("bye"));



    }
}

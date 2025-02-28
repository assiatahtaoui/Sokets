package Soket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
     Socket socket = new Socket("localhost",9090);
     InputStream is = socket.getInputStream();
     OutputStream os = socket.getOutputStream();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
        PrintWriter pr=new PrintWriter(new OutputStreamWriter(os),true);
        Scanner scanner=new Scanner(System.in);
        String mgs;

        do {
            System.out.print("moi :");
            mgs=scanner.nextLine();
            pr.println(mgs);
           mgs= bufferedReader.readLine();
            System.out.println("lui :"+mgs);
        }while (!mgs.equals("bye"));




    }
}

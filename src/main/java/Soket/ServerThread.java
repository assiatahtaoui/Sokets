package Soket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9090);
        Random random=new Random();
        int nbMagic=random.nextInt(100);

        List<Socket> sockets=new ArrayList<>();

        while (true){
            Socket socket=serverSocket.accept();
            sockets.add(socket);
            SocketThread sThread=new SocketThread(socket,nbMagic,sockets);
            sThread.start();
        }


    }
}

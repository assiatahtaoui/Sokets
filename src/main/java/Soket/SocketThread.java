package Soket;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class SocketThread extends  Thread{
    private Socket socket;
    private int nbMagic;
    private List<Socket> sockets;
    private String joueurName;

    public SocketThread(Socket socket, int nbMagic,List<Socket> sockets) {
        this.nbMagic=nbMagic;
        this.socket = socket;
        this.sockets=sockets;

    }
    private void prodcustMsg() throws IOException {
        for (Socket s:sockets){
            if(s!=socket);
            OutputStream os=s.getOutputStream();
            PrintWriter ps=new PrintWriter(new OutputStreamWriter(os),true);
            ps.println("le jouere" + joueurName+ "un autre joueur a trouve le nombre magique:"+nbMagic);
        }
    }

    @Override
    public void run(){
        try {
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(os),true);
            Scanner scanner=new Scanner(System.in);
            int nbJoueur;
            pw.println("welcome enter ur name!");
            joueurName= br.readLine();
            pw.println("enter un nombre");

            do {
                nbJoueur= Integer.parseInt(br.readLine());
                if(nbJoueur>nbMagic){
                    pw.println("entrez nombre inferieur");
                }else if(nbJoueur<nbMagic){
                    pw.println("entrez un nombre supp");
                }else {
                    pw.println("bravo"+nbMagic);
                    prodcustMsg();
                }
            }while (nbJoueur!=nbMagic);
    } catch (Exception e) {
            throw new RuntimeException(e);
        }

}
}
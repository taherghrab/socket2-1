package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        // Réservation du port et acceptation de connexion
        ServerSocket ss = new ServerSocket(1237);

        System.out.println("Le server attend la connexion un client ");
        Socket s = ss.accept();
        System.out.println("client connécté");
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
// Utlisation du InputStreamReader et BufferedReader pour pouvoir lire tous les caractères reçus du client
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        // Conversion du Char vers Integer
         int   g = Integer.parseInt(br.readLine());
            int z=Integer.parseInt(br.readLine());
            int T = Integer.parseInt(br.readLine());
            int res;
        switch (z){
            case 1 : res = g*T; break;
            case 2:  res=g-T;break;
            case 3:res=g/T;break;
            case 4: res=g+T;break;
            default:
                throw new IllegalStateException("Unexpected value: " + z);
        }
           PrintWriter pw = new PrintWriter(os, true);
            pw.println(res);
        //System.out.println(res);*/
        s.close();
        ss.close();


    }
}

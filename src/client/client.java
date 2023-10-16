package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("je suis un client non connecté ");
        //connexion au serveur
        Socket s = new Socket("localhost", 1237);
        System.out.println("je suis connecté ");
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        System.out.println("choisir le premier valeur ");
        int nb =scanner.nextInt();
        PrintWriter pw = new PrintWriter(os, true); // Utilisation de PrintWriter pour pouvoir envoyer plus d'un octet
        pw.println( nb);

        int x;
        //verification de l'operation seulement 4 operation
        do {
            System.out.println("choisir un nombre 1:multiplication  2:soustraction 3:division 4:addition");
            x = scanner.nextInt();
        }while(x>4 || x<1);
        pw.println(x);
        int y;
        System.out.println("choisr le deuxieme nombre ");
        y=scanner.nextInt();
        pw.println(y);
        // Utlisation du InputStreamReader et BufferedReader pour pouvoir lire tous les caractères reçus du serveur
        InputStreamReader isr= new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String v = br.readLine();
        System.out.println("le resulatat et :"+v);

        s.close();//deconnexion
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.net.*;
import java.io.*;

/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */

/**
 *
 * @author cl428309
 */
public class Hangman {
    static Console console;

    public static void main(String [] args) throws IOException
    {
        String serverName = "192.168.2.110";
        int port = 8888;
        

        System.out.println("Connecting to " + serverName + " on port " + port);
        Socket clientSocket = new Socket(serverName, port);
        System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
        OutputStream outToServer = clientSocket.getOutputStream();
        PrintWriter bw = new PrintWriter(outToServer, true);
        bw.println("ciao amico");
        
        InputStream inFromServer = clientSocket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inFromServer);
        BufferedReader in = new BufferedReader(isr);
        System.out.println("Server says " + in.readLine());
        
        String lettera = console.readLine().trim();
        bw.println(lettera);
        
        clientSocket.close();

   }
}
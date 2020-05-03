package com.sky.learning.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Comms {
    private Socket clientSocket;

    public void startClientConnection(String ip, int port) throws Exception {
        clientSocket = new Socket(ip, port);

        printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

        receiveRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Client ready...");

        chat();
    }

    public void chat() throws IOException {
        while (true) {
            // reading keyboard input
            sendMessage = keyRead.readLine();
            // sending to server
            printWriter.println(sendMessage);
            printWriter.flush();
            if ((receiveMessage = receiveRead.readLine()) != null)
            {
                System.out.println(receiveMessage);
            }
            else if(sendMessage.equalsIgnoreCase("QUIT")) {
                System.out.println("Chat Terminated...Goodbye!");
                clientSocket.close();
                System.exit(0);
            }
        }
    }
}

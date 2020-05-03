package com.sky.learning.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Comms{
    private ServerSocket serverSocket;

    public void startServerConnection(int port) throws Exception{
        serverSocket = new ServerSocket(port);

        System.out.println("Server ready...");

        Socket sock = serverSocket.accept( );

        printWriter = new PrintWriter(sock.getOutputStream(), true);

        receiveRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        chat();
    }

    public void chat() throws IOException {
        while(true)
        {
            if((receiveMessage = receiveRead.readLine()) != null)
            {
                if ("QUIT".equalsIgnoreCase(receiveMessage)) {
                    System.out.println("Chat Terminated...Goodbye!");
                    break;
                }
                System.out.println(receiveMessage);
            }
            sendMessage = keyRead.readLine();
            printWriter.println(sendMessage);
            printWriter.flush();
        }
    }
}

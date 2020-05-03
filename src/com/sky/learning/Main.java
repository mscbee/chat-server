package com.sky.learning;

import com.sky.learning.models.Client;
import com.sky.learning.models.Comms;
import com.sky.learning.models.Compile;
import com.sky.learning.models.Server;

public class Main {

    public static void main(String[] args) throws Exception {
        final int PORT = 3000;
        final String IP = "localhost";
        Comms comms = new Comms();
        comms.compile = Compile.SERVER;

        if(comms.compile == Compile.SERVER){
            Server server = new Server();
            server.startServerConnection(PORT);
        }
        else if(comms.compile == Compile.CLIENT) {
            Client client = new Client();
            client.startClientConnection(IP, PORT);
        }
    }
}

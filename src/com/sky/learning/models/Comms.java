package com.sky.learning.models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Comms {
    public static Compile compile;

    PrintWriter printWriter;
    BufferedReader receiveRead;
    BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
    String receiveMessage, sendMessage;
}

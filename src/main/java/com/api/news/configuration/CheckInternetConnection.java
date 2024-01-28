package com.api.news.configuration;

import org.springframework.context.annotation.Configuration;

import java.net.Socket;

@Configuration
public class CheckInternetConnection {
    String dirWeb = "www.google.com";
    int puerto = 80;

    public boolean connection() throws Exception  {
        Socket s = new Socket(dirWeb, puerto);
        if (s.isConnected()) {
            return true;
        }

        return false;
    }
}


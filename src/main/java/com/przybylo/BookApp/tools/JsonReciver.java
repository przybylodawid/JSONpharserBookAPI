package com.przybylo.BookApp.tools;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class JsonReciver {
    final String dLink = "https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40";


    public String reciveJSON(String configlink){
        StringBuffer response = new StringBuffer();

        try {
            //TODO: allow user to change parameter
            URL url = new URL(dLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        }catch (MalformedURLException e) {
            System.out.println("Wrong URL adress. Redirecting to default one");
            e.printStackTrace();
        }catch (IOException e1){
            e1.printStackTrace();
        }
        return response.toString();
    }
}

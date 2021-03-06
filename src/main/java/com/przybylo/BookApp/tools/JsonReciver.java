package com.przybylo.BookApp.tools;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//          JSONReader reads URL JSON Content and return it as a String

@Component
public class JsonReciver {

    public String reciveJSON(String configLink){
        StringBuffer response = new StringBuffer();

        try {
            URL url = new URL(configLink);
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

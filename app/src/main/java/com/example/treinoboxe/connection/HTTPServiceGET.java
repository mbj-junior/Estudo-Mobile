package com.example.treinoboxe.connection;

import android.os.AsyncTask;


import com.example.treinoboxe.Globals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPServiceGET extends AsyncTask<Void, Void, String> {

    private String method;
    private String path;
    private String returnType;

    Globals g;

    public HTTPServiceGET(String method, String path, String returnType) {
        this.path = path;
        this.method = method;
        this.returnType = returnType;

        g = Globals.getInstance();
    }

    @Override
    protected String doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL(g.getUrl() + path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            if (returnType.equals("TEXT"))
                connection.setRequestProperty("Accept", "application/text");
            else if (returnType.equals("JSON"))
                connection.setRequestProperty("Accept", "application/json");

            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }

            System.out.println(resposta);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta.toString();

    }
}

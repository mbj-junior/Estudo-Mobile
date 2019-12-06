package com.example.treinoboxe.connection;

import android.os.AsyncTask;

import com.example.treinoboxe.Globals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPServicePOST extends AsyncTask<Void, Void, String> {

    private String method;
    private String path;
    private String returnType;
    private final String USER_AGENT = "Mozilla/5.0";
    private String query;

    Globals g;

    public HTTPServicePOST(String method, String path, String returnType) {
        this.path = path;
        this.method = method;
        this.returnType = returnType;
        query = null;
        g = Globals.getInstance();
    }

    public HTTPServicePOST(String method, String path, String returnType, String query) {
        this.method = method;
        this.path = path;
        this.returnType = returnType;
        this.query = query;
        g = Globals.getInstance();
    }

    @Override
    protected String doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();
        InputStream response = null;

        try {
            URL url = new URL(g.getUrl() + path);
            System.out.println("TESTE URL: " + url.toString());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Accept-Charset", "UTF-8");

            if (returnType.equals("TEXT"))
                connection.setRequestProperty("Content-Type", "application/text");
            else if (returnType.equals("JSON"))
                connection.setRequestProperty("Content-Type", "application/json");


            connection.setDoOutput(true);

            //mandar requestBody
            connection.setDoInput(true);

            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(query);
            out.flush();

            response = connection.getInputStream();


            connection.setRequestMethod(method);


            int responseCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(response));

            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                resposta.append(inputLine);
            }
            in.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta.toString();

    }
}

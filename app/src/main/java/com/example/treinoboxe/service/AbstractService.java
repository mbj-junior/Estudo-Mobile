package com.example.treinoboxe.service;


import com.example.treinoboxe.connection.HTTPServiceGET;
import com.example.treinoboxe.connection.HTTPServicePOST;

public abstract class AbstractService {

    String resposta = "";

    public Object get() {
        return null;
    }

    protected String getConnection(String path) {
        HTTPServiceGET requisicao = new HTTPServiceGET("GET", path, "JSON");

        String resposta = "";

        try {
            resposta = requisicao.execute().get();
            System.out.println(resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

    protected String postConnection(String path) {

        HTTPServicePOST requisicao = new HTTPServicePOST("POST", path, "JSON");

        try {
            resposta = requisicao.execute().get();
            System.out.println("RESP HTTP: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resposta;
    }


    protected String postConnection(String path, String query) {

        HTTPServicePOST requisicao = new HTTPServicePOST("POST", path, "JSON", query);

        try {
            resposta = requisicao.execute().get();
            System.out.println("RESP HTTP: " + resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resposta;
    }

    public Object save() {
        return null;
    }

    public Object save(String query) {
        return null;
    }
}

package com.example.treinoboxe;

public class Globals {

    private static Globals instance;

    // Global variable
    private String url;

    private String ip = "10.123.66.33";

    private String port = "8080";

    // Restrict the constructor from being instantiated
    private Globals(){}
    //======================================================
    public String getUrl() {
        url = "http://" + ip + ":" + port;
        return url;
    }

    //======================================================
    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}

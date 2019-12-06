package com.example.treinoboxe.service;

import java.util.List;

public class ServiceFabric {

    public List<Object> get() {
        return null;//new ProfileService().getAll();
    }

    public Object save(String query) {
        return null;// query != null ? new ProfileService().save(query) : new ProfileService().save();
    }
}

package com.example.treinoboxe.service;

import com.example.treinoboxe.model.UltimaConfiguracao;
import com.google.gson.Gson;

public class ConfiguracoesService extends AbstractService {

    @Override
    public Object get() {
        //Converte Json em AutomobileModel
        return new Gson().fromJson(super.getConnection("/config"), UltimaConfiguracao.class);
    }

    @Override
    public Object save() {
        //Converte Json em Usuario e retorna
        return new Gson().fromJson(super.postConnection("/config"), UltimaConfiguracao.class);
    }

}

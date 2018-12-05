package com.stbsargentina.entregablemuseomoma.model.DAO;

import com.stbsargentina.entregablemuseomoma.model.POJO.PaintContainer;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PaintService {

    @GET
    Call<PaintContainer> getPaints(@Url String baseUrl);
}

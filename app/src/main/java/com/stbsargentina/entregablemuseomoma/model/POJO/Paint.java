package com.stbsargentina.entregablemuseomoma.model.POJO;

import java.io.Serializable;

public class Paint implements Serializable{
    private Integer imagen;
    private String name;
    private Integer artistId;

    public Integer getArtistId() {
        return artistId;
    }

    public Integer getImagen() {
        return imagen;
    }

    public String getName() {
        return name;
    }
}

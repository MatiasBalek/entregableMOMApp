package com.stbsargentina.entregablemuseomoma.model.POJO;

import java.io.Serializable;

public class Paint implements Serializable{
    private String imagen;
    private String name;
    private Integer artistId;

    public Paint (){

    }
    public Paint(Integer artistID, String imagen, String name){
        this.artistId = artistID;
        this.imagen = imagen;
        this.name = name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public String getImagen() {
        return imagen;
    }

    public String getName() {
        return name;
    }
}

package com.stbsargentina.entregablemuseomoma.model.POJO;

import java.io.Serializable;

public class Paint implements Serializable{
    private String image;
    private String name;
    private String artistId;
    private String urlImagen;

    public Paint (){

    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Paint(String artistID, String image, String name){
        this.artistId = artistID;
        this.image = image;
        this.name = name;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}

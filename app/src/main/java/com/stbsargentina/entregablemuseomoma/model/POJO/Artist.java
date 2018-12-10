package com.stbsargentina.entregablemuseomoma.model.POJO;

public class Artist {
    private String artistId;
    private String name;
    private String nationality;

    public Artist(){

    }

    public Artist(String artistId, String name, String nationality) {
        this.artistId = artistId;
        this.name = name;
        this.nationality = nationality;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

}

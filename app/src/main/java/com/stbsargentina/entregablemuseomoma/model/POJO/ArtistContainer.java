package com.stbsargentina.entregablemuseomoma.model.POJO;

import java.util.ArrayList;
import java.util.List;

public class ArtistContainer {
    private List<Artist>listaDeArtists;

    public List<Artist> getListaDeArtists() {
        return listaDeArtists;
    }

    public ArtistContainer(){
        this.listaDeArtists = new ArrayList<>();
    }
}

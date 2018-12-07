package com.stbsargentina.entregablemuseomoma.controller;

import com.stbsargentina.entregablemuseomoma.model.DAO.DAOArtist;
import com.stbsargentina.entregablemuseomoma.model.POJO.Artist;
import com.stbsargentina.entregablemuseomoma.model.POJO.ArtistContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

import java.util.ArrayList;

public class ArtistController {

    public void getArtists(ResultListener<ArtistContainer> listener){
        DAOArtist daoArtist = new DAOArtist();
        daoArtist.getArtists(new ArrayList<Artist>());
    }
}

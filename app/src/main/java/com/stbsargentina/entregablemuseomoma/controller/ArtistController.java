package com.stbsargentina.entregablemuseomoma.controller;

import com.stbsargentina.entregablemuseomoma.model.DAO.DAOArtist;
import com.stbsargentina.entregablemuseomoma.model.POJO.Artist;
import com.stbsargentina.entregablemuseomoma.model.POJO.ArtistContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

import java.util.ArrayList;

public class ArtistController {

    public void getArtists(final ResultListener<Artist> listener, String artistId){
        DAOArtist daoArtist = new DAOArtist();
        daoArtist.getArtists(new ResultListener<Artist>() {
            @Override
            public void finish(Artist result) {
                listener.finish(result);
            }
        }, artistId);
    }
}

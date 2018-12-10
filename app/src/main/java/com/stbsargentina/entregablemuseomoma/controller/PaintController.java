package com.stbsargentina.entregablemuseomoma.controller;

import android.net.Uri;

import com.stbsargentina.entregablemuseomoma.model.DAO.DAOPaints;
import com.stbsargentina.entregablemuseomoma.model.POJO.Paint;
import com.stbsargentina.entregablemuseomoma.model.POJO.PaintContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

public class PaintController {

    public void getPaints(final ResultListener<PaintContainer> listenerDeLaView){
        //Instancio un DAO
        DAOPaints daoPaints = new DAOPaints();
        //Pido al DAO
        daoPaints.getPaints(new ResultListener<PaintContainer>() {
            @Override
            public void finish(PaintContainer result) {
                listenerDeLaView.finish(result);
            }
        });
    }
    public void getImageFromFirebase(final ResultListener<Uri>listener, String imagen){
    DAOPaints daoPaints = new DAOPaints();
    daoPaints.getImageFromFirebase(new ResultListener<Uri>() {
        @Override
        public void finish(Uri result) {
            listener.finish(result);
        }
    }, imagen);
    }
}
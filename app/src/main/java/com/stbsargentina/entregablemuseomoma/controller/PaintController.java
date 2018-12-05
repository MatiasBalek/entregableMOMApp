package com.stbsargentina.entregablemuseomoma.controller;

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
}
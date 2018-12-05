package com.stbsargentina.entregablemuseomoma.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stbsargentina.entregablemuseomoma.R;
import com.stbsargentina.entregablemuseomoma.controller.PaintController;
import com.stbsargentina.entregablemuseomoma.model.POJO.Paint;
import com.stbsargentina.entregablemuseomoma.model.POJO.PaintContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;


public class FragmentDetalle extends Fragment implements AdapterPaints.ListenerAdapterPaints{

private View viewDelFragment;
private ListenerFragmentDetalle listenerFragmentDetalle;
private AdapterPaints adapterPaints;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewDelFragment = inflater.inflate(R.layout.fragment_fragment_detalle, container, false);
        RecyclerView recyclerViewPaints = viewDelFragment.findViewById(R.id.recycler_view_paints);
        adapterPaints = new AdapterPaints(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPaints.setAdapter(adapterPaints);
        recyclerViewPaints.setLayoutManager(linearLayoutManager);
        getPaints();
        return viewDelFragment;
    }

    @Override
    public void paintSeleccionada(Paint paint) {
    listenerFragmentDetalle = (ListenerFragmentDetalle) getContext();
    listenerFragmentDetalle.pinturaSeleccionada(paint);
    }

    public interface ListenerFragmentDetalle{
        public void pinturaSeleccionada(Paint paint);
    }
    public void getPaints(){
        new PaintController().getPaints(new ResultListener<PaintContainer>() {
            @Override
            public void finish(PaintContainer result) {
                adapterPaints.setListaDePinturas(result.getPaints());
            }
        });
    }
}
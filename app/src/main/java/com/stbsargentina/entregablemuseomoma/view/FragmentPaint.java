package com.stbsargentina.entregablemuseomoma.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stbsargentina.entregablemuseomoma.R;
import com.stbsargentina.entregablemuseomoma.controller.ArtistController;
import com.stbsargentina.entregablemuseomoma.model.POJO.Artist;
import com.stbsargentina.entregablemuseomoma.model.POJO.Paint;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;


public class FragmentPaint extends Fragment {

    private ImageView imageViewPaint;
    private TextView textViewObra;
    private TextView textViewArtista;
    private TextView textViewNacionalidad;
    private View viewDelFragment;

    public static final String CLAVE_PAINT = "paint";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewDelFragment = inflater.inflate(R.layout.fragment_paint, container, false);
        imageViewPaint = viewDelFragment.findViewById(R.id.image_view_paint_fragment);
        textViewObra = viewDelFragment.findViewById(R.id.text_view_paint_fragment_obra);
        textViewArtista = viewDelFragment.findViewById(R.id.text_view_paint_fragment_artista);
        textViewNacionalidad = viewDelFragment.findViewById(R.id.text_view_paint_fragment_nacionalidad);
        Bundle nuevoBundle = getArguments();
        Paint paint = (Paint) nuevoBundle.getSerializable(CLAVE_PAINT);
        textViewObra.setText(paint.getName());
        ArtistController artistController = new ArtistController();
        artistController.getArtists(new ResultListener<Artist>() {
            @Override
            public void finish(Artist result) {
                textViewArtista.setText(result.getName());
                textViewNacionalidad.setText(result.getNationality());
                }
        }, paint.getArtistId());
        Glide.with(viewDelFragment).load(paint.getUrlImagen()).into(imageViewPaint);
        return viewDelFragment;
    }

}

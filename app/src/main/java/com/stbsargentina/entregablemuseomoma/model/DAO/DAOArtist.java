package com.stbsargentina.entregablemuseomoma.model.DAO;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stbsargentina.entregablemuseomoma.controller.ArtistController;
import com.stbsargentina.entregablemuseomoma.model.POJO.Artist;
import com.stbsargentina.entregablemuseomoma.model.POJO.ArtistContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAOArtist {

    private DatabaseReference mDatabase;

    public void getArtists(final ResultListener<Artist>artistResultListener, final String idArtist){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //final DatabaseReference artisReference = mDatabase.child();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArtistContainer artistContainer = dataSnapshot.getValue(ArtistContainer.class);
                for (Artist artist:artistContainer.getArtists()) {
                if (artist.getArtistId().equals(idArtist)){
                    artistResultListener.finish(artist);
                }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("hjh", "gggg");
            }
        });
    }
}


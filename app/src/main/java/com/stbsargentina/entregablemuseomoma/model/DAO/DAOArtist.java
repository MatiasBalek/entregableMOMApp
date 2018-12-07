package com.stbsargentina.entregablemuseomoma.model.DAO;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stbsargentina.entregablemuseomoma.model.POJO.Artist;
import com.stbsargentina.entregablemuseomoma.model.POJO.ArtistContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAOArtist {

    private DatabaseReference mDatabase;

    public void getArtists(ResultListener<ArtistContainer>artistContainerResultListener){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference artisReference = mDatabase.child("artists");
        artisReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Artist>listaDeArtistas = new ArrayList<>();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


package com.stbsargentina.entregablemuseomoma.model.DAO;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.stbsargentina.entregablemuseomoma.model.POJO.Paint;
import com.stbsargentina.entregablemuseomoma.model.POJO.PaintContainer;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DAOPaints extends MyRetrofit{
        //Defino la urlBase
        private static final String BASE_URL = "https://api.myjson.com/bins/x858r/";
        //Atributo Service, que me va a permitir hacer las llamadas definidas
        private PaintService paintService;


    public DAOPaints() {
        super(BASE_URL);
        paintService = retrofit.create(PaintService.class);
    }

    public void getPaints(final ResultListener<PaintContainer> listenerDelController){
        //Creo la llamada pidiendosela al service
        Call<PaintContainer> call = paintService.getPaints(BASE_URL);
        //Encolo la llamada
        call.enqueue(new Callback<PaintContainer>() {
            @Override
            public void onResponse(Call<PaintContainer> call, Response<PaintContainer> response) {
                PaintContainer paintContainer = response.body();
                listenerDelController.finish(paintContainer);
            }

            @Override
            public void onFailure(Call<PaintContainer> call, Throwable t) {
            }


            });
        }
    public void getImageFromFirebase(final ResultListener<Uri> listener, String imagen){
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference referenciaRaiz = storage.getReference();
        StorageReference pathReference = referenciaRaiz.child(imagen);
        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                listener.finish(uri);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                listener.finish(null);
            }
        });


    }
    }

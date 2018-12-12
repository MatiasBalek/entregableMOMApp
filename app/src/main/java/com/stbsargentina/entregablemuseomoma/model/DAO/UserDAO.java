package com.stbsargentina.entregablemuseomoma.model.DAO;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.stbsargentina.entregablemuseomoma.util.ResultListener;

import java.util.Date;

public class UserDAO {

    private FirebaseStorage storage = FirebaseStorage.getInstance();


    public void uploadProfileImageToFirebase(String usuario, byte[] bytes, final ResultListener<String> listener){
        //Accedo a la raiz del directorio
        StorageReference referenciaRaiz = storage.getReference();
        //
        final StorageReference referenciaCarpetaImagenes = referenciaRaiz.child("users/" + usuario);
        //
        final StorageReference referenciaCarpetaUsuario = referenciaCarpetaImagenes.child(new Date().getTime() + ".jpg");

        UploadTask uploadTask = referenciaCarpetaUsuario.putBytes(bytes);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                listener.finish("Error");

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //Conseguir la URL donde se guardó la imagen
                referenciaCarpetaUsuario.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        listener.finish(task.getResult().toString());


                    }
                });
            }
        });
    }

}

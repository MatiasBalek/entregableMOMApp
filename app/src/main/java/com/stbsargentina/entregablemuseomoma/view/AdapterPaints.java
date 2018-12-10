package com.stbsargentina.entregablemuseomoma.view;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stbsargentina.entregablemuseomoma.R;
import com.stbsargentina.entregablemuseomoma.model.POJO.Paint;

import java.util.ArrayList;
import java.util.List;

public class AdapterPaints extends RecyclerView.Adapter<AdapterPaints.PaintViewHolder> {

    private List<Paint> listaDePinturas;
    private ListenerAdapterPaints listenerAdapterPaints;

    public void setListaDePinturas(List<Paint> listaDePinturas) {
        this.listaDePinturas = listaDePinturas;
        notifyDataSetChanged();
    }

    public void addPaint(Paint paint){
        this.listaDePinturas.add(paint);
        notifyDataSetChanged();
    }

    public AdapterPaints(ListenerAdapterPaints listenerAdapterPaints){
        this.listaDePinturas = new ArrayList<>();
        this.listenerAdapterPaints = listenerAdapterPaints;
    }

    @NonNull
    @Override
    public PaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflador = LayoutInflater.from(parent.getContext());
        View view = inflador.inflate(R.layout.celda_pintura, parent, false);
        PaintViewHolder paintViewHolder = new PaintViewHolder(view);
        return paintViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaintViewHolder holder, int position) {
    Paint paint = listaDePinturas.get(position);
    holder.bindPaint(paint);
    }

    @Override
    public int getItemCount() {
        return listaDePinturas.size();
    }

    public class PaintViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private ImageView imageViewImagen;

        public PaintViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            imageViewImagen = itemView.findViewById(R.id.image_view_pintura);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerAdapterPaints.paintSeleccionada(listaDePinturas.get(getAdapterPosition()));
                }
            });
        }
        public void bindPaint(Paint paint){
            textViewName.setText(paint.getName());
            Glide.with(itemView).load(paint.getUrlImagen()).into(imageViewImagen);
        }
    }


    public interface ListenerAdapterPaints{
        public void paintSeleccionada(Paint paint);
    }
}

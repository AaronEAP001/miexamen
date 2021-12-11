package com.example.miexamen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageRequest;
import com.example.miexamen.network.ImageRequester;
import com.example.miexamen.network.MiExamenEntry;

import java.util.List;

public class DatosCardRecyclerViewAdapter extends RecyclerView.Adapter<DatosCardViewHolder> {
    private List<MiExamenEntry> datosList;
    private ImageRequester imageRequester;

    DatosCardRecyclerViewAdapter(List<MiExamenEntry>datosList){
        this.datosList = datosList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public DatosCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos_card,parent,false);
        return new DatosCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosCardViewHolder holder,int position){
        if (datosList != null & position < datosList.size()){
            MiExamenEntry datos = datosList.get(position);
            holder.user_name.setText(datos.user_name);
            holder.post_msm.setText(datos.post_msm);
            holder.coment.setText(datos.coment);
            holder.like.setText(datos.like);
            imageRequester.setImageFromUrl(holder.User_foto, datos.User_foto);
            imageRequester.setImageFromUrl(holder.post_foto, datos.post_foto);
        }
    }

    @Override
    public int getItemCount() {
        return datosList.size();
    }
}

















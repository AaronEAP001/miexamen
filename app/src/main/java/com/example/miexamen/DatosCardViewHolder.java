package com.example.miexamen;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class DatosCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView User_foto;
    public TextView user_name;
    public NetworkImageView post_foto;
    public TextView post_msm;
    public TextView coment;
    public TextView like;

    DatosCardViewHolder(@NonNull View itemView){
        super(itemView);
        User_foto = itemView.findViewById(R.id.datos_image_user);
        user_name = itemView.findViewById(R.id.datos_user_name);
        post_foto = itemView.findViewById(R.id.datos_image);
        post_msm = itemView.findViewById(R.id.datos_mensajes);
        coment = itemView.findViewById(R.id.datos_title);
        like=itemView.findViewById(R.id.datos_title2);
    }

}

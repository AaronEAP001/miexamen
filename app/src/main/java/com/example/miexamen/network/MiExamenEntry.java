package com.example.miexamen.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.miexamen.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class MiExamenEntry {
    private static final String TAG = MiExamenEntry.class.getSimpleName();

    public final Integer id_user;
    public final Uri dynamiUser;
    public final String User_foto;
    public final String user_name;

    public final Uri dynamiPost;
    public final String post_foto;

    public final String post_msm;
    public final String coment;
    public final String like;

    public MiExamenEntry(Integer id_user,String dynamiUser, String User_foto, String user_name, String dynamiPost, String post_foto, String post_msm,String coment, String like){
        this.id_user=id_user;
        this.dynamiUser=Uri.parse(dynamiUser);
        this.User_foto=User_foto;
        this.user_name=user_name;
        this.dynamiPost=Uri.parse(dynamiPost);
        this.post_foto=post_foto;
        this.post_msm=post_msm;
        this.coment=coment;
        this.like=like;
    }

    public static List<MiExamenEntry> initMiExamenEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.datos);
        Writer writer = new StringWriter();
        char[] buffer = new char[2000];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1){
                writer.write(buffer,0,pointer);
            }
        }catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de escribir JSON",exception);
        }finally {
            try {
                inputStream.close();
            }catch (IOException exception){
                Log.e(TAG,"Hubo un error al cerrar el input",exception);
            }
        }

        String jsonDatosMiExamenString = writer.toString();
        Gson gson = new Gson();
        Type datosMiExamenList = new TypeToken<ArrayList<MiExamenEntry>>(){
        }.getType();

        return gson.fromJson(jsonDatosMiExamenString, datosMiExamenList);
    }


}
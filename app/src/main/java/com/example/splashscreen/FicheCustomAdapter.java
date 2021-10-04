package com.example.splashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FicheCustomAdapter extends ArrayAdapter<Fiche>{
    private Context mContext;
    private ArrayList<Fiche> serieList=new ArrayList<>();

    public FicheCustomAdapter(Context context, ArrayList<Fiche> list){
        super(context,0,list);
        mContext = context;
        serieList =  list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItem = convertView;
        if(listItem==null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_serie,parent,false);
        Fiche currentSerie = serieList.get(position);
        TextView nom = (TextView) listItem.findViewById(R.id.mois);
        TextView premDiff = (TextView) listItem.findViewById(R.id.etat);


        nom.setText(currentSerie.getMois());
        premDiff.setText(currentSerie.getEtat());

        return listItem;
    }

}

package com.example.celulares;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorCelular extends RecyclerView.Adapter<AdaptadorCelular.CelularViewHolder> {
    private ArrayList<Celular> celulares;

    public AdaptadorCelular(ArrayList<Celular> celulares){
        this.celulares = celulares;
    }
    @NonNull
    @Override
    public CelularViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_celular,viewGroup,false);
        return new CelularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CelularViewHolder celularViewHolder, int i) {
        Celular cel = celulares.get(i);
        celularViewHolder.foto.setImageResource(cel.getFoto());
        celularViewHolder.codigo.setText(cel.getCodigo());
        celularViewHolder.marca.setText(cel.getMarca());
        celularViewHolder.modelo.setText(cel.getModelo());
        celularViewHolder.ram.setText(cel.getRam());
        celularViewHolder.almacenamiento.setText(cel.getAlmacenamiento());
    }

    @Override
    public int getItemCount() {
        return celulares.size();
    }

    public static class CelularViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView codigo;
        private TextView marca;
        private TextView modelo;
        private TextView ram;
        private TextView almacenamiento;
        private View v;

        public CelularViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            codigo = v.findViewById(R.id.lblCodigo);
            marca = v.findViewById(R.id.lblMarca);
            modelo = v.findViewById(R.id.lblModelo);
            ram = v.findViewById(R.id.lblRam);
            almacenamiento = v.findViewById(R.id.lblAlmacenamiento);
        }
    }
}

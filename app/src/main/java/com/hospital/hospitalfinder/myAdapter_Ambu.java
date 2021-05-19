package com.hospital.hospitalfinder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter_Ambu extends RecyclerView.Adapter<myAdapter_Ambu.myviewholder> {

    ArrayList<AmbulanceModel> datalist;


    public myAdapter_Ambu(ArrayList<AmbulanceModel> datalist) {
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ambulance,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.Ambulance_Name.setText(datalist.get(position).getAmbulance_Name());
        holder.Ambulance_Number.setText(datalist.get(position).getAmbulance_Number());
        holder.City.setText(datalist.get(position).getCity());








    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView  Ambulance_Name,City,Ambulance_Number;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            Ambulance_Number = itemView.findViewById(R.id.ambulance_number);

            City = itemView.findViewById(R.id.city_name);
            Ambulance_Name = itemView.findViewById(R.id.ambulance_name);






        }
    }



}

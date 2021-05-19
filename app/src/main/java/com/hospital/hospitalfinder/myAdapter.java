package com.hospital.hospitalfinder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myviewholder> {

    ArrayList<HospitalModel> datalist;


    public myAdapter(ArrayList<HospitalModel> datalist) {
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hospital,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.Address.setText(datalist.get(position).getAddress());
        holder.Ambulance_Number.setText(datalist.get(position).getAmbulance_Number());
        holder.Beds.setText(datalist.get(position).getBeds());
        holder.City.setText(datalist.get(position).getCity());
        holder.Contact_Info.setText(datalist.get(position).getContact_Info());
        holder.Doctors.setText(datalist.get(position).getDoctors());
        holder.Hospital_Name.setText(datalist.get(position).getHospital_Name());
        holder.Nurses.setText(datalist.get(position).getNurses());
        holder.Oxygen.setText(datalist.get(position).getOxygen());







    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView  Hospital_Name,Address,City,Oxygen,Beds,Doctors,Contact_Info,Nurses,Ambulance_Number;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            Address = itemView.findViewById(R.id.add);
            Ambulance_Number = itemView.findViewById(R.id.ambu);
            Beds = itemView.findViewById(R.id.bed);
            City = itemView.findViewById(R.id.city);
            Contact_Info = itemView.findViewById(R.id.info);
            Doctors = itemView.findViewById(R.id.docs);
            Hospital_Name = itemView.findViewById(R.id.hosname);
            Nurses = itemView.findViewById(R.id.nurs);
            Oxygen= itemView.findViewById(R.id.oxy);





        }
    }



}

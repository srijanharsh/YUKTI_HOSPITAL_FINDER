package com.hospital.hospitalfinder;

public class AmbulanceModel {

    String Ambulance_Name,Ambulance_Number,City;
    public  AmbulanceModel(){}

    public String getAmbulance_Name() {
        return Ambulance_Name;
    }

    public void setAmbulance_Name(String ambulance_Name) {
        Ambulance_Name = ambulance_Name;
    }

    public String getAmbulance_Number() {
        return Ambulance_Number;
    }

    public void setAmbulance_Number(String ambulance_Number) {
        Ambulance_Number = ambulance_Number;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public AmbulanceModel(String Ambulance_Name, String Ambulance_Number , String City ) {
        this.Ambulance_Name = Ambulance_Name;
        this.City = City;
        this.Ambulance_Number = Ambulance_Number;

    }

}

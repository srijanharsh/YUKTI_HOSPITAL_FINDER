package com.hospital.hospitalfinder;

public class HospitalModel {
    String Hospital_Name,Address,City,Oxygen,Beds,Nurses,Doctors,Contact_Info,Ambulance_Number;
   public  HospitalModel(){}

    public String getHospital_Name() {
        return Hospital_Name;
    }

    public void setHospital_Name(String hospital_Name) {
        Hospital_Name = hospital_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getOxygen() {
        return Oxygen;
    }

    public void setOxygen(String oxygen) {
        Oxygen = oxygen;
    }

    public String getBeds() {
        return Beds;
    }

    public void setBeds(String beds) {
        Beds = beds;
    }

    public String getNurses() {
        return Nurses;
    }

    public void setNurses(String nurses) {
        Nurses = nurses;
    }

    public String getDoctors() {
        return Doctors;
    }

    public void setDoctors(String doctors) {
        Doctors = doctors;
    }

    public String getContact_Info() {
        return Contact_Info;
    }

    public void setContact_Info(String contact_Info) {
        Contact_Info = contact_Info;
    }

    public String getAmbulance_Number() {
        return Ambulance_Number;
    }

    public void setAmbulance_Number(String ambulance_Number) {
        Ambulance_Number = ambulance_Number;
    }

    public HospitalModel(String Hospital_Name, String Address , String City , String Oxygen , String Beds , String Nurses, String Doctors, String Contact_Info, String Ambulance_Number) {
        this.Hospital_Name = Hospital_Name;
        this.Address = Address;
        this.City = City;
        this.Oxygen = Oxygen;
        this.Beds = Beds;
        this.Nurses = Nurses;
        this.Doctors =Doctors;
        this.Contact_Info = Contact_Info;
        this.Ambulance_Number = Ambulance_Number;

    }


}

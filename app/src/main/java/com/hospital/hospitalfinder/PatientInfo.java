package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PatientInfo extends AppCompatActivity {

    Toolbar toolbar;
    Button submit;
    EditText pname,add,city,blood,oxy,sugar,pressure,number,doc,med;
    FirebaseAuth fAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        submit = (Button)findViewById(R.id.Submit);
        pname = (EditText)findViewById(R.id.Patient_Name);
        add = (EditText)findViewById(R.id.Address);
        city = (EditText)findViewById(R.id.City);
        blood = (EditText)findViewById(R.id.Blood_Group);
        oxy = (EditText)findViewById(R.id.Blood_Oxygen_Level);
        sugar = (EditText)findViewById(R.id.Sugar_Level);
        pressure = (EditText)findViewById(R.id.Blood_Pressure);
        number = (EditText)findViewById(R.id.Mobile_Number);
        doc = (EditText)findViewById(R.id.Consulting_Doctor);
        med = (EditText)findViewById(R.id.Medication);
        toolbar = (Toolbar) findViewById(R.id.toolbarhHome);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Map<String, Object> data = new HashMap<>();
                data.put("Patient_Name", pname.getText().toString());
                data.put("Address", add.getText().toString());
                data.put("City", city.getText().toString());
                data.put("Blood_Group", blood.getText().toString());
                data.put("Blood_Oxygen_Level", oxy.getText().toString());
                data.put("Sugar_Level", sugar.getText().toString());
                data.put("Blood_Pressure", pressure.getText().toString());
                data.put("Mobile_Number", number.getText().toString());
                data.put("Medication", med.getText().toString());
                data.put("Consulting_Doctor", doc.getText().toString());



                db.collection("Patient_Info").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(PatientInfo.this, "Successfully submitted", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(getApplicationContext(), PatientProfile.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PatientInfo.this, "Failed to submit", Toast.LENGTH_SHORT).show();
                    }
                });

            }




        });
    }
}
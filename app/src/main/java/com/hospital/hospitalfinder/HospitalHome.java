package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HospitalHome extends AppCompatActivity {
    Toolbar toolbar;
    EditText hname;
    EditText add;
    EditText beds,oxy,doc,nur,info,ambu,city;
    Button submit;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_home);
        submit = (Button)findViewById(R.id.Submit);
        toolbar = (Toolbar) findViewById(R.id.toolbarhHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        hname = (EditText) findViewById(R.id.HospitalName);
        add = (EditText) findViewById(R.id.Address);
        beds = (EditText) findViewById(R.id.Beds);
        oxy = (EditText) findViewById(R.id.Oxygen);
        doc = (EditText) findViewById(R.id.Docs);
        nur = (EditText) findViewById(R.id.Nurses);
        info = (EditText) findViewById(R.id.Info);
        ambu = (EditText) findViewById(R.id.Ambulance);
        city = (EditText) findViewById(R.id.City);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkField(hname);
                checkField(add);
                checkField(beds);
                checkField(oxy);
                checkField(doc);
                checkField(nur);
                checkField(info);
                checkField(ambu);
                checkField(city);
                if (valid) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("Hospital_Name", hname.getText().toString());
                    data.put("Address", add.getText().toString());
                    data.put("Beds", beds.getText().toString());
                    data.put("Oxygen", oxy.getText().toString());
                    data.put("Doctors", doc.getText().toString());
                    data.put("Nurses", nur.getText().toString());
                    data.put("Contact_Info", info.getText().toString());
                    data.put("Ambulance_Number", ambu.getText().toString());
                    data.put("City", city.getText().toString());


                    db.collection("Hospital_Info").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).set(data)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(HospitalHome.this, "Successfully submitted", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(getApplicationContext(), HospitalHome2.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(HospitalHome.this, "Failed to submit", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
            int id = item.getItemId();
            switch (id) {
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(), PatientLogin.class));
                    finish();


                default:
                    return super.onOptionsItemSelected(item);
            }
        }

    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }

}
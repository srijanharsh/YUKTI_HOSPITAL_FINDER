package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class HospitalHome2 extends AppCompatActivity {

    Button update;
    TextView view;
    FirebaseFirestore db ;
    ProgressBar loadingPB;
    DocumentReference documentReference;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_home2);

        update = (Button)findViewById(R.id.update);
        view = (TextView)findViewById(R.id.view);
        loadingPB = findViewById(R.id.idProgressBar);
        toolbar = (Toolbar) findViewById(R.id.toolbarhHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(getApplicationContext(),HospitalUpdate.class));
            }
        });
        db = FirebaseFirestore.getInstance();
        documentReference= db.collection("Hospital_Info").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            loadingPB.setVisibility(View.GONE);
                            String hname = documentSnapshot.getString("Hospital_Name");
                            String add = documentSnapshot.getString("Address");
                            String beds = documentSnapshot.getString("Beds");
                            String oxy = documentSnapshot.getString("Oxygen");
                            String doc = documentSnapshot.getString("Doctors");
                            String nur = documentSnapshot.getString("Nurses");
                            String info = documentSnapshot.getString("Contact_Info");
                            String ambu = documentSnapshot.getString("Ambulance_Number");
                            String city = documentSnapshot.getString("City");
                            view.setText("Hospital Name: "+ hname +"\n\n"+ "Address: "+add+"\n\n"+"City: "+city+"\n\n"+"Beds: "+beds+"\n\n"+"Oxygen: "+oxy+"\n\n" +
                                    "Doctors: "+doc+"\n\n"+"Nurses: "+nur+"\n\n"+"Contact Info: "+info+"\n\n"+"Ambulance Number: "+ambu+"\n\n"+"\n\n");

                        }
                        else {
                            loadingPB.setVisibility(View.GONE);
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(HospitalHome2.this, "No Information found in Database", Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(HospitalHome2.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
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

}
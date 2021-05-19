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

public class PatientProfile extends AppCompatActivity {


    Toolbar toolbar;
    Button update;
    Button gotohome;
    TextView View;
    FirebaseFirestore db ;
    ProgressBar loadingPB;
    DocumentReference documentReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        View = (TextView)findViewById(R.id.view);
        loadingPB = findViewById(R.id.idProgressBar);
        toolbar = (Toolbar) findViewById(R.id.toolbarpHome);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        update = (Button)findViewById(R.id.update);
        gotohome = (Button)findViewById(R.id.GotoHome);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PatientInfo.class));
            }
        });
        gotohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PatientHome.class));
            }
        });
        db = FirebaseFirestore.getInstance();
        documentReference= db.collection("Patient_Info").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            loadingPB.setVisibility(View.GONE);
                            String pname = documentSnapshot.getString("Patient_Name");
                            String add = documentSnapshot.getString("Address");
                            String blood = documentSnapshot.getString("Blood_Group");
                            String oxy = documentSnapshot.getString("Blood_Oxygen_Level");
                            String sugar = documentSnapshot.getString("Sugar_Level");
                            String pressure = documentSnapshot.getString("Blood_Pressure");
                            String number = documentSnapshot.getString("Mobile_Number");
                            String med = documentSnapshot.getString("Medication");
                            String city = documentSnapshot.getString("City");
                            String doc = documentSnapshot.getString("Consulting_Doctor");

                            View.setText("Patient Name: "+ pname +"\n\n"+ "Address: "+add+"\n\n"+"City: "+city+"\n\n"+"Blood Group: "+blood+"\n\n"+"Blood Oxygen Level: "+oxy+"\n\n" +
                                    "Blood Sugar Level: "+sugar+"\n\n"+"Blood Pressure: "+pressure+"\n\n"+"Mobile Number: "+number+"\n\n"+"Medication : "+med+"\n\n"+"Consulting_Doctor: "+doc+"\n\n");

                        }
                        else {
                            loadingPB.setVisibility(View.GONE);
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(PatientProfile.this, "No Information found in Database", Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PatientProfile.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
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
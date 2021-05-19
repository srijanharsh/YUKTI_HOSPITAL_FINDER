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

public class HospitalUpdate extends AppCompatActivity {
        Button submitupdate;
    boolean valid = true;
    Toolbar toolbar;
    EditText beds,oxy,doc,nur;
    FirebaseAuth fAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_update);
        toolbar = (Toolbar) findViewById(R.id.toolbarhHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        submitupdate = (Button)findViewById(R.id.SubmitUpdate);
        beds = (EditText) findViewById(R.id.Beds);
        oxy = (EditText) findViewById(R.id.Oxygen);
        doc = (EditText) findViewById(R.id.Docs);
        nur = (EditText) findViewById(R.id.Nurses);
        submitupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(beds);
                checkField(oxy);
                checkField(doc);
                checkField(nur);

                if(valid){
                    Map<String, Object> data = new HashMap<>();
                    data.put("Beds", beds.getText().toString());
                    data.put("Oxygen", oxy.getText().toString());
                    data.put("Doctors", doc.getText().toString());
                    data.put("Nurses", nur.getText().toString());

                    db.collection("Hospital_Info").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).update(data)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(HospitalUpdate.this, "Successfully submitted", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(getApplicationContext(), HospitalHome2.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(HospitalUpdate.this, "Failed to submit", Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });
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
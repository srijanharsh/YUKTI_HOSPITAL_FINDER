package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewAccount extends AppCompatActivity {
    Button Alreadyaccount;
   // Button registerhospital;
    Button registerpatient;
    EditText newemail;
    EditText newpass,cnfpass;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        Alreadyaccount = (Button)findViewById(R.id.alreadyaccount);
       // registerhospital =(Button)findViewById(R.id.RegisterasH);
        registerpatient =(Button)findViewById(R.id.RegisterasP);
        newemail = (EditText)findViewById(R.id.Newemail);
        newpass = (EditText)findViewById(R.id.Newpassword);
        cnfpass = (EditText)findViewById(R.id.confpass);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        Alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PatientLogin.class);
                startActivity(i);
            }
        });


     /**  registerhospital.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               checkField(newemail);
               checkField(newpass);
               checkField(cnfpass);
               if(newpass.getText().toString().equals( cnfpass.getText().toString())){
               if(valid){
                   //start the user registration process

                   fAuth.createUserWithEmailAndPassword(newemail.getText().toString(),newpass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           FirebaseUser user = fAuth.getCurrentUser();
                           Toast.makeText(NewAccount.this,"Account Created", Toast.LENGTH_SHORT).show();
                           DocumentReference df = fStore.collection("Users").document(user.getUid());
                           Map<String,Object> userInfo =  new HashMap<>();
                           userInfo.put("UserEmail",newemail.getText().toString());
                           userInfo.put("Password",newpass.getText().toString());


                           //specify if the user is admin
                           userInfo.put("isAdmin","1");

                           df.set(userInfo);

                           startActivity(new Intent(getApplicationContext(),HospitalHome.class));
                           finish();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(NewAccount.this,"Failed to create account", Toast.LENGTH_SHORT).show();
                       }
                   });
               }
               }else{
                   Toast.makeText(NewAccount.this,"Password and Confirm Password must be same", Toast.LENGTH_SHORT).show();
               }
           }
       });
**/

        registerpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(newemail);
                checkField(newpass);
                checkField(cnfpass);
                if(newpass.getText().toString().equals( cnfpass.getText().toString())){
                if(valid){
                    //start the user registration process

                    fAuth.createUserWithEmailAndPassword(newemail.getText().toString(),newpass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(NewAccount.this,"Account Created", Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String,Object> userInfo =  new HashMap<>();
                            userInfo.put("UserEmail",newemail.getText().toString());
                            userInfo.put("Password",newpass.getText().toString());


                            //specify if the user is admin
                            userInfo.put("isUser","1");

                            df.set(userInfo);

                            startActivity(new Intent(getApplicationContext(),PatientInfo.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(NewAccount.this,"Failed to create account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }else{
                    Toast.makeText(NewAccount.this,"Password and Confirm Password must be same", Toast.LENGTH_SHORT).show();
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
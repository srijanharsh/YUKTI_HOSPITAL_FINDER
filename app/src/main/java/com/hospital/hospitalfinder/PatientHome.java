package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PatientHome extends AppCompatActivity {


    RecyclerView mFirestoreList;
    FirebaseFirestore db;
    myAdapter adapter;
    ArrayList<HospitalModel> datalist;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_home);
        mFirestoreList = findViewById(R.id.firestore_list);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        datalist = new ArrayList<>();
        adapter=new myAdapter(datalist);
        mFirestoreList.setAdapter(adapter);
        toolbar = (Toolbar) findViewById(R.id.toolbarpHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //new code
        db.collection("Hospital_Info").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        HospitalModel obj = d.toObject(HospitalModel.class);
                        datalist.add(obj);
                    }
                    adapter.notifyDataSetChanged();
                }else{

                    Toast.makeText(PatientHome.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PatientHome.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        return true;

                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(),News.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ambu:
                        startActivity(new Intent(getApplicationContext(),Ambulance.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hmenu2, menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView =  (SearchView)item.getActionView();
        searchView.setQueryHint("search city name");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                processsearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

               processsearch(newText);
                return false;
            }
        });
        return true;
    }

    private void processsearch(String s) {

        db.collection("Hospital_Info").orderBy("City").startAt(s.trim()).endAt(s.trim()+"\uf8ff")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                datalist.clear();
                if (!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        HospitalModel obj = d.toObject(HospitalModel.class);

                        datalist.add(obj);
                    }
                    adapter.notifyDataSetChanged();
                }else{

                    Toast.makeText(PatientHome.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PatientHome.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), PatientLogin.class));
                finish();

            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), PatientProfile.class));









            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
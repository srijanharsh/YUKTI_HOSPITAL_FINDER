package com.hospital.hospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class News extends AppCompatActivity {

    DocumentReference documentReference;
    DocumentReference documentReference1,documentReference2,documentReference3,documentReference4,documentReference5,documentReference6,documentReference7,documentReference8,
            documentReference9,documentReference10,documentReference11,documentReference12,documentReference13,documentReference14,documentReference15,documentReference16,documentReference17
            ,documentReference18,documentReference19,documentReference20,documentReference21,documentReference22,documentReference23,documentReference24,documentReference25,documentReference26,documentReference27
    ,documentReference28,documentReference29,documentReference30,documentReference31,documentReference32,documentReference33,documentReference34,documentReference35,documentReference36
            ,documentReference37,documentReference38;
    TextView activebr,confirmbr,deceasebr,recoverbr,activein,confirmin,deceasein,recoverin;
    TextView arariaactive,arariarecovered,arariadeceased,arariaconfirmed;
    TextView arwalactive,arwalrecovered,arwaldeceased,arwalconfirmed;
    TextView aurangabadactive,aurangabadrecovered,aurangabaddeceased,aurangabadconfirmed;
    TextView bankaactive,bankarecovered,bankadeceased,bankaconfirmed;
    TextView begusaraiactive,begusarairecovered,begusaraideceased,begusaraiconfirmed;
    TextView bhagalpuractive,bhagalpurrecovered,bhagalpurdeceased,bhagalpurconfirmed;
    TextView bhojpuractive,bhojpurrecovered,bhojpurdeceased,bhojpurconfirmed;
    TextView buxaractive,buxarrecovered,buxardeceased,buxarconfirmed;
    TextView darbhangaactive,darbhangarecovered,darbhangadeceased,darbhangaconfirmed;
    TextView eastchamparanactive,eastchamparanrecovered,eastchamparandeceased,eastchamparanconfirmed;
    TextView gayaactive,gayarecovered,gayadeceased,gayaconfirmed;
    TextView goplaganjactive,goplaganjrecovered,goplaganjdeceased,goplaganjconfirmed;
    TextView jamuiactive,jamuirecovered,jamuideceased,jamuiconfirmed;
    TextView jehanabadactive,jehanabadrecovered,jehanabaddeceased,jehanabadconfirmed;
    TextView kaimuractive,kaimurrecovered,kaimurdeceased,kaimurconfirmed;
    TextView katiharactive,katiharrecovered,katihardeceased,katiharconfirmed;
    TextView khagariaactive,khagariarecovered,khagariadeceased,khagariaconfirmed;
    TextView kishanganjactive,kishanganjrecovered,kishanganjdeceased,kishanganjconfirmed;
    TextView lakhisaraiactive,lakhisarairecovered,lakhisaraideceased,lakhisaraiconfirmed;
    TextView madhepuraactive,madhepurarecovered,madhepuradeceased,madhepuraconfirmed;
    TextView madhubaniactive,madhubanirecovered,madhubanideceased,madhubaniconfirmed;
    TextView mungeractive,mungerrecovered,mungerdeceased,mungerconfirmed;
    TextView muzaffarpuractive,muzaffarpurrecovered,muzaffarpurdeceased,muzaffarpurconfirmed;
    TextView nalandaactive,nalandarecovered,nalandadeceased,nalandaconfirmed;
    TextView nawadaactive,nawadarecovered,nawadadeceased,nawadaconfirmed;
    TextView patnaactive,patnarecovered,patnadeceased,patnaconfirmed;
    TextView purneaactive,purnearecovered,purneadeceased,purneaconfirmed;
    TextView rohtasactive,rohtasrecovered,rohtasdeceased,rohtasconfirmed;
    TextView saharsaactive,saharsarecovered,saharsadeceased,saharsaconfirmed;
    TextView samastipuractive,samastipurrecovered,samastipurdeceased,samastipurconfirmed;
    TextView saranactive,saranrecovered,sarandeceased,saranconfirmed;
    TextView sheikhpuraactive,sheikhpurarecovered,sheikhpuradeceased,sheikhpuraconfirmed;
    TextView sheoharactive,sheoharrecovered,sheohardeceased,sheoharconfirmed;
    TextView sitamarhiactive,sitamarhirecovered,sitamarhideceased,sitamarhiconfirmed;
    TextView siwanactive,siwanrecovered,siwandeceased,siwanconfirmed;
    TextView supaulactive,supaulrecovered,supauldeceased,supaulconfirmed;
    TextView vaishaliactive,vaishalirecovered,vaishalideceased,vaishaliconfirmed;
    TextView westchamparanactive,westchamparanrecovered,westchamparandeceased,westchamparanconfirmed;







    FirebaseFirestore db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.news);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),PatientHome.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.news:
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

        //database code
        activebr = (TextView)findViewById(R.id.activevalue);
        activein = (TextView)findViewById(R.id.activevalueindia);
        confirmbr = (TextView)findViewById(R.id.confirmedvalue);
        confirmin = (TextView)findViewById(R.id.confirmedvalueindia);
        deceasebr = (TextView)findViewById(R.id.deceasedvalue);
        deceasein = (TextView)findViewById(R.id.deceasedvalueindia);
        recoverbr = (TextView)findViewById(R.id.recoveredvalue);
        recoverin = (TextView)findViewById(R.id.recoveredvalueindia);
        db = FirebaseFirestore.getInstance();

        documentReference= db.collection("Covid_Updates").document("Updates");


        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String activebr1 = documentSnapshot.getString("Active_Bihar");
                            String activein1 = documentSnapshot.getString("Active_India");
                            String recoverbr1 = documentSnapshot.getString("Recovered_Bihar");
                            String recoverin1 = documentSnapshot.getString("Recovered_India");
                            String confirmbr1 = documentSnapshot.getString("Confirm_BIhar");
                            String confirmin1 = documentSnapshot.getString("Confirm_India");
                            String deceasebr1 = documentSnapshot.getString("Deceased_Bihar");
                            String deceasein1 = documentSnapshot.getString("Deceased_India");

                            activebr.setText(activebr1);
                            activein.setText(activein1);
                            confirmbr.setText(confirmbr1);
                            confirmin.setText(confirmin1);
                            recoverbr.setText(recoverbr1);
                            recoverin.setText(recoverin1);
                            deceasebr.setText(deceasebr1);
                            deceasein.setText(deceasein1);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        //ARARIA


        arariaactive = (TextView)findViewById(R.id.arariaactive);
        arariaconfirmed = (TextView)findViewById(R.id.arariaconfirmed);
        arariadeceased = (TextView)findViewById(R.id.arariadeceased);
        arariarecovered = (TextView)findViewById(R.id.arariarecovered);

        documentReference1= db.collection("Covid_Updates").document("Araria");



        documentReference1.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String arariaactive1 = documentSnapshot.getString("arariaactive");
                            String arariaconfirmed1 = documentSnapshot.getString("arariaconfirmed");
                            String arariadeceased1 = documentSnapshot.getString("arariadeceased");
                            String arariarecovered1= documentSnapshot.getString("arariarecovered");

                            arariaactive.setText(arariaactive1);
                            arariaconfirmed.setText(arariaconfirmed1);
                            arariadeceased.setText(arariadeceased1);
                            arariarecovered.setText(arariarecovered1);

                        }

                    }
                });


        arwalactive = (TextView)findViewById(R.id.arwalactive);
        arwalconfirmed = (TextView)findViewById(R.id.arwalconfirmed);
        arwaldeceased = (TextView)findViewById(R.id.arwaldeceased);
        arwalrecovered = (TextView)findViewById(R.id.arwalrecovered);


        documentReference2= db.collection("Covid_Updates").document("Arwal");



        documentReference2.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String arwalactive1 = documentSnapshot.getString("arwalactive");
                            String arwalconfirmed1 = documentSnapshot.getString("arwalconfirmed");
                            String arwaldeceased1 = documentSnapshot.getString("arwaldeceased");
                            String arwalrecovered1= documentSnapshot.getString("arwalrecovered");

                            arwalactive.setText(arwalactive1);
                            arwalconfirmed.setText(arwalconfirmed1);
                            arwaldeceased.setText(arwaldeceased1);
                            arwalrecovered.setText(arwalrecovered1);

                        }

                    }
                });


        aurangabadactive = (TextView)findViewById(R.id.aurangabadactive);
        aurangabadconfirmed = (TextView)findViewById(R.id.aurangabadconfirmed);
        aurangabaddeceased = (TextView)findViewById(R.id.aurangabaddeceased);
        aurangabadrecovered = (TextView)findViewById(R.id.aurangabadrecovered);


        documentReference3= db.collection("Covid_Updates").document("Aurangabad");



        documentReference3.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String aurangabadactive1 = documentSnapshot.getString("aurangabadactive");
                            String aurangabadconfirmed1 = documentSnapshot.getString("aurangabadconfirmed");
                            String aurangabaddeceased1 = documentSnapshot.getString("aurangabaddeceased");
                            String aurangabadrecovered1= documentSnapshot.getString("aurangabadrecovered");

                            aurangabadactive.setText(aurangabadactive1);
                            aurangabadconfirmed.setText(aurangabadconfirmed1);
                            aurangabaddeceased.setText(aurangabaddeceased1);
                            aurangabadrecovered.setText(aurangabadrecovered1);

                        }

                    }
                });

        bankaactive = (TextView)findViewById(R.id.bankaactive);
        bankaconfirmed = (TextView)findViewById(R.id.bankaconfirmed);
        bankadeceased = (TextView)findViewById(R.id.bankadeceased);
        bankarecovered = (TextView)findViewById(R.id.bankarecovered);


        documentReference4= db.collection("Covid_Updates").document("Banka");



        documentReference4.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String bankaactive1 = documentSnapshot.getString("bankaactive");
                            String bankaconfirmed1 = documentSnapshot.getString("bankaconfirmed");
                            String bankadeceased1 = documentSnapshot.getString("bankadeceased");
                            String bankarecovered1= documentSnapshot.getString("bankarecovered");

                            bankaactive.setText(bankaactive1);
                            bankaconfirmed.setText(bankaconfirmed1);
                            bankadeceased.setText(bankadeceased1);
                            bankarecovered.setText(bankarecovered1);

                        }

                    }
                });

        begusaraiactive = (TextView)findViewById(R.id.begusaraiactive);
        begusaraiconfirmed = (TextView)findViewById(R.id.begusaraiconfirmed);
        begusaraideceased = (TextView)findViewById(R.id.begusaraideceased);
        begusarairecovered = (TextView)findViewById(R.id.begusarairecovered);


        documentReference5= db.collection("Covid_Updates").document("Begusarai");



        documentReference5.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String begusaraiactive1 = documentSnapshot.getString("begusaraiactive");
                            String begusaraiconfirmed1= documentSnapshot.getString("begusaraiconfirmed");
                            String begusaraideceased1 = documentSnapshot.getString("begusaraideceased");
                            String begusarairecovered1= documentSnapshot.getString("begusarairecovered");

                            begusaraiactive.setText(begusaraiactive1);
                            begusaraiconfirmed.setText(begusaraiconfirmed1);
                            begusaraideceased.setText(begusaraideceased1);
                            begusarairecovered.setText(begusarairecovered1);

                        }

                    }
                });

        bhagalpuractive = (TextView)findViewById(R.id.bhagalpuractive);
        bhagalpurconfirmed = (TextView)findViewById(R.id.bhagalpurconfirmed);
        bhagalpurdeceased = (TextView)findViewById(R.id.bhagalpurdeceased);
        bhagalpurrecovered = (TextView)findViewById(R.id.bhagalpurrecovered);


        documentReference6= db.collection("Covid_Updates").document("Bhagalpur");



        documentReference6.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String bhagalpuractive1 = documentSnapshot.getString("bhagalpuractive");
                            String bhagalpurconfirmed1 = documentSnapshot.getString("bhagalpurconfirmed");
                            String bhagalpurdeceased1 = documentSnapshot.getString("bhagalpurdeceased");
                            String bhagalpurrecovered1= documentSnapshot.getString("bhagalpurrecovered");

                            bhagalpuractive.setText(bhagalpuractive1);
                            bhagalpurconfirmed.setText(bhagalpurconfirmed1);
                            bhagalpurdeceased.setText(bhagalpurdeceased1);
                            bhagalpurrecovered.setText(bhagalpurrecovered1);

                        }

                    }
                });

        bhojpuractive = (TextView)findViewById(R.id.bhojpuractive);
        bhojpurconfirmed = (TextView)findViewById(R.id.bhojpurconfirmed);
        bhojpurdeceased = (TextView)findViewById(R.id.bhojpurdeceased);
        bhojpurrecovered = (TextView)findViewById(R.id.bhojpurrecovered);


        documentReference7= db.collection("Covid_Updates").document("Bhojpur");



        documentReference7.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String bhojpuractive1 = documentSnapshot.getString("bhojpuractive");
                            String bhojpurconfirmed1 = documentSnapshot.getString("bhojpurconfirmed");
                            String bhojpurdeceased1 = documentSnapshot.getString("bhojpurdeceased");
                            String bhojpurrecovered1= documentSnapshot.getString("bhojpurrecovered");

                            bhojpuractive.setText(bhojpuractive1);
                            bhojpurconfirmed.setText(bhojpurconfirmed1);
                            bhojpurdeceased.setText(bhojpurdeceased1);
                            bhojpurrecovered.setText(bhojpurrecovered1);

                        }

                    }
                });

        buxaractive = (TextView)findViewById(R.id.buxaractive);
        buxarconfirmed = (TextView)findViewById(R.id.buxarconfirmed);
        buxardeceased = (TextView)findViewById(R.id.buxardeceased);
        buxarrecovered = (TextView)findViewById(R.id.buxarrecovered);


        documentReference8= db.collection("Covid_Updates").document("Buxar");



        documentReference8.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String buxaractive1 = documentSnapshot.getString("buxaractive");
                            String buxarconfirmed1 = documentSnapshot.getString("buxarconfirmed");
                            String buxardeceased1 = documentSnapshot.getString("buxardeceased");
                            String buxarrecovered1= documentSnapshot.getString("buxarrecovered");

                            buxaractive.setText(buxaractive1);
                            buxarconfirmed.setText(buxarconfirmed1);
                            buxardeceased.setText(buxardeceased1);
                            buxarrecovered.setText(buxarrecovered1);

                        }

                    }
                });

        darbhangaactive = (TextView)findViewById(R.id.darbhangaactive);
        darbhangaconfirmed = (TextView)findViewById(R.id.darbhangaconfirmed);
        darbhangadeceased = (TextView)findViewById(R.id.darbhangadeceased);
        darbhangarecovered = (TextView)findViewById(R.id.darbhangarecovered);


        documentReference9= db.collection("Covid_Updates").document("Darbhanga");



        documentReference9.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String darbhangaactive1 = documentSnapshot.getString("darbhangaactive");
                            String darbhangaconfirmed1 = documentSnapshot.getString("darbhangaconfirmed");
                            String darbhangadeceased1 = documentSnapshot.getString("darbhangadeceased");
                            String darbhangarecovered1= documentSnapshot.getString("darbhangarecovered");

                            darbhangaactive.setText(darbhangaactive1);
                            darbhangaconfirmed.setText(darbhangaconfirmed1);
                            darbhangadeceased.setText(darbhangadeceased1);
                            darbhangarecovered.setText(darbhangarecovered1);

                        }

                    }
                });

        eastchamparanactive = (TextView)findViewById(R.id.eastchamparanactive);
        eastchamparanconfirmed = (TextView)findViewById(R.id.eastchamparanconfirmed);
        eastchamparandeceased = (TextView)findViewById(R.id.eastchamparandeceased);
        eastchamparanrecovered = (TextView)findViewById(R.id.eastchamparanrecovered);



        documentReference10= db.collection("Covid_Updates").document("East_Champaran");



        documentReference10.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String eastchamparanactive1 = documentSnapshot.getString("eastchamparanactive");
                            String eastchamparanconfirmed1 = documentSnapshot.getString("eastchamparanconfirmed");
                            String eastchamparandeceased1 = documentSnapshot.getString("eastchamparandeceased");
                            String eastchamparanrecovered1= documentSnapshot.getString("eastchamparanrecovered");

                            eastchamparanactive.setText(eastchamparanactive1);
                            eastchamparanconfirmed.setText(eastchamparanconfirmed1);
                            eastchamparandeceased.setText(eastchamparandeceased1);
                            eastchamparanrecovered.setText(eastchamparanrecovered1);

                        }

                    }
                });
        gayaactive = (TextView)findViewById(R.id.gayaactive);
        gayaconfirmed = (TextView)findViewById(R.id.gayaconfirmed);
        gayadeceased = (TextView)findViewById(R.id.gayadeceased);
        gayarecovered = (TextView)findViewById(R.id.gayarecovered);


        documentReference11= db.collection("Covid_Updates").document("Gaya");



        documentReference11.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String gayaactive1 = documentSnapshot.getString("gayaactive");
                            String gayaconfirmed1 = documentSnapshot.getString("gayaconfirmed");
                            String gayadeceased1= documentSnapshot.getString("gayadeceased");
                            String gayarecovered1= documentSnapshot.getString("gayarecovered");

                            gayaactive.setText(gayaactive1);
                            gayaconfirmed.setText(gayaconfirmed1);
                            gayadeceased.setText(gayadeceased1);
                            gayarecovered.setText(gayarecovered1);

                        }

                    }
                });

        goplaganjactive = (TextView)findViewById(R.id.goplaganjactive);
        goplaganjconfirmed = (TextView)findViewById(R.id.goplaganjconfirmed);
        goplaganjdeceased = (TextView)findViewById(R.id.goplaganjdeceased);
        goplaganjrecovered = (TextView)findViewById(R.id.goplaganjrecovered);



        documentReference12= db.collection("Covid_Updates").document("Gopalganj");



        documentReference12.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String goplaganjactive1 = documentSnapshot.getString("goplaganjactive");
                            String goplaganjconfirmed1 = documentSnapshot.getString("goplaganjconfirmed");
                            String goplaganjdeceased1 = documentSnapshot.getString("goplaganjdeceased");
                            String goplaganjrecovered1= documentSnapshot.getString("goplaganjrecovered");

                            goplaganjactive.setText(goplaganjactive1);
                            goplaganjconfirmed.setText(goplaganjconfirmed1);
                            goplaganjdeceased.setText(goplaganjdeceased1);
                            goplaganjrecovered.setText(goplaganjrecovered1);

                        }

                    }
                });
        jamuiactive = (TextView)findViewById(R.id.jamuiactive);
        jamuiconfirmed = (TextView)findViewById(R.id.jamuiconfirmed);
        jamuideceased = (TextView)findViewById(R.id.jamuideceased);
        jamuirecovered = (TextView)findViewById(R.id.jamuirecovered);


        documentReference13= db.collection("Covid_Updates").document("Jamui");



        documentReference13.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String jamuiactive1 = documentSnapshot.getString("jamuiactive");
                            String jamuiconfirmed1 = documentSnapshot.getString("jamuiconfirmed");
                            String jamuideceased1 = documentSnapshot.getString("jamuideceased");
                            String jamuirecovered1= documentSnapshot.getString("jamuirecovered");

                            jamuiactive.setText(jamuiactive1);
                            jamuiconfirmed.setText(jamuiconfirmed1);
                            jamuideceased.setText(jamuideceased1);
                            jamuirecovered.setText(jamuirecovered1);

                        }

                    }
                });

        jehanabadactive = (TextView)findViewById(R.id.jehanabadactive);
        jehanabadconfirmed = (TextView)findViewById(R.id.jehanabadconfirmed);
        jehanabaddeceased = (TextView)findViewById(R.id.jehanabaddeceased);
        jehanabadrecovered = (TextView)findViewById(R.id.jehanabadrecovered);


        documentReference14= db.collection("Covid_Updates").document("Jehanabad");



        documentReference14.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String jehanabadactive1 = documentSnapshot.getString("jehanabadactive");
                            String jehanabadconfirmed1 = documentSnapshot.getString("jehanabadconfirmed");
                            String jehanabaddeceased1 = documentSnapshot.getString("jehanabaddeceased");
                            String jehanabadrecovered1= documentSnapshot.getString("jehanabadrecovered");

                            jehanabadactive.setText(jehanabadactive1);
                            jehanabadconfirmed.setText(jehanabadconfirmed1);
                            jehanabaddeceased.setText(jehanabaddeceased1);
                            jehanabadrecovered.setText(jehanabadrecovered1);

                        }

                    }
                });

        kaimuractive = (TextView)findViewById(R.id.kaimuractive);
        kaimurconfirmed = (TextView)findViewById(R.id.kaimurconfirmed);
        kaimurdeceased = (TextView)findViewById(R.id.kaimurdeceased);
        kaimurrecovered = (TextView)findViewById(R.id.kaimurrecovered);


        documentReference15= db.collection("Covid_Updates").document("Kaimur");



        documentReference15.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String kaimuractive1 = documentSnapshot.getString("kaimuractive");
                            String kaimurconfirmed1= documentSnapshot.getString("kaimurconfirmed");
                            String kaimurdeceased1 = documentSnapshot.getString("kaimurdeceased");
                            String kaimurrecovered1= documentSnapshot.getString("kaimurrecovered");

                            kaimuractive.setText(kaimuractive1);
                            kaimurconfirmed.setText(kaimurconfirmed1);
                            kaimurdeceased.setText(kaimurdeceased1);
                            kaimurrecovered.setText(kaimurrecovered1);

                        }

                    }
                });

        katiharactive = (TextView)findViewById(R.id.katiharactive);
        katiharconfirmed = (TextView)findViewById(R.id.katiharconfirmed);
        katihardeceased = (TextView)findViewById(R.id.katihardeceased);
        katiharrecovered = (TextView)findViewById(R.id.katiharrecovered);


        documentReference16= db.collection("Covid_Updates").document("Katihar");



        documentReference16.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String katiharactive1 = documentSnapshot.getString("katiharactive");
                            String katiharconfirmed1 = documentSnapshot.getString("katiharconfirmed");
                            String katihardeceased1= documentSnapshot.getString("katihardeceased");
                            String katiharrecovered1= documentSnapshot.getString("katiharrecovered");

                            katiharactive.setText(katiharactive1);
                            katiharconfirmed.setText(katiharconfirmed1);
                            katihardeceased.setText(katihardeceased1);
                            katiharrecovered.setText(katiharrecovered1);

                        }

                    }
                });

        khagariaactive = (TextView)findViewById(R.id.khagariaactive);
        khagariaconfirmed = (TextView)findViewById(R.id.khagariaconfirmed);
        khagariadeceased = (TextView)findViewById(R.id.khagariadeceased);
        khagariarecovered = (TextView)findViewById(R.id.khagariarecovered);


        documentReference17= db.collection("Covid_Updates").document("Khagaria");



        documentReference17.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String khagariaactive1 = documentSnapshot.getString("khagariaactive");
                            String khagariaconfirmed1 = documentSnapshot.getString("khagariaconfirmed");
                            String khagariadeceased1 = documentSnapshot.getString("khagariadeceased");
                            String khagariarecovered1= documentSnapshot.getString("khagariarecovered");

                            khagariaactive.setText(khagariaactive1);
                            khagariaconfirmed.setText(khagariaconfirmed1);
                            khagariadeceased.setText(khagariadeceased1);
                            khagariarecovered.setText(khagariarecovered1);

                        }

                    }
                });

        kishanganjactive = (TextView)findViewById(R.id.Kishanganjactive);
        kishanganjconfirmed = (TextView)findViewById(R.id.Kishanganjconfirmed);
        kishanganjdeceased = (TextView)findViewById(R.id.Kishanganjdeceased);
        kishanganjrecovered = (TextView)findViewById(R.id.Kishanganjrecovered);


        documentReference18= db.collection("Covid_Updates").document("Kishanganj");



        documentReference18.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String kishanganjactive1 = documentSnapshot.getString("kishanganjactive");
                            String kishanganjconfirmed1 = documentSnapshot.getString("kishanganjconfirmed");
                            String kishanganjdeceased1 = documentSnapshot.getString("kishanganjdeceased");
                            String kishanganjrecovered1= documentSnapshot.getString("kishanganjrecovered");

                            kishanganjactive.setText(kishanganjactive1);
                            kishanganjconfirmed.setText(kishanganjconfirmed1);
                            kishanganjdeceased.setText(kishanganjdeceased1);
                            kishanganjrecovered.setText(kishanganjrecovered1);

                        }

                    }
                });

        lakhisaraiactive = (TextView)findViewById(R.id.lakhisaraiactive);
        lakhisaraiconfirmed = (TextView)findViewById(R.id.lakhisaraiconfirmed);
        lakhisaraideceased = (TextView)findViewById(R.id.lakhisaraideceased);
        lakhisarairecovered = (TextView)findViewById(R.id.lakhisarairecovered);


        documentReference19= db.collection("Covid_Updates").document("Lakhisarai");



        documentReference19.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String lakhisaraiactive1 = documentSnapshot.getString("lakhisaraiactive");
                            String lakhisaraiconfirmed1 = documentSnapshot.getString("lakhisaraiconfirmed");
                            String lakhisaraideceased1 = documentSnapshot.getString("lakhisaraideceased");
                            String lakhisarairecovered1= documentSnapshot.getString("lakhisarairecovered");

                            lakhisaraiactive.setText(lakhisaraiactive1);
                            lakhisaraiconfirmed.setText(lakhisaraiconfirmed1);
                            lakhisaraideceased.setText(lakhisaraideceased1);
                            lakhisarairecovered.setText(lakhisarairecovered1);

                        }

                    }
                });


        madhepuraactive = (TextView)findViewById(R.id.madhepuraactive);
        madhepuraconfirmed = (TextView)findViewById(R.id.madhepuraconfirmed);
        madhepuradeceased = (TextView)findViewById(R.id.madhepuradeceased);
        madhepurarecovered = (TextView)findViewById(R.id.madhepurarecovered);


        documentReference20= db.collection("Covid_Updates").document("Madhepura");



        documentReference20.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String madhepuraactive1 = documentSnapshot.getString("madhepuraactive");
                            String madhepuraconfirmed1 = documentSnapshot.getString("madhepuraconfirmed");
                            String madhepuradeceased1 = documentSnapshot.getString("madhepuradeceased");
                            String madhepurarecovered1= documentSnapshot.getString("madhepurarecovered");

                            madhepuraactive.setText(madhepuraactive1);
                            madhepuraconfirmed.setText(madhepuraconfirmed1);
                            madhepuradeceased.setText(madhepuradeceased1);
                            madhepurarecovered.setText(madhepurarecovered1);

                        }

                    }
                });
        madhubaniactive = (TextView)findViewById(R.id.madhubaniactive);
        madhubaniconfirmed = (TextView)findViewById(R.id.madhubaniconfirmed);
        madhubanideceased = (TextView)findViewById(R.id.madhubanideceased);
        madhubanirecovered = (TextView)findViewById(R.id.madhubanirecovered);



        documentReference21= db.collection("Covid_Updates").document("Madhubani");



        documentReference21.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String madhubaniactive1 = documentSnapshot.getString("madhubaniactive");
                            String madhubaniconfirmed1 = documentSnapshot.getString("madhubaniconfirmed");
                            String madhubanideceased1 = documentSnapshot.getString("madhubanideceased");
                            String madhubanirecovered1= documentSnapshot.getString("madhubanirecovered");

                            madhubaniactive.setText(madhubaniactive1);
                            madhubaniconfirmed.setText(madhubaniconfirmed1);
                            madhubanideceased.setText(madhubanideceased1);
                            madhubanirecovered.setText(madhubanirecovered1);

                        }

                    }
                });
        mungeractive = (TextView)findViewById(R.id.mungeractive);
        mungerconfirmed = (TextView)findViewById(R.id.mungerconfirmed);
        mungerdeceased = (TextView)findViewById(R.id.mungerdeceased);
        mungerrecovered = (TextView)findViewById(R.id.mungerrecovered);


        documentReference22= db.collection("Covid_Updates").document("Munger");



        documentReference22.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String mungeractive1 = documentSnapshot.getString("mungeractive");
                            String mungerconfirmed1 = documentSnapshot.getString("mungerconfirmed");
                            String mungerdeceased1 = documentSnapshot.getString("mungerdeceased");
                            String mungerrecovered1= documentSnapshot.getString("mungerrecovered");

                            mungeractive.setText(mungeractive1);
                            mungerconfirmed.setText(mungerconfirmed1);
                            mungerdeceased.setText(mungerdeceased1);
                            mungerrecovered.setText(mungerrecovered1);

                        }

                    }
                });

        muzaffarpuractive = (TextView)findViewById(R.id.muzaffarpuractive);
        muzaffarpurconfirmed = (TextView)findViewById(R.id.muzaffarpurconfirmed);
        muzaffarpurdeceased = (TextView)findViewById(R.id.muzaffarpurdeceased);
        muzaffarpurrecovered = (TextView)findViewById(R.id.muzaffarpurrecovered);



        documentReference23= db.collection("Covid_Updates").document("Muzaffarpur");



        documentReference23.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String muzaffarpuractive1 = documentSnapshot.getString("muzaffarpuractive");
                            String muzaffarpurconfirmed1 = documentSnapshot.getString("muzaffarpurconfirmed");
                            String muzaffarpurdeceased1 = documentSnapshot.getString("muzaffarpurdeceased");
                            String muzaffarpurrecovered1= documentSnapshot.getString("muzaffarpurrecovered");

                            muzaffarpuractive.setText(muzaffarpuractive1);
                            muzaffarpurconfirmed.setText(muzaffarpurconfirmed1);
                            muzaffarpurdeceased.setText(muzaffarpurdeceased1);
                            muzaffarpurrecovered.setText(muzaffarpurrecovered1);

                        }

                    }
                });
        nalandaactive = (TextView)findViewById(R.id.nalandaactive);
        nalandaconfirmed = (TextView)findViewById(R.id.nalandaconfirmed);
        nalandadeceased = (TextView)findViewById(R.id.nalandadeceased);
        nalandarecovered = (TextView)findViewById(R.id.nalandarecovered);



        documentReference24= db.collection("Covid_Updates").document("Nalanda");



        documentReference24.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String nalandaactive1 = documentSnapshot.getString("nalandaactive");
                            String nalandaconfirmed1 = documentSnapshot.getString("nalandaconfirmed");
                            String nalandadeceased1 = documentSnapshot.getString("nalandadeceased");
                            String nalandarecovered1= documentSnapshot.getString("nalandarecovered");

                            nalandaactive.setText(nalandaactive1);
                            nalandaconfirmed.setText(nalandaconfirmed1);
                            nalandadeceased.setText(nalandadeceased1);
                            nalandarecovered.setText(nalandarecovered1);

                        }

                    }
                });
        nawadaactive = (TextView)findViewById(R.id.nawadaactive);
        nawadaconfirmed = (TextView)findViewById(R.id.nawadaconfirmed);
        nawadadeceased = (TextView)findViewById(R.id.nawadadeceased);
        nawadarecovered = (TextView)findViewById(R.id.nawadarecovered);


        documentReference25= db.collection("Covid_Updates").document("Nawada");



        documentReference25.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String nawadaactive1 = documentSnapshot.getString("nawadaactive");
                            String nawadaconfirmed1 = documentSnapshot.getString("nawadaconfirmed");
                            String nawadadeceased1 = documentSnapshot.getString("nawadadeceased");
                            String nawadarecovered1= documentSnapshot.getString("nawadarecovered");

                            nawadaactive.setText(nawadaactive1);
                            nawadaconfirmed.setText(nawadaconfirmed1);
                            nawadadeceased.setText(nawadadeceased1);
                            nawadarecovered.setText(nawadarecovered1
                            );

                        }

                    }
                });

        patnaactive = (TextView)findViewById(R.id.patnaactive);
        patnaconfirmed = (TextView)findViewById(R.id.patnaconfirmed);
        patnadeceased = (TextView)findViewById(R.id.patnadeceased);
        patnarecovered = (TextView)findViewById(R.id.patnarecovered);



        documentReference26= db.collection("Covid_Updates").document("Patna");



        documentReference26.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String patnaactive1 = documentSnapshot.getString("patnaactive");
                            String patnaconfirmed1 = documentSnapshot.getString("patnaconfirmed");
                            String patnadeceased1 = documentSnapshot.getString("patnadeceased");
                            String patnarecovered1= documentSnapshot.getString("patnarecovered");

                            patnaactive.setText(patnaactive1);
                            patnaconfirmed.setText(patnaconfirmed1);
                            patnadeceased.setText(patnadeceased1);
                            patnarecovered.setText(patnarecovered1);

                        }

                    }
                });
        purneaactive = (TextView)findViewById(R.id.purneaactive);
        purneaconfirmed = (TextView)findViewById(R.id.purneaconfirmed);
        purneadeceased = (TextView)findViewById(R.id.purneadeceased);
        purnearecovered = (TextView)findViewById(R.id.purnearecovered);


        documentReference27= db.collection("Covid_Updates").document("Purnea");



        documentReference27.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String purneaactive1 = documentSnapshot.getString("purneaactive");
                            String purneaconfirmed1 = documentSnapshot.getString("purneaconfirmed");
                            String purneadeceased1 = documentSnapshot.getString("purneadeceased");
                            String purnearecovered1= documentSnapshot.getString("purnearecovered");

                            purneaactive.setText(purneaactive1);
                            purneaconfirmed.setText(purneaconfirmed1);
                            purneadeceased.setText(purneadeceased1);
                            purnearecovered.setText(purnearecovered1);

                        }

                    }
                });

        rohtasactive = (TextView)findViewById(R.id.rohtasactive);
        rohtasconfirmed = (TextView)findViewById(R.id.rohtasconfirmed);
        rohtasdeceased = (TextView)findViewById(R.id.rohtasdeceased);
        rohtasrecovered = (TextView)findViewById(R.id.rohtasrecovered);

        documentReference28= db.collection("Covid_Updates").document("Rohtas");



        documentReference28.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String rohtasactive1 = documentSnapshot.getString("rohtasactive");
                            String rohtasconfirmed1 = documentSnapshot.getString("rohtasconfirmed");
                            String rohtasdeceased1 = documentSnapshot.getString("rohtasdeceased");
                            String rohtasrecovered1= documentSnapshot.getString("rohtasrecovered");

                            rohtasactive.setText(rohtasactive1);
                            rohtasconfirmed.setText(rohtasconfirmed1);
                            rohtasdeceased.setText(rohtasdeceased1);
                            rohtasrecovered.setText(rohtasrecovered1);

                        }

                    }
                });

        saharsaactive = (TextView)findViewById(R.id.saharsaactive);
        saharsaconfirmed = (TextView)findViewById(R.id.saharsaconfirmed);
        saharsadeceased = (TextView)findViewById(R.id.saharsadeceased);
        saharsarecovered = (TextView)findViewById(R.id.saharsarecovered);

        documentReference29= db.collection("Covid_Updates").document("Saharsa");



        documentReference29.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String saharsaactive1 = documentSnapshot.getString("saharsaactive");
                            String saharsaconfirmed1 = documentSnapshot.getString("saharsaconfirmed");
                            String saharsadeceased1 = documentSnapshot.getString("saharsadeceased");
                            String saharsarecovered1= documentSnapshot.getString("saharsarecovered");

                            saharsaactive.setText(saharsaactive1);
                            saharsaconfirmed.setText(saharsaconfirmed1);
                            saharsadeceased.setText(saharsadeceased1);
                            saharsarecovered.setText(saharsarecovered1);

                        }

                    }
                });

        samastipuractive = (TextView)findViewById(R.id.samastipuractive);
        samastipurconfirmed = (TextView)findViewById(R.id.samastipurconfirmed);
        samastipurdeceased = (TextView)findViewById(R.id.samastipurdeceased);
        samastipurrecovered = (TextView)findViewById(R.id.samastipurrecovered);


        documentReference30= db.collection("Covid_Updates").document("Samastipur");



        documentReference30.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String samastipuractive1 = documentSnapshot.getString("samastipuractive");
                            String samastipurconfirmed1 = documentSnapshot.getString("samastipurconfirmed");
                            String samastipurdeceased1 = documentSnapshot.getString("samastipurdeceased");
                            String samastipurrecovered1= documentSnapshot.getString("samastipurrecovered");

                            samastipuractive.setText(samastipuractive1);
                            samastipurconfirmed.setText(samastipurconfirmed1);
                            samastipurdeceased.setText(samastipurdeceased1);
                            samastipurrecovered.setText(samastipurrecovered1);

                        }

                    }
                });

        saranactive = (TextView)findViewById(R.id.saranactive);
        saranconfirmed = (TextView)findViewById(R.id.saranconfirmed);
        sarandeceased = (TextView)findViewById(R.id.sarandeceased);
        saranrecovered = (TextView)findViewById(R.id.saranrecovered);

        documentReference31= db.collection("Covid_Updates").document("Saran");



        documentReference31.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String saranactive1 = documentSnapshot.getString("saranactive");
                            String saranconfirmed1 = documentSnapshot.getString("saranconfirmed");
                            String sarandeceased1 = documentSnapshot.getString("sarandeceased");
                            String saranrecovered1= documentSnapshot.getString("saranrecovered");

                            saranactive.setText(saranactive1);
                            saranconfirmed.setText(saranconfirmed1);
                            sarandeceased.setText(sarandeceased1);
                            saranrecovered.setText(saranrecovered1);

                        }

                    }
                });

        sheikhpuraactive = (TextView)findViewById(R.id.sheikhpuraactive);
        sheikhpuraconfirmed = (TextView)findViewById(R.id.sheikhpuraconfirmed);
        sheikhpuradeceased = (TextView)findViewById(R.id.sheikhpuradeceased);
        sheikhpurarecovered = (TextView)findViewById(R.id.sheikhpurarecovered);

        documentReference32= db.collection("Covid_Updates").document("Sheikhpura");



        documentReference32.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String sheikhpuraactive1 = documentSnapshot.getString("sheikhpuraactive");
                            String sheikhpuraconfirmed1 = documentSnapshot.getString("sheikhpuraconfirmed");
                            String sheikhpuradeceased1 = documentSnapshot.getString("sheikhpuradeceased");
                            String sheikhpurarecovered1= documentSnapshot.getString("sheikhpurarecovered");

                            sheikhpuraactive.setText(sheikhpuraactive1);
                            sheikhpuraconfirmed.setText(sheikhpuraconfirmed1);
                            sheikhpuradeceased.setText(sheikhpuradeceased1);
                            sheikhpurarecovered.setText(sheikhpurarecovered1);

                        }

                    }
                });

        sheoharactive = (TextView)findViewById(R.id.sheoharactive);
        sheoharconfirmed = (TextView)findViewById(R.id.sheoharconfirmed);
        sheohardeceased = (TextView)findViewById(R.id.sheohardeceased);
        sheoharrecovered = (TextView)findViewById(R.id.sheoharrecovered);

        documentReference33= db.collection("Covid_Updates").document("Sheohar");



        documentReference33.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String sheoharactive1 = documentSnapshot.getString("sheoharactive");
                            String sheoharconfirmed1 = documentSnapshot.getString("sheoharconfirmed");
                            String sheohardeceased1 = documentSnapshot.getString("sheohardeceased");
                            String sheoharrecovered1= documentSnapshot.getString("sheoharrecovered");

                            sheoharactive.setText(sheoharactive1);
                            sheoharconfirmed.setText(sheoharconfirmed1);
                            sheohardeceased.setText(sheohardeceased1);
                            sheoharrecovered.setText(sheoharrecovered1);

                        }

                    }
                });

        sitamarhiactive = (TextView)findViewById(R.id.sitamarhiactive);
        sitamarhiconfirmed = (TextView)findViewById(R.id.sitamarhiconfirmed);
        sitamarhideceased = (TextView)findViewById(R.id.sitamarhideceased);
        sitamarhirecovered = (TextView)findViewById(R.id.sitamarhirecovered);

        documentReference34= db.collection("Covid_Updates").document("Sitamarhi");



        documentReference34.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String sitamarhiactive1 = documentSnapshot.getString("sitamarhiactive");
                            String sitamarhiconfirmed1 = documentSnapshot.getString("sitamarhiconfirmed");
                            String sitamarhideceased1 = documentSnapshot.getString("sitamarhideceased");
                            String sitamarhirecovered1= documentSnapshot.getString("sitamarhirecovered");

                            sitamarhiactive.setText(sitamarhiactive1);
                            sitamarhiconfirmed.setText(sitamarhiconfirmed1);
                            sitamarhideceased.setText(sitamarhideceased1);
                            sitamarhirecovered.setText(sitamarhirecovered1);

                        }

                    }
                });

        siwanactive = (TextView)findViewById(R.id.siwanactive);
        siwanconfirmed = (TextView)findViewById(R.id.siwanconfirmed);
        siwandeceased = (TextView)findViewById(R.id.siwandeceased);
        siwanrecovered = (TextView)findViewById(R.id.siwanrecovered);

        documentReference35= db.collection("Covid_Updates").document("Siwan");



        documentReference35.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String siwanactive1 = documentSnapshot.getString("siwanactive");
                            String siwanconfirmed1 = documentSnapshot.getString("siwanconfirmed");
                            String siwandeceased1 = documentSnapshot.getString("siwandeceased");
                            String siwanrecovered1= documentSnapshot.getString("siwanrecovered");

                            siwanactive.setText(siwanactive1);
                            siwanconfirmed.setText(siwanconfirmed1);
                            siwandeceased.setText(siwandeceased1);
                            siwanrecovered.setText(siwanrecovered1);

                        }

                    }
                });

        supaulactive = (TextView)findViewById(R.id.supaulactive);
        supaulconfirmed = (TextView)findViewById(R.id.supaulconfirmed);
        supauldeceased = (TextView)findViewById(R.id.supauldeceased);
        supaulrecovered = (TextView)findViewById(R.id.supaulrecovered);

        documentReference36= db.collection("Covid_Updates").document("Supaul");



        documentReference36.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String supaulactive1 = documentSnapshot.getString("supaulactive");
                            String supaulconfirmed1 = documentSnapshot.getString("supaulconfirmed");
                            String supauldeceased1 = documentSnapshot.getString("supauldeceased");
                            String supaulrecovered1 = documentSnapshot.getString("supaulrecovered");

                            supaulactive.setText(supaulactive1);
                            supaulconfirmed.setText(supaulconfirmed1);
                            supauldeceased.setText(supauldeceased1);
                            supaulrecovered.setText(supaulrecovered1);

                        }

                    }
                });

        vaishaliactive = (TextView)findViewById(R.id.vaishaliactive);
        vaishaliconfirmed = (TextView)findViewById(R.id.vaishaliconfirmed);
        vaishalideceased = (TextView)findViewById(R.id.vaishalideceased);
        vaishalirecovered = (TextView)findViewById(R.id.vaishalirecovered);

        documentReference37= db.collection("Covid_Updates").document("Vaishali");



        documentReference37.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String vaishaliactive1 = documentSnapshot.getString("vaishaliactive");
                            String vaishaliconfirmed1 = documentSnapshot.getString("vaishaliconfirmed");
                            String vaishalideceased1 = documentSnapshot.getString("vaishalideceased");
                            String vaishalirecovered1= documentSnapshot.getString("vaishalirecovered");

                            vaishaliactive.setText(vaishaliactive1);
                            vaishaliconfirmed.setText(vaishaliconfirmed1);
                            vaishalideceased.setText(vaishalideceased1);
                            vaishalirecovered.setText(vaishalirecovered1);

                        }

                    }
                });

        westchamparanactive = (TextView)findViewById(R.id.westchamparanactive);
        westchamparanconfirmed = (TextView)findViewById(R.id.westchamparanconfirmed);
        westchamparandeceased = (TextView)findViewById(R.id.westchamparandeceased);
        westchamparanrecovered = (TextView)findViewById(R.id.westchamparanrecovered);

        documentReference38= db.collection("Covid_Updates").document("West_Champaran");



        documentReference38.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                            String westchamparanactive1 = documentSnapshot.getString("westchamparanactive");
                            String westchamparanconfirmed1 = documentSnapshot.getString("westchamparanconfirmed");
                            String westchamparandeceased1 = documentSnapshot.getString("westchamparandeceased");
                            String westchamparanrecovered1= documentSnapshot.getString("westchamparanrecovered");

                            westchamparanactive.setText(westchamparanactive1);
                            westchamparanconfirmed.setText(westchamparanconfirmed1);
                            westchamparandeceased.setText(westchamparandeceased1);
                            westchamparanrecovered.setText(westchamparanrecovered1);

                        }

                    }
                });







    }
}
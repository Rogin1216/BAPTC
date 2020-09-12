package com.example.baptc.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.baptc.R;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;


    //Get Data Variables
    TextInputLayout idnum, lastname, firstname, email, password;
    Spinner province,municipality,barangay;

    //Array adapter for parent(province)
    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    //Array adapter for child(municipality)
    ArrayList<String> arrayList_abra, arrayList_apayao, arrayList_benguet,arrayList_ifugao;
    ArrayAdapter<String> arrayAdapter_child;

    //Array adapter for subchild(barangay)
    ArrayList<String> arrayList_Bangued,arrayList_Boliney,arrayList_Bucay,arrayList_Bucloc,arrayList_Daguioman; //Abra
    ArrayList<String> arrayList_Calanasan,arrayList_Conner,arrayList_Flora,arrayList_Kabugao,arrayList_Luna; //Apayao
    ArrayList<String> arrayList_Atok,arrayList_Bakun,arrayList_Bokod,arrayList_Buguias,arrayList_Itogon; //Benguet
    ArrayList<String> arrayList_Aguinaldo,arrayList_AlfonsoLista,arrayList_Asipulo,arrayList_Banaue,arrayList_Hingyon; // Ifugao
    ArrayAdapter<String> arrayAdapter_subchild;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //Hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        slideText = findViewById(R.id.signup_slide_text);

        //Hooks for getting data
        idnum = findViewById(R.id.signup_id);
        lastname = findViewById(R.id.signup_lastname);
        firstname = findViewById(R.id.signup_firstname);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        province = findViewById(R.id.signup_province);
        municipality = findViewById(R.id.signup_municipality);
        barangay = findViewById(R.id.signup_barangay);

        //Array parent option
        arrayList_parent=new ArrayList<>();
        arrayList_parent.add("Abra");
        arrayList_parent.add("Apayao");
        arrayList_parent.add("Benguet");
        arrayList_parent.add("Ifugao");

        arrayAdapter_parent=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_parent);
        province.setAdapter(arrayAdapter_parent);

        //List of municipality per Provinces
        arrayList_abra=new ArrayList<>();
        arrayList_abra.add("Bangued");
        arrayList_abra.add("Boliney");
        arrayList_abra.add("Bucay");
        arrayList_abra.add("Bucloc");
        arrayList_abra.add("Daguioman");

        arrayList_apayao=new ArrayList<>();
        arrayList_apayao.add("Calanasan");
        arrayList_apayao.add("Conner");
        arrayList_apayao.add("Flora");
        arrayList_apayao.add("Kabugao");
        arrayList_apayao.add("Luna");

        arrayList_benguet=new ArrayList<>();
        arrayList_benguet.add("Atok");
        arrayList_benguet.add("Bakun");
        arrayList_benguet.add("Bokod");
        arrayList_benguet.add("Buguias");
        arrayList_benguet.add("Itogon");

        arrayList_ifugao=new ArrayList<>();
        arrayList_ifugao.add("Aguinalod");
        arrayList_ifugao.add("Alofonso Lista");
        arrayList_ifugao.add("Asipulo");
        arrayList_ifugao.add("Banaue");
        arrayList_ifugao.add("Hingyon");

        //List of Barangays per Municipality
        //Abra Barangay list
        arrayList_Bangued=new ArrayList<>();
        arrayList_Bangued.add("Agtangao");arrayList_Bangued.add("Angad");arrayList_Bangued.add("Bañacao");arrayList_Bangued.add("Bangbangar");arrayList_Bangued.add("Cabuloan");

        arrayList_Boliney=new ArrayList<>();
        arrayList_Boliney.add("Amti");arrayList_Boliney.add("Bao-yan");arrayList_Boliney.add("Danac East");arrayList_Boliney.add("Dao-angan");arrayList_Boliney.add("Dumugas");

        arrayList_Bucay=new ArrayList<>();
        arrayList_Bucay.add("Abang");arrayList_Bucay.add("Bangbangcag");arrayList_Bucay.add("Banglolao");arrayList_Bucay.add("Bugbog");arrayList_Bucay.add("Calao");

        arrayList_Bucloc=new ArrayList<>();
        arrayList_Bucloc.add("Ducligan");arrayList_Bucloc.add("Labaan");arrayList_Bucloc.add("Lingay");arrayList_Bucloc.add("Lamao");

        arrayList_Daguioman=new ArrayList<>();
        arrayList_Daguioman.add("Ableg");arrayList_Daguioman.add("Cabaruyan");arrayList_Daguioman.add("Pikek");arrayList_Daguioman.add("Tui");

        //Apayao Barangay list
        arrayList_Calanasan=new ArrayList<>();
        arrayList_Calanasan.add("Butao");arrayList_Calanasan.add("Cadaclan");arrayList_Calanasan.add("Langnao");arrayList_Calanasan.add("Lubong");arrayList_Calanasan.add("Naguillaian");

        arrayList_Conner=new ArrayList<>();
        arrayList_Conner.add("Allangigan");arrayList_Conner.add("Buluan");arrayList_Conner.add("Caglayan");arrayList_Conner.add("Calafug");arrayList_Conner.add("Cupis");

        arrayList_Flora=new ArrayList<>();
        arrayList_Flora.add("Allig");arrayList_Flora.add("Anninipan");arrayList_Flora.add("Atok");arrayList_Flora.add("Bagutong");arrayList_Flora.add("Balasi");arrayList_Flora.add("Balluyan");

        arrayList_Kabugao=new ArrayList<>();
        arrayList_Kabugao.add("Badduat");arrayList_Kabugao.add("Baliwanan");arrayList_Kabugao.add("Bulu");arrayList_Kabugao.add("Dagara");arrayList_Kabugao.add("Dibagat");

        arrayList_Luna=new ArrayList<>();
        arrayList_Luna.add("Bacsay");arrayList_Luna.add("Cagapaypayan");arrayList_Luna.add("Dagupan");arrayList_Luna.add("Lappa");arrayList_Luna.add("Marag");

        //Benguet Barangay list
        arrayList_Atok=new ArrayList<>();
        arrayList_Atok.add("Abiang");arrayList_Atok.add("Caliking");arrayList_Atok.add("Cattubo");arrayList_Atok.add("Naguey");arrayList_Atok.add("Paoay");

        arrayList_Bakun=new ArrayList<>();
        arrayList_Bakun.add("Ampusongan");arrayList_Bakun.add("Bagu");arrayList_Bakun.add("Dalipey");arrayList_Bakun.add("Gambang");arrayList_Bakun.add("Kayapa");

        arrayList_Bokod=new ArrayList<>();
        arrayList_Bokod.add("Ambuclao");arrayList_Bokod.add("Bila");arrayList_Bokod.add("Bobok-bisal");arrayList_Bokod.add("Daclan");arrayList_Bokod.add("Ekip");

        arrayList_Buguias=new ArrayList<>();
        arrayList_Buguias.add("Abatan");arrayList_Buguias.add("Amgaleyguey");arrayList_Buguias.add("Amlimay");arrayList_Buguias.add("Baculongan");arrayList_Buguias.add("Bangao");

        arrayList_Itogon=new ArrayList<>();
        arrayList_Itogon.add("Ampucao");arrayList_Itogon.add("Dalupirip");arrayList_Itogon.add("Gumatdang");arrayList_Itogon.add("Loacan");arrayList_Itogon.add("Poblacion");

        //Ifugao Barangay list
        arrayList_ifugao=new ArrayList<>();
        arrayList_ifugao.add("Aguinaldo");arrayList_ifugao.add("Alfonso Lista");arrayList_ifugao.add("Asipulo");arrayList_ifugao.add("Banaue");arrayList_ifugao.add("Hingyon");

        //child(municipality) spinner dependent starts here
        province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_abra);
                    municipality.setAdapter(arrayAdapter_child);
                    municipality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if(i==0){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Bangued);
                            }
                            if(i==1){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Boliney);
                            }
                            if(i==2){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Bucay);
                            }
                            if(i==3){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Bucloc);
                            }
                            if(i==4){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Daguioman);
                            }
                            barangay.setAdapter(arrayAdapter_subchild);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                if(i==1){
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_apayao);
                    municipality.setAdapter(arrayAdapter_child);
                    municipality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if(i==0){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Calanasan);
                            }
                            if(i==1){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Conner);
                            }
                            if(i==2){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Flora);
                            }
                            if(i==3){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Kabugao);
                            }
                            if(i==4){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Luna);
                            }
                            barangay.setAdapter(arrayAdapter_subchild);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                if(i==2){
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_benguet);
                    municipality.setAdapter(arrayAdapter_child);
                    municipality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if(i==0){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Atok);
                            }
                            if(i==1){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Bakun);
                            }
                            if(i==2){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Bokod);
                            }
                            if(i==3){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Buguias);
                            }
                            if(i==4){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Itogon);
                            }
                            barangay.setAdapter(arrayAdapter_subchild);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                if(i==3){
                    arrayAdapter_child=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_ifugao);
                    municipality.setAdapter(arrayAdapter_child);
                    municipality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if(i==0){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Aguinaldo);
                            }
                            if(i==1){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_AlfonsoLista);
                            }
                            if(i==2){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Asipulo);
                            }
                            if(i==3){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Banaue);
                            }
                            if(i==4){
                                arrayAdapter_subchild=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_Hingyon);
                            }
                            barangay.setAdapter(arrayAdapter_subchild);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void callNextSignupScreen(View view) {

        if (!validateLastName() | !validateFirstName() | !validateIDnum() | !validateEmail() | !validatePassword()) {
            return;
        }
        //Get all values
        String _idnum = idnum.getEditText().getText().toString().trim();
        String _lastname = lastname.getEditText().getText().toString().trim();
        String _firstname = firstname.getEditText().getText().toString().trim();
        String _fullname = (_firstname + " " + _lastname);
        String _email = email.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        String _province = province.getSelectedItem().toString().trim();
        String _municipality = municipality.getSelectedItem().toString().trim();
        String _address = (_province + " " + _municipality);

        Intent intent = new Intent(getApplicationContext(), SignUp2nd.class);

        //Pass all fields to the next activity
        intent.putExtra("address", _address);
        intent.putExtra("idnum", _idnum);
        intent.putExtra("fullname", _fullname);
        intent.putExtra("email", _email);
        intent.putExtra("password", _password);

        //Add Shared Animation
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");
        pairs[4] = new Pair<View, String>(slideText, "transition_slide_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    //Validation
    private boolean validateLastName() {
        String val = lastname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            lastname.setError("Field can not be empty");
            return false;
        } else {
            lastname.setError(null);
            lastname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateFirstName() {
        String val = firstname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            firstname.setError("Field can not be empty");
            return false;
        } else {
            firstname.setError(null);
            firstname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateIDnum() {
        String val = idnum.getEditText().getText().toString().trim();
        String checkspaces = "\\d{4}-\\d{4}";
        if (val.isEmpty()) {
            idnum.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkspaces)) {
            idnum.setError("Invalid format!");
            return false;
        } else {
            idnum.setError(null);
            idnum.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 8 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}
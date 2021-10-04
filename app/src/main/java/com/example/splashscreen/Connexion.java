package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Connexion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
    }


    public void BTN_SignInClick(View view) {
        //startActivity(new Intent(Connexion.this, listFiche.class));

        VisiteurSqlHelper visiteurSqlHelper =new VisiteurSqlHelper(Connexion.this);
        EditText login=findViewById(R.id.editTextTextPersonName);
        String lg=login.getText().toString();
        Intent intent= new Intent(Connexion.this, listFiche.class);
        //Visiteur v=visiteurSqlHelper.getVisiteur(lg);
        //intent.putExtra("id", v.getID_VISIT());
        startActivity(intent);

    }
}

package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        TextView txtAccueil=findViewById(R.id.txtAccueil);

        txtAccueil.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque quis sapien nisl. Ut arcu nulla, cursus eu vehicula eu, aliquam eu sapien. Ut ac vulputate felis. Ut convallis, mi sed dignissim euismod, nisl elit aliquam massa, vitae posuere felis velit fringilla urna. Vestibulum molestie est lacus, eget pharetra diam pulvinar sed. Etiam posuere tincidunt turpis a placerat. Ut sed arcu rutrum, auctor lacus ut, blandit lacus. Aenean non eleifend augue. Quisque nec purus orci. Nunc fermentum, tortor at varius finibus, neque elit varius nunc, a iaculis mauris lorem id erat. Nunc molestie nunc sed mi pellentesque dictum. Sed eget dignissim lacus. Pellentesque elit ipsum, pretium nec iaculis nec, porta vitae justo. Vestibulum enim erat, congue vel finibus et, mollis sit amet eros. Donec sed tincidunt leo. ");
    }

    public void BTN_LoginClick(View view) {
        startActivity(new Intent(Dashboard.this, Connexion.class));
    }

}
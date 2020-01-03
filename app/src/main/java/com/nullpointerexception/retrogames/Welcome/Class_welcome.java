package com.nullpointerexception.retrogames.Welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nullpointerexception.retrogames.MainActivity;
import com.nullpointerexception.retrogames.R;

public class Class_welcome extends AppCompatActivity {

    Button next;
    Button login;

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction tx = fm.beginTransaction();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Primo fragment
        Fragment_welcome welcome = new Fragment_welcome();

        tx.add(R.id.fragment , welcome);
        tx.commit();

        //TODO Per Luca
        next = findViewById(R.id.button_welcome);


        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Secondo fragment
                Fragment_first_access first_access = new Fragment_first_access();

                tx.add(R.id.fragment,first_access);
                tx.commit();
            }
        });

        login = findViewById(R.id.button_login_first);

        // Passo ad un'altra activity
        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(Class_welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

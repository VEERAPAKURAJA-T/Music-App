package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
/*
The first step in creating the service is to create a class, a custom service class, and the custom
service class will be created in the same directory where the main activity class resides, and this
class will extend the service class and I'll name it as my custom service.
 */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service =new Intent(getApplicationContext(),My_Custom_Service.class);
                startService(service);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service =new Intent(getApplicationContext(),My_Custom_Service.class);
                stopService(service);
            }
        });
    }

}
/*
HERE THE SOUND WAS NOT PlAY BECAUSE WE NEED TO SPECIFY IN THE MANIFESTS  AndroidManifest.xml
 */
/*
It's played continuously, and if you click on the home and you skip the application, you can see it's
still running and making this sound, playing the audio sound.
 */
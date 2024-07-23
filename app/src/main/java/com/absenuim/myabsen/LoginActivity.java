package com.absenuim.myabsen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainJadwal1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onButtonLoginClicked(View view) {
        //explicit intent
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);  //ini untuk mengabungkan activity login ke activity main
    }

    public void onForegotPasswordClicked(View view) {
        //Implicit intent
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL); //ini untuk melakukan perintah panggilan telpon
        callIntent.setData(Uri.parse("tel: 087863828951")); //ini untuk telponnya
        //if (callIntent.resolveActivity(getPackageManager()) != null) { //ini untuk jika di perangkat tidak ada apk nya
            startActivity(callIntent);
       // } else {
            //Toast.makeText(this, "Aplikasi Tidak Tersedia", Toast.LENGTH_SHORT).show();
        //}
    }
}
package com.example.praktikan.lat_mandiri;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login");

        LayoutInflater inflater = getLayoutInflater();
        View viewLogin = inflater.inflate(R.layout.login,null);
        final EditText etUsername = viewLogin.findViewById(R.id.username);
        final EditText etPassword = viewLogin.findViewById(R.id.password);

        builder.setView(viewLogin);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String uname = etUsername.getText().toString();
                String pass = etPassword.getText().toString();

                if (uname.equalsIgnoreCase("meliyana") && pass.equalsIgnoreCase("123")) {
                    Toast.makeText(MainActivity.this, "Selamat Login Berhasil", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Tampilan_Utama.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal. Silahkan coba lagi", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("Tidak",null);

            AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

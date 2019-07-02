package com.example.praktikan.lat_mandiri;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Tampilan_Utama extends AppCompatActivity {

    TextView tv_score_a;
    TextView tv_score_b;
    int score_a = 0;
    int score_b = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan__utama);

        tv_score_a = findViewById(R.id.textView3);
        tv_score_b = findViewById(R.id.textView4);
    }
    public void point(View view){
        if(view.getId()==R.id.button2){
            score_a = score_a+2;
        }else if(view.getId()==R.id.button3){
            score_a = score_a+3;
        }else if(view.getId()==R.id.button4){
            score_a = score_a+5;
        }else if(view.getId()==R.id.button5){
            score_b = score_b+2;
        }else if(view.getId()==R.id.button6){
            score_b = score_b+3;
        }else if(view.getId()==R.id.button7){
            score_b = score_b+5;
        }
        tv_score_a.setText(score_a+"");
        tv_score_b.setText(score_b+"");
    }
    public void reset(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Tampilan_Utama.this);
        builder.setTitle("Reset");
        builder.setMessage("Anda sudah yakin");
        builder.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int score  = 0;
                tv_score_a.setText(String.valueOf(score));
                tv_score_b.setText(String.valueOf(score));
                score_a = 0;
                score_b = 0;
                Toast.makeText(Tampilan_Utama.this, "Reset Selesai", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Tidak",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
   public void selesai (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Tampilan_Utama.this);
        builder.setTitle("Finish");
        builder.setMessage("Mau Selesai Bermain Kaka");
        builder.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Tampilan_Utama.this, "Game Selesai", Toast.LENGTH_SHORT).show();
                NotificationCompat.Builder builderf = new NotificationCompat.Builder(Tampilan_Utama.this, "channel_1");
                builderf.setContentTitle("Permainan Selesai");
                if(score_a > score_b){
                    builderf.setContentText("Tim A Menang");
                }else if(score_b > score_a){
                    builderf.setContentText("Tim B Menang");
                }else{
                    builderf.setContentText("Kalian Berdua Seri");
                }
                builderf.setTicker("Pesan Ticker");
                builderf.setSmallIcon(R.drawable.game);
                builderf.setWhen(System.currentTimeMillis());

                int notifId = 2998;
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(notifId,builderf.build());

                int score  = 0;
                tv_score_a.setText(String.valueOf(score));
                tv_score_b.setText(String.valueOf(score));
                score_a = 0;
                score_b = 0;
            }

        });
        builder.setNegativeButton("Tidak",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();;
   }
}

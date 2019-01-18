package com.example.ninefourone.firstclass;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Button reSet;
    private ImageView imageView;
    private Button hopButton;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
        reSet = findViewById(R.id.reset_button);
        imageView = findViewById(R.id.imageview);
        hopButton = findViewById(R.id.hop_button);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                count++;
                if (count >= 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setIcon(R.drawable.test);
                    builder.setTitle("这是一个Dialog");
                    builder.setMessage("我告诉你。别动我");
                    builder.setPositiveButton("动你咋滴", new DatePickerDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplication(), "妈妈，他打我", Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNegativeButton("不敢不敢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplication(), "怂比", Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.show();
                } else {
                    String title = Constants.TITLES[count];
                    String buttonText = Constants.BUTTON[count];
                    int image = Constants.PICTUREIDS[count];
                    imageView.setBackground(getDrawable(image));
                    button.setText(buttonText);
                    textView.setText(title);
                }
            }
        });

        reSet.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                count = 0;
                String title = Constants.TITLES[count];
                String buttonText = Constants.BUTTON[count];
                int image = Constants.PICTUREIDS[count];
                imageView.setBackground(getDrawable(image));
                button.setText(buttonText);
                textView.setText(title);
            }
        });

        hopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Navigation.class);
                startActivity(intent);
//                finish();
            }
        });
    }

}

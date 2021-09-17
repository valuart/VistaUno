package com.example.vistauno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//private ImageView imagen1;
//private Button ver;

    private Button may;
    private Button min;
    private Button color;
    private TextView uni;
    private TextView sl;
    private TextView año;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_vista);
        inicializarVista();
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getColor().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer color) {
                uni.setTextColor(color);
                sl.setTextColor(color);
                año.setTextColor(color);
            }
        });
        vm.getMayuscula().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                uni.setText(s);
                sl.setText(s);
                año.setText(s);
            }
        });
        vm.getMinuscula().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                uni.setText(s);
                sl.setText(s);
                año.setText(s);
            }
        });

    }

   // @Override
   // protected void onResume() {
   //     super.onResume();
   //     inicializarVista();
   // }

    private void inicializarVista(){
        // ImageView imagen1 = findViewById(R.id.iView1);
       //  ver = findViewById(R.id.BTMostrar);
         //ver.setOnClickListener(new View.OnClickListener() {
         //    @Override
           //  public void onClick(View v) {
            //     imagen1.setImageResource(R.drawable.descarga2);
        //  }
       //  });
        uni = findViewById(R.id.TVUlp);
        sl = findViewById(R.id.TVSanluis);
        año = findViewById(R.id.TVAño);

        min = findViewById(R.id.BTMay);
        may = findViewById(R.id.BTMin);
        color = findViewById(R.id.BTVerde);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      vm.cambiarColor();
            }
        });
        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   vm.cambiarMayuscula(uni.getText().toString());
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarMinuscula(uni.getText().toString());
            }
        });

     }

}
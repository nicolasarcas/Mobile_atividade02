package com.example.gasolinaetanol;

import androidx.annotation.AnyRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarGas;
    private SeekBar seekBarEta;

    private TextInputLayout textCombustivel;
    private TextInputEditText txtInputResultado;

    private TextView txtValGas;
    private TextView txtValEt;

    private static final NumberFormat numberCurrency =
            NumberFormat.getCurrencyInstance();

    private ImageView imagem;

    private double percentGas = 5;
    private double percentEta = 5;

    private double conta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEta = findViewById(R.id.seekBarEtanol);
        seekBarGas = findViewById(R.id.seekBarGasolina);

        txtValEt = findViewById(R.id.txtValEt);
        txtValGas = findViewById(R.id.txtValGas);

        imagem = findViewById(R.id.imageView);

        textCombustivel = findViewById(R.id.txtResultado);

        txtInputResultado = findViewById(R.id.txtInputResultado);

        seekBarGas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentGas = progress;
                conta = percentEta/percentGas;
                txtValGas.setText(numberCurrency.format(percentGas));
                if(conta < 0.7){
                    imagem.setImageResource(R.drawable.etanol);
                    txtInputResultado.setText(R.string.etanol);
                }
                else{
                    imagem.setImageResource(R.drawable.gasolina);
                    txtInputResultado.setText(R.string.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarEta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentEta = progress;
                conta = percentEta/percentGas;
                txtValEt.setText(numberCurrency.format(percentEta));
                if(conta < 0.7){
                    txtInputResultado.setText(R.string.etanol);
                    imagem.setImageResource(R.drawable.etanol);
                }
                else{
                    imagem.setImageResource(R.drawable.gasolina);
                    txtInputResultado.setText(R.string.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

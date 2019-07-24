package com.fabriciomatos.componentesbasicos;

import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlcoolGasolinaAppActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool_gasolina_app);

        this.mViewHolder.btCalcular = findViewById(R.id.btCalcular);
        this.mViewHolder.btProximaLicao = findViewById(R.id.btProximaLicao);
        this.mViewHolder.btLicaoAnterior = findViewById(R.id.btLicaoAnterior);
        this.mViewHolder.etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        this.mViewHolder.etPrecoAlcool = findViewById(R.id.etPrecoAlcool);
        this.mViewHolder.tvResultado = findViewById(R.id.tvResultado);

        this.mViewHolder.btCalcular.setOnClickListener(this);
        this.mViewHolder.btLicaoAnterior.setOnClickListener(this);
        this.mViewHolder.btProximaLicao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btCalcular){

            if(this.mViewHolder.etPrecoGasolina.getText().toString().isEmpty()
                    || this.mViewHolder.etPrecoAlcool.getText().toString().isEmpty()){
                this.mViewHolder.tvResultado.setTextColor(Color.RED);
                this.mViewHolder.tvResultado.setText("Preencha ambos os preços");
            }else {
                this.calcularResultado(Double.parseDouble(this.mViewHolder.etPrecoGasolina.getText().toString()),
                        Double.parseDouble(this.mViewHolder.etPrecoAlcool.getText().toString()));
            }
        }
        else if(v.getId() == R.id.btLicaoAnterior){
            this.retornar();
        }
    }

    private void calcularResultado(double precoGasolina, double precoAlcool){
        if((precoAlcool / precoGasolina) <= 0.7){
            this.mViewHolder.tvResultado.setTextColor(Color.BLACK);
            this.mViewHolder.tvResultado.setText("Melhor Utilizar ÁLCOOL");
        }else{
            this.mViewHolder.tvResultado.setTextColor(Color.BLACK);
            this.mViewHolder.tvResultado.setText("Melhor Utilizar GASOLINA");
        }
    }

    private void retornar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    private class ViewHolder{
        private EditText etPrecoGasolina;
        private EditText etPrecoAlcool;
        private Button btCalcular;
        private Button btProximaLicao;
        private Button btLicaoAnterior;
        private TextView tvResultado;
    }
}

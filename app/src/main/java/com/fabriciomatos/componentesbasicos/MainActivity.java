package com.fabriciomatos.componentesbasicos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private List<String> check = new ArrayList<String>();
    private String radioDisponibilidadeDescricao = "Produto disponível: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.btEnviar = findViewById(R.id.btEnviar);
        this.mViewHolder.btProximaLicao = findViewById(R.id.btProximaLicao);
        this.mViewHolder.tvResultado = findViewById(R.id.tvResultadoCores);
        this.mViewHolder.cbBranco = findViewById(R.id.cbBranco);
        this.mViewHolder.cbVerde = findViewById(R.id.cbVerde);
        this.mViewHolder.cbVermelho = findViewById(R.id.cbVermelho);
        this.mViewHolder.tvDisponibilidadeProduto = findViewById(R.id.tvResultadoDisponibilidade);
        this.mViewHolder.rgEstoque = findViewById(R.id.rgEstoque);

        this.mViewHolder.btEnviar.setOnClickListener(this);
        this.mViewHolder.btProximaLicao.setOnClickListener(this);
        this.verificaRadioButton();
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btEnviar){
            check.clear();
            if(this.mViewHolder.cbBranco.isChecked()){
                check.add(this.mViewHolder.cbBranco.getText().toString());
            }
            if(this.mViewHolder.cbVerde.isChecked()){
                check.add(this.mViewHolder.cbVerde.getText().toString());
            }
            if(this.mViewHolder.cbVermelho.isChecked()){
                check.add(this.mViewHolder.cbVermelho.getText().toString());
            }

            String checkString = "Cores: ";

            for(int i = 0; i < check.size();i++){
                if ( i < check.size()){
                    checkString += check.get(i) + " ";
                } else {
                    checkString += check.get(i);
                }

            }
            if(!checkString.isEmpty()){
                this.mViewHolder.tvResultado.setText(checkString);
            } else {
                this.mViewHolder.tvResultado.setText("Nenhuma cor selecionada!");
            }
        }

        if(v.getId() == R.id.btProximaLicao){
            Intent intent = new Intent(this, AlcoolGasolinaAppActivity.class);
            startActivity(intent);
        }

    }

    private void verificaRadioButton(){

        this.mViewHolder.rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbSIm){
                    radioDisponibilidadeDescricao = "Produto disponível: ";
                    mViewHolder.tvDisponibilidadeProduto.setText(radioDisponibilidadeDescricao += "Sim");
                }else if(checkedId == R.id.rbNao){
                    radioDisponibilidadeDescricao = "Produto disponível: ";
                    mViewHolder.tvDisponibilidadeProduto.setText(radioDisponibilidadeDescricao += "Não");
                }
            }
        });
    }

    private class ViewHolder{

        private Button btEnviar;
        private Button btProximaLicao;
        private TextView tvResultado;
        private CheckBox cbBranco;
        private CheckBox cbVerde;
        private CheckBox cbVermelho;
        private TextView tvDisponibilidadeProduto;
        private RadioGroup rgEstoque;
    }
}

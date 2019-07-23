package com.fabriciomatos.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private List<String> check = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.nomeProduto = findViewById(R.id.etNomeProduto);
        this.mViewHolder.btEnviar = findViewById(R.id.btEnviar);
        this.mViewHolder.tvResultado = findViewById(R.id.tvResultado);
        this.mViewHolder.cbBranco = findViewById(R.id.cbBranco);
        this.mViewHolder.cbVerde = findViewById(R.id.cbVerde);
        this.mViewHolder.cbVermelho = findViewById(R.id.cbVermelho);

        this.mViewHolder.btEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        check.clear();
        //this.mViewHolder.tvResultado.setText(this.mViewHolder.nomeProduto.getText().toString());
        if(this.mViewHolder.cbBranco.isChecked()){
            check.add(this.mViewHolder.cbBranco.getText().toString());
        }
        if(this.mViewHolder.cbVerde.isChecked()){
            check.add(this.mViewHolder.cbVerde.getText().toString());
        }
        if(this.mViewHolder.cbVermelho.isChecked()){
            check.add(this.mViewHolder.cbVermelho.getText().toString());
        }

        String checkString = "";

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
            this.mViewHolder.tvResultado.setText("Nenhum check foi selecionado!");
        }

    }

    private class ViewHolder{

        private EditText nomeProduto;
        private Button btEnviar;
        private TextView tvResultado;
        private CheckBox cbBranco;
        private CheckBox cbVerde;
        private CheckBox cbVermelho;
    }
}

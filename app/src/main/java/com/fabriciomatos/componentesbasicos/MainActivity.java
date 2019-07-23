package com.fabriciomatos.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.nomeProduto = findViewById(R.id.etNomeProduto);
        this.mViewHolder.btEnviar = findViewById(R.id.btEnviar);
        this.mViewHolder.tvResultado = findViewById(R.id.tvResultado);

        this.mViewHolder.btEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.mViewHolder.tvResultado.setText(this.mViewHolder.nomeProduto.getText().toString());
    }

    private class ViewHolder{

        private EditText nomeProduto;
        private Button btEnviar;
        private TextView tvResultado;
    }
}

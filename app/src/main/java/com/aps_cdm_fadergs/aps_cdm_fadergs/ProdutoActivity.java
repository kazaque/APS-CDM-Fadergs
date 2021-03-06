package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProdutoActivity extends AppCompatActivity {

    private EditText etNome, etValor;
    private Button btnAdicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        etNome =(EditText) findViewById(R.id.etNome);
        etValor =(EditText) findViewById(R.id.etValor);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar();
            }
        });



    }

    private void Salvar(){
        Produto produto = new Produto();

        produto.setNome(etNome.getText().toString());
        produto.setValor(etValor.getText().toString());
        //produto.setCodLista(  );
        ProdutoDAO.inserir(produto, this);
        this.finish();
        Intent intent = new Intent(ProdutoActivity.this, CompraActivity.class);

        startActivity(intent);


    }
}

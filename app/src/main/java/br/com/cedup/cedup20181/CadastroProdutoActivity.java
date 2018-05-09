package br.com.cedup.cedup20181;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

import br.com.cedup.cedup20181.controller.ProdutoController;
import br.com.cedup.cedup20181.modelo.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {

    EditText campoCodigo, campoDescricao, campoMarca, campoPrecoBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        campoCodigo = findViewById(R.id.campoCodigo);
        campoDescricao = findViewById(R.id.campoDescricao);
        campoMarca = findViewById(R.id.campoMarca);
        campoPrecoBase = findViewById(R.id.campoPrecoBase);
    }

    private boolean validaCampos() {
        return true;
    }

    public void salvar(View view) {

        if (!validaCampos()) {
            return;
        }

        Produto produto = new Produto();
        produto.setDescricao(campoDescricao.getText().toString());
        produto.setMarca(campoMarca.getText().toString());
        produto.setPrecoBase(
                BigDecimal.valueOf(
                        Float.parseFloat(
                                campoPrecoBase.getText().toString())));

        ProdutoController crud = new ProdutoController(getBaseContext());
        long resultado = crud.create(produto);

        if (resultado == -1) {
            Toast.makeText(getBaseContext(),
            "Erro ao salvar o registro",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),
            "Registro salvo com sucesso",Toast.LENGTH_LONG).show();
        }

    }

    public void consultar(View view) {
        Intent intent = new Intent(this, ConsultaProdutoActivity.class);
        startActivity(intent);
    }
}

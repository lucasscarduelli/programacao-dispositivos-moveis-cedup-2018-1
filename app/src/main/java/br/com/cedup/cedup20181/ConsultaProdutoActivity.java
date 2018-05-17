package br.com.cedup.cedup20181;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import br.com.cedup.cedup20181.controller.ProdutoController;

public class ConsultaProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_produto);

        ProdutoController crud = new ProdutoController(getBaseContext());
        final Cursor cursor = crud.retrieve();

        String[] campos = {"_id", "descricao", "marca", "preco_base"};
        int[] componentes = { R.id.textoCodigo, R.id.textoDescricao, R.id.textoMarca, R.id.textoPrecoBase };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getBaseContext(), R.layout.lista_produtos, cursor,
                campos, componentes, 0
        );

        ListView lista = findViewById(R.id.listaProdutos);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                String idProduto = cursor.getString(cursor.getColumnIndexOrThrow("_id"));

                Intent intent = new Intent(ConsultaProdutoActivity.this, CadastroProdutoActivity.class);
                intent.putExtra("id", idProduto);

                startActivity(intent);
                finish();
            }
        });

        lista.setAdapter(adapter);
        registerForContextMenu(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
        ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_editar :
                Toast.makeText(this,
                 "Voce esta editando!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_excluir:
                Toast.makeText(this,
                 "Voce esta excluindo!", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

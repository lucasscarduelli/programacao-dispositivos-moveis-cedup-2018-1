package br.com.cedup.cedup20181;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BemVindoActivity extends AppCompatActivity {

    TextView mensagemBemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bem vindo");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        String login = args.getString("login");

        mensagemBemVindo = findViewById(R.id.mensagemBemVindo);
        mensagemBemVindo.setText(getText(R.string.seja_bem_vindo) + ", " + login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
                break;

            case R.id.opcao1:

                Intent intent = new Intent(this,
                        MenuLateral2Activity.class);
                startActivity(intent);

                Toast.makeText(this, "Opcao 01", Toast.LENGTH_LONG).show();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void abrirDialogoMensagem(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.confirmacao_exclusao);
        builder.setMessage(R.string.mensagem_confirmacao_exclusao);

        builder.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        /*
        builder.setNeutralButton("Neutro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        */

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    public void abrirDialogoLista(View view) {

        final Resources resources = getResources();
        final Context context = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.selecione_estado);
        builder.setItems(R.array.lista_estados, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                String[] listaEstados = resources.getStringArray(R.array.lista_estados);
                String estado = listaEstados[index];
                Toast.makeText(context,estado,Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void abrirCadastroProduto(View view) {
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    public void abrirTelaComTab(View view) {
        Intent intent = new Intent(this, TelaComTabActivity.class);
        startActivity(intent);

    }
}

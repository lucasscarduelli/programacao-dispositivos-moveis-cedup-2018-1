package br.com.cedup.cedup20181;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botaoLogar;
    EditText campoUsuario, campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogar = findViewById(R.id.botaoLogar);
        campoUsuario = findViewById(R.id.campoUsuario);
        campoSenha = findViewById(R.id.campoSenha);
    }

    public void onClickLogar(View view) {
        String usuario = campoUsuario.getText().toString();
        String senha = campoSenha.getText().toString();

        if ("lucas".equalsIgnoreCase(usuario) && "abc123".equalsIgnoreCase(senha)) {
            alert(getString(R.string.mensagemLoginSucesso));

            Intent intent = new Intent(this, BemVindoActivity.class);

            Bundle params = new Bundle();
            params.putString("login",usuario);
            intent.putExtras(params);

            startActivity(intent);

            finish();

        } else {
            alert(getString(R.string.mensagemLoginErro));
        }
    }

    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}

package br.com.cedup.cedup20181;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BemVindoActivity extends AppCompatActivity {

    TextView mensagemBemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        String login = args.getString("login");

        mensagemBemVindo = findViewById(R.id.mensagemBemVindo);
        mensagemBemVindo.setText(getText(R.string.seja_bem_vindo) + ", " + login);
    }
}

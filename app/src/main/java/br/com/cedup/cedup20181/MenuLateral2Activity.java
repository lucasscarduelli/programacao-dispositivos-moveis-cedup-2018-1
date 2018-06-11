package br.com.cedup.cedup20181;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuLateral2Activity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral2);

        drawerLayout = findViewById(R.id.drawer_layout);

        setupNavDrawer();
    }

    protected void setupNavDrawer() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburguer);
        actionBar.setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();
                onNavDrawerItemSelected(item);
                return true;
            }
        });
    }

    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    protected void onNavDrawerItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_lateral_opcao1 :
                alert("Voce selecionou a opcao 01 do menu!");
                break;
            case R.id.menu_lateral_opcao2 :
                alert("Voce selecionou a opcao 02 do menu!");
                break;
            case R.id.menu_lateral_opcao3 :
                alert("Voce selecionou a opcao 03 do menu!");
                break;
            case R.id.menu_lateral_configuracoes :
                alert("Voce selecionou a configuracao do menu!");
                break;
            case R.id.menu_lateral_sobre :
                alert("Voce selecionou a opcao sobre do menu!");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(Gravity.START);
                    return true;
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

package br.com.cedup.cedup20181;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TelaComTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_com_tab);

        configurarTab();
    }

    public void configurarTab() {

        TabHost tabHost = findViewById(R.id.tab_host);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("Tab 1");
        tab1.setContent(R.id.tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("Tab 2");
        tab2.setContent(R.id.tab2);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
    }
}

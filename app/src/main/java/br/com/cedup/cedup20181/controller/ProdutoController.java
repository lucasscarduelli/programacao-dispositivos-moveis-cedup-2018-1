package br.com.cedup.cedup20181.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.cedup.cedup20181.db.BancoDeDados;
import br.com.cedup.cedup20181.modelo.Produto;

public class ProdutoController {

    private SQLiteDatabase instanciaDb;
    private BancoDeDados db;

    public ProdutoController(Context context) {
        this.db = new BancoDeDados(context);
    }

    public long create(final Produto produto) {
        return 0;
    }

    public long update(final Produto produto) {
        return 0;
    }

    public Cursor retrieve() {
        return null;
    }

    public long delete(final Produto produto) {
        return 0;
    }
}

package br.com.cedup.cedup20181.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.math.BigDecimal;

import br.com.cedup.cedup20181.db.BancoDeDados;
import br.com.cedup.cedup20181.modelo.Produto;

public class ProdutoController {

    private SQLiteDatabase instanciaDb;
    private BancoDeDados db;

    public ProdutoController(Context context) {
        this.db = new BancoDeDados(context);
    }

    public long create(final Produto produto) {
        ContentValues dados = new ContentValues();
        long resultado;

        instanciaDb = db.getWritableDatabase();
        dados.put("descricao", produto.getDescricao());
        dados.put("marca", produto.getMarca());
        dados.put("preco_base", produto.getPrecoBase().floatValue());

        resultado = instanciaDb.insert("produto",null,dados);
        instanciaDb.close();

        return resultado;
    }

    public long update(final Produto produto) {

        ContentValues dados = new ContentValues();
        long resultado;

        instanciaDb = db.getWritableDatabase();
        dados.put("descricao", produto.getDescricao());
        dados.put("marca", produto.getMarca());
        dados.put("preco_base", produto.getPrecoBase().floatValue());

        String where = "_id = " + produto.getId();

        resultado = instanciaDb.update("produto",dados, where, null);
        instanciaDb.close();

        return resultado;

    }

    public Produto getById(int id) {

        String[] campos = {"_id", "descricao", "marca", "preco_base"};
        String where = "_id = " + id;
        instanciaDb = db.getReadableDatabase();

        Cursor cursor = instanciaDb.query("produto",campos,
                where,null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        instanciaDb.close();
        Produto produto = new Produto();
        produto.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        produto.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow("descricao")));
        produto.setMarca(cursor.getString(cursor.getColumnIndexOrThrow("marca")));
        produto.setPrecoBase(BigDecimal.valueOf(cursor.getFloat(cursor.getColumnIndexOrThrow("preco_base"))));

        return produto;
    }

    public Cursor retrieve() {
        String[] campos = {"_id", "descricao", "marca", "preco_base"};
        instanciaDb = db.getReadableDatabase();

        Cursor cursor = instanciaDb.query("produto",campos,
                null,null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        instanciaDb.close();
        return cursor;
    }

    public long delete(final Produto produto) {
        return 0;
    }
}

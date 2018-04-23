package br.com.cedup.cedup20181.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String DB_NOME = "CEDUP20181";
    private static final int DB_VERSAO = 1;

    public BancoDeDados(Context context) {
        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String create_table_produto =
                "CREATE TABLE produto ( " +
                        "_id integer primary key autoincrement, " +
                        "descricao text not null," +
                        "marca text not null," +
                        "preco_base numeric not null" +
                ")";

        final String create_table_usuario =
                "CREATE TABLE usuario (" +
                        "_id integer primary key autoincrement, " +
                        "nome text not null, " +
                        "email text not null, " +
                        "login text not null, " +
                        "senha text not null " +
                ")";

        db.execSQL(create_table_produto);
        db.execSQL(create_table_usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVerson, int newVersion) {

        if (newVersion == 2) {
            upgradeVersao2(db);
        }

    }

    private void upgradeVersao2(SQLiteDatabase db) {

    }

}

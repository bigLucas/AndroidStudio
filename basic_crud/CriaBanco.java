package com.example.basic_crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper
{
    private static final String NOME_BANCO = "banco.db";
    protected static final String TABELA = "livros";
    protected static final String ID = "_id";
    protected static final String TITULO = "titulo";
    protected static final String AUTOR = "autor";
    protected static final String EDITORA = "editora";
    private static final int VERSAO = 1;

    public CriaBanco(Context context)
    {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + EDITORA + " text"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}

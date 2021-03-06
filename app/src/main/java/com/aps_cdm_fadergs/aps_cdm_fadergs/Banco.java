package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "produto";
    private static final int VERSAO_BANCO = 2;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE IF NOT EXISTS listas ( " +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "  nome TEXT  ) " );

        db.execSQL("CREATE TABLE IF NOT EXISTS produtos ( " +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "  titulo TEXT , " +
                "  texto TEXT, " +
                "  codLista INTEGER  ) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE produtos");
        onCreate(db);

    }


}

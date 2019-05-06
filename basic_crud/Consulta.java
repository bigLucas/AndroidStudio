package com.example.basic_crud;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Consulta extends Activity
{
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.ID, CriaBanco.TITULO};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.livros_layout, cursor, nomeCampos, idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent = new Intent(Consulta.this, Alterar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}

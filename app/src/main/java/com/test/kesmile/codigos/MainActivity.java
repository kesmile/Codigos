package com.test.kesmile.codigos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.test.kesmile.codigos.basedatos.BaseActivity;
import com.test.kesmile.codigos.contentprovider.ContentActivity;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = new String[] {"Base de datos","Content Provider"};
        lista = (ListView) findViewById(R.id.lst_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,data);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    Toast.makeText(getApplicationContext(),"position: " + Integer.toString(position),Toast.LENGTH_SHORT).show();
                Intent i;
                switch (position){
                    case 0:
                        i = new Intent(getApplicationContext(), BaseActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), ContentActivity.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}

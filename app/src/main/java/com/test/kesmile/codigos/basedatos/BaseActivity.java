package com.test.kesmile.codigos.basedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.test.kesmile.codigos.R;
import com.test.kesmile.codigos.basedatos.models.UsuariosSQLiteHelper;

import java.util.List;

/**
 * Created by root on 16/01/15.
 */
public class BaseActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText edit_usuarios;
    private EditText edit_password;
    private Button btn_insertar;
    private SQLiteDatabase db;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_main_activity);
        edit_usuarios = (EditText) findViewById(R.id.etxt_usuario);
        edit_password = (EditText) findViewById(R.id.etxt_password);
        btn_insertar = (Button) findViewById(R.id.btn_insertar);
        btn_insertar.setOnClickListener(this);
        lista = (ListView) findViewById(R.id.lst_view);
        Cursor c = getUsuariosData();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                                                              android.R.layout.simple_list_item_2,
                                                              c,
                                                              new String[]{"usuario", "password"},
                                                              new int[]{android.R.id.text1,android.R.id.text2});
        lista.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insertar:

                    UsuariosSQLiteHelper tablaUsuarios = new UsuariosSQLiteHelper(this,"tablausuarios",null,1);
                    db = tablaUsuarios.getWritableDatabase();
                    String usuario = edit_usuarios.getText().toString();
                    String password = edit_password.getText().toString();
               if(db != null){
                    //Insertamos los datos en la tabla Usuarios
                    db.execSQL("INSERT INTO usuarios (usuario, password) " +
                            "VALUES ('" + usuario + "', '" + password +"')");
                    db.close();
                   edit_usuarios.setText("");
                   edit_password.setText("");
                   edit_password.clearFocus();
                    Toast.makeText(this,"Usuario: " + usuario + " Insertado exitosamente", Toast.LENGTH_LONG).show();
                }
            break;
        }
    }
    protected Cursor getUsuariosData(){
        UsuariosSQLiteHelper tablaUsuarios = new UsuariosSQLiteHelper(this,"tablausuarios",null,1);
        db = tablaUsuarios.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM usuarios", null);
        //db.close();
        return c;
    }
}

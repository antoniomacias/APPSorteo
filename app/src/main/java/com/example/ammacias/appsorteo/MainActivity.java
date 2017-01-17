package com.example.ammacias.appsorteo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ammacias.appsorteo.Clase.Item;
import com.example.ammacias.appsorteo.Interfaz.IItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IItem{

    EditText e;

    List<Item> listInput;
    public List<Item> getListInput() {
        return listInput;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Se podría guardar en memoria interna
        listInput = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_logout:
                Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //Add Item to ListView
    public void functionAdd(View view) {
        e = (EditText) findViewById(R.id.input_add);
        listInput.add(new Item(e.getText().toString()));
        for (Item i:listInput) {
            Toast.makeText(this, "Input1: "+i.getInput1(), Toast.LENGTH_SHORT).show();
        }
        //TODO: Call adapter to reload ListView
    }

    @Override
    public void onClickItem(Item i) {
        Toast.makeText(this, ""+i.getInput1(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickDelete(Item i) {
        for (Item it:listInput) {
            if (it.equals(i)){
                listInput.remove(it);
                break;
            }
        }
        //TODO: Call adapter to reload ListView
    }
}

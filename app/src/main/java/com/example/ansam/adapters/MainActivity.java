package com.example.ansam.adapters;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,town;
    Button add,show;
    String Name,Town;
    dbHelper dbhelper;
    ListView list;
    CursorAdapterClass adapter;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.etName);
        town=(EditText)findViewById(R.id.etTown);
        add=(Button)findViewById(R.id.add);
        show=(Button)findViewById(R.id.show);
        list=(ListView)findViewById(R.id.listView);
       // adapter=new CursorAdapterClass(,c);
        dbhelper=new dbHelper(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=name.getText().toString();
                Town=town.getText().toString();
                if(Name.equals("")||Town.equals("")){
                    Toast.makeText(getApplicationContext(),"please enter all fields!!",Toast.LENGTH_SHORT).show();
                }
                else{
                   boolean b= dbhelper.insertUser(Name,Town);
                    name.setText("");
                    town.setText("");


                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=dbhelper.getData();
                c.moveToFirst();
                if(c.getCount()>0) {
                    adapter = new CursorAdapterClass(getApplicationContext(), c);
                }
                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);

            }
        });

    }
}

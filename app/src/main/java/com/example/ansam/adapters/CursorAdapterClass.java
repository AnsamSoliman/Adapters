package com.example.ansam.adapters;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by ansam on 11/14/2016.
 */

public class CursorAdapterClass extends CursorAdapter {
    TextView user,town;
    private LayoutInflater mInflater;
    public CursorAdapterClass(Context context, Cursor c) {
        super(context,c,0);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return mInflater.inflate(R.layout.adapter_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        user=(TextView)view.findViewById(R.id.nameA);
        town=(TextView)view.findViewById(R.id.townA);
        String n=cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String t=cursor.getString(cursor.getColumnIndexOrThrow("town"));
        user.setText(n);
        town.setText(t);

    }
}

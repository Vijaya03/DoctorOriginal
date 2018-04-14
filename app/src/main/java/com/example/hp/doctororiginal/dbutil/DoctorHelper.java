package com.example.hp.doctororiginal.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by HP on 02-04-2018.
 */

public class DoctorHelper extends SQLiteOpenHelper{
    Context context;
    public DoctorHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DoctorConstant.MED_SQL);
        sqLiteDatabase.execSQL(DoctorConstant.CL_SQL);

        sqLiteDatabase.execSQL(DoctorConstant.PA_SQL);
        Toast.makeText(context,"Table created",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

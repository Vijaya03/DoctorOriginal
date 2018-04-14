package com.example.hp.doctororiginal.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by HP on 02-04-2018.
 */

public class DoctorManager { DoctorHelper doctorHelper;
    SQLiteDatabase sqLiteDatabase;
    public DoctorManager(Context context)
    {
       doctorHelper=new DoctorHelper(context, DoctorConstant.DBNAME,null,DoctorConstant.DBVERSION);

    }
    public SQLiteDatabase openDB()
    {
        sqLiteDatabase=doctorHelper.getWritableDatabase();
        return sqLiteDatabase;
    }
    public void closeDB()
    {
        doctorHelper.close();
    }
}


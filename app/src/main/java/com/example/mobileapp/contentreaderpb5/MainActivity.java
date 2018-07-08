package com.example.mobileapp.contentreaderpb5;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infoTV;
    private static final Uri CONTENT_URI = Uri.parse("content://com.example.mobileapp.contentproviderpb5/tbl_student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoTV = findViewById(R.id.studentInfo);
        getInfo();
    }
    private void getInfo(){
        Cursor cursor = getContentResolver().query(CONTENT_URI,null,null,null,null);
        String info = "";
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                info += name+"\n"+department+"\n\n";
            }while (cursor.moveToNext());

        }
        infoTV.setText(info);
    }
}

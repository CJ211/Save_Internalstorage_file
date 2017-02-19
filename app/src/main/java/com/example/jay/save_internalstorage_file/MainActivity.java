package com.example.jay.save_internalstorage_file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textmsg=(EditText)findViewById(R.id.editText1);
    }
    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();
            MainActivity.this.getFilesDir().getAbsolutePath();
            //display file saved message
            Toast.makeText(getBaseContext(), "SAVED!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void CheckBtn(View v) {
        //checking if file exists in internal storage

        File file = new File(getFilesDir(), "mytextfile.txt" );
        if (file.exists()) {
            Toast.makeText(getBaseContext(),"File Exists!",Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(getBaseContext(),"File Does Not Exist!",Toast.LENGTH_SHORT).show();
        }
    }
}

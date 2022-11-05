package kp.ranjith.raguclasscodes;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalExternalStorage extends AppCompatActivity {

    EditText editTextFileName,editTextData;
    Button saveInternalButton,readinternalButton;
    Button saveExternalButton,readExternalButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_external_storage);

        editTextFileName = findViewById(R.id.editText1);
        editTextData = findViewById(R.id.editText2);
        saveInternalButton = findViewById(R.id.button1);
        readinternalButton = findViewById(R.id.button2);

        saveExternalButton = findViewById(R.id.button14);
        readExternalButton = findViewById(R.id.button17);
        ActivityCompat.requestPermissions(InternalExternalStorage.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveExternalButton.setEnabled(false);
            Toast.makeText(this, "Storage unavailable", Toast.LENGTH_SHORT).show();
        }

        //Performing Action on Read Button
        saveInternalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String filename = editTextFileName.getText().toString();
                String data = editTextData.getText().toString();

                FileOutputStream fos;
                try {
                    fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(),filename + " saved Internal",
                            Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}

            }

        });

        //Performing Action on Read Button
        readinternalButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();

                StringBuffer stringBuffer = new StringBuffer();

                try {
                    //Attaching BufferedReader to the FileInputStream by the help of InputStreamReader
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                            openFileInput(filename)));

                    String inputString;
                    //Reading data line by line and storing it into the stringbuffer

                    while ((inputString = inputReader.readLine()) != null) {
                        stringBuffer.append(inputString + "\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Displaying data on the toast
                Toast.makeText(getApplicationContext(),stringBuffer.toString(),
                        Toast.LENGTH_LONG).show();

            }

        });

        saveExternalButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                String data=editTextData.getText().toString();

                try {
                    //File myFile = new File("/sdcard/"+filename);
                   /// File myFile = new File(Environment.getExternalStorageState()+filename);

                    File directory = getFilesDir(); //or getExternalFilesDir(null); for external storage
                    File file = new File(directory, filename);

                    file.createNewFile();

                    FileOutputStream fOut = new FileOutputStream(file);

                    OutputStreamWriter myOutWriter = new

                            OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(),filename + "saved External",Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}

            }

        });

        //Performing action on Read Button
        readExternalButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();

                String aDataRow = "";
                String aBuffer = "";
                try {
                    //File myFile = new File("/sdcard/"+filename);
//                    File myFile = new File(getFilesDir()+filename);

                    File directory = getFilesDir(); //or getExternalFilesDir(null); for external storage
                    File file = new File(directory, filename);


                    FileInputStream fIn = new FileInputStream(file);
                    BufferedReader myReader = new BufferedReader(
                            new InputStreamReader(fIn));

                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    myReader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext

                        (), aBuffer, Toast.LENGTH_LONG).show();

            }

        });
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(InternalExternalStorage.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}

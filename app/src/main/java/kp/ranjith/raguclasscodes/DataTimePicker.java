package kp.ranjith.raguclasscodes;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import is.arontibo.library.ElasticDownloadView;

public class DataTimePicker extends AppCompatActivity {

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    EditText ed1,ed2;

    //ElasticDownloadView elasticDownloadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_time_picker);
        ed1=findViewById(R.id.editTextTextPersonName2);
        ed2=findViewById(R.id.editTextTextPersonName3);

        //  elasticDownloadView = findViewById(R.id.elastic_download_view);
        ///  elasticDownloadView.startIntro();
        //  elasticDownloadView.setProgress(25);
    }


    public void datee(View view) {
        datePickerDialog = new DatePickerDialog(DataTimePicker.this, onDateSetListener, 2010, 0, 06);
        datePickerDialog.show();

        //elasticDownloadView.success(); //This function moves the cursor to 100 if the progress has not been set already
        //elasticDownloadView.fail();
    }


    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(DataTimePicker.this, year + "/" + month + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();
            ed1.setText(dayOfMonth + "/" + (month+1) + "/" + year);
        }
    };

    public void timee(View view) {
        timePickerDialog = new TimePickerDialog(DataTimePicker.this, onTimeSetListener, 02, 10, true);
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(DataTimePicker.this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            ed2.setText(hourOfDay + ":" + minute);

        }
    };
}
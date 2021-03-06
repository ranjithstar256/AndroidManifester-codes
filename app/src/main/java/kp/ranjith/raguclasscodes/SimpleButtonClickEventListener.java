package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleButtonClickEventListener extends AppCompatActivity {

    // ITS VERY MUST!!! Always follow Declaration above oncreate method
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_button_click_event_listener);
        // ITS VERY MUST!!! Always follow Initialization inside oncreate method
        btn = findViewById(R.id.button);

        //usage
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimpleButtonClickEventListener.this, "btn got clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void anyname(View view) {
        Toast.makeText(this, "button got clicked", Toast.LENGTH_SHORT).show();
    }


    //ADDING MENU CODE

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menefilenam,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id ;

        id = item.getItemId();
        switch (id){

            case R.id.idfile:
                Toast.makeText(this, "file selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.idopen:
                Toast.makeText(this, "open selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.idsave:
                Toast.makeText(this, "save selected", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

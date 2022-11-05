package kp.ranjith.raguclasscodes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleAlertDialog extends AppCompatActivity {

    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_alert_dialog);
        alertDialog = new AlertDialog.Builder(SimpleAlertDialog.this);
        alertDialog.setTitle("this is title");
        alertDialog.setMessage("this is message");
        alertDialog.setIcon(android.R.drawable.ic_media_play); //using buildin icon
    }

    public void custdia(View view) {
// Create custom dialog object
        final Dialog dialog = new Dialog(SimpleAlertDialog.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.custom_dialog);
        // Set dialog title
        dialog.setTitle("Custom Dialog");

        // set values for custom dialog components - text, image and button
        TextView text = dialog.findViewById(R.id.textDialog);
        //text.setText("Custom dialog Android example by AndroidManifester");
       
        dialog.show();

        Button declineButton = dialog.findViewById(R.id.declineButton);
        // if decline button is clicked, close the custom dialog
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
            }
        });

    }

    public void witbtn(View view) {
        alertDialog.setPositiveButton("Yes",null);
        alertDialog.setNegativeButton("No",null); // listener is null (second parameter)

        //adding listener
        alertDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SimpleAlertDialog.this, "cancel btn got clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }

    public void nobtn(View view) {
        alertDialog.show();

    }
}

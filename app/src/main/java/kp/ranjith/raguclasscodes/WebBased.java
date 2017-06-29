package kp.ranjith.raguclasscodes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebBased extends AppCompatActivity {
    TextView textView,textView2;
    String s1,s2,jsonstr;
    ProgressDialog progressDialog;

    JSONObject whl,obj7,obj8;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_based);
        textView= (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);

    }

    public void getcont(View view) {
        GetContacts getContacts = new GetContacts();
        getContacts.execute();
    }

    private class GetContacts extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(WebBased.this);
            progressDialog.setMessage("Please wait");
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            Ragu ragu = new Ragu();
          jsonstr = ragu.abc("http://api.androidhive.info/contacts/");

            try {
                whl= new JSONObject(jsonstr);

                jsonArray= whl.getJSONArray("contacts");

                obj7=jsonArray.getJSONObject(7);

                s1=obj7.getString("name");
                obj8=jsonArray.getJSONObject(8);

                s2=obj8.getString("name");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.dismiss();

            textView.setText(s1);
            textView2.setText(s2);

        }
    }
}

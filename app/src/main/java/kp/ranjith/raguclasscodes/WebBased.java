package kp.ranjith.raguclasscodes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WebBased extends AppCompatActivity {
    TextView textView, textView2;
    String s1, s2, jsonstr;
    ProgressDialog progressDialog;

    JSONObject whl, obj7, obj8;
    JSONArray jsonArray;
    ListView listView;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_based);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        listView = findViewById(R.id.lis);
        arrayList = new ArrayList();

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
            jsonstr = ragu.abc("https://api.androidhive.info/contacts/");

            try {
                whl = new JSONObject(jsonstr);

                jsonArray = whl.getJSONArray("contacts");

                for (int i = 0; i < jsonArray.length(); i++) {
                    obj7 = jsonArray.getJSONObject(i);
                    arrayList.add(obj7.getString("name") + "\n");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        public void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.dismiss();

            textView.setText(s1);
            textView2.setText(s2);
            ArrayAdapter arrayAdapter = new ArrayAdapter(WebBased.this, android.R.layout.simple_list_item_1, arrayList);

            listView.setAdapter(arrayAdapter);
        }
    }
}

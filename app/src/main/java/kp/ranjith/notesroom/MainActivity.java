package kp.ranjith.notesroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;/*
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;*/

import kp.ranjith.raguclasscodes.R;

public class MainActivity extends AppCompatActivity {

    Task singletask;
    EditText e,f,g;
    String se,sf,sg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e=findViewById(R.id.editTextTextPersonName4);
        f=findViewById(R.id.editTextTextPersonName5);
        g=findViewById(R.id.editTextTextPersonName6);
        singletask= new Task();
    }

    public void ra(View view) {
        se= e.getText().toString();
        sf= f.getText().toString();
        sg= g.getText().toString();
        RetriveTask st = new RetriveTask();
        st.execute();
    }

    public void sa(View view) {
        se= e.getText().toString();
        sf= f.getText().toString();
        sg= g.getText().toString();
        SaveTask st = new SaveTask();
        st.execute();
    }

    class SaveTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() { //1
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {//2

            //creating a task
            Task task = new Task();
            task.setTask(se);
            task.setDesc(sg);
            task.setFinishBy(sf);
            task.setFinished(false);

            //adding to database
            DatabaseClientt.getInstance(getApplicationContext()).getAppDatabase().taskDao().insert(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {//3
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }
    class RetriveTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() { //1
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {//2

            //creating a task
            Task task = new Task();
            task.setTask(se);
            task.setDesc(sg);
            task.setFinishBy(sf);
            task.setFinished(false);

            //adding to database

         singletask=   DatabaseClientt.getInstance(getApplicationContext()).getAppDatabase().taskDao().getdesktn(se);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {//3
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), ""+singletask.getDesc(), Toast.LENGTH_LONG).show();
        }
    }


    //   db = FirebaseFirestore.getInstance();
    /*    Task task = new Task();
        task.setTask("buy home");
        task.setDesc("with dog");
        task.setFinishBy("this week");
        task.setFinished(false);*/
  /*      db.collection("users")
                .add(task)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAGavbnm", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAGavbnm", "Error adding document", e);
                    }
                });*/
    // Create a new user with a first and last name


// Add a new document with a generated ID
    /*    db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAGavbnm", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAGavbnm", "Error getting documents.", task.getException());
                        }
                    }
                });*/

     /*          db.collection("users")
                    .add(task)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAGavbnm", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("TAGavbnm", "Error adding document", e);
                        }
                    });*/
}
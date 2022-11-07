package kp.ranjith.raguclasscodes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class WorkMngrExpl extends AppCompatActivity {
    WorkManager workManager;
    AppCompatButton btnStartOneTimeRequest, btnStartPeriodicRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_mngr_expl);
        workManager = WorkManager.getInstance();
        btnStartOneTimeRequest = findViewById(R.id.button18);
        btnStartPeriodicRequest = findViewById(R.id.button19);
    }


    public void onetm(View view) {

        Constraints constraints = new Constraints.Builder()
                //.setRequiresCharging(false)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder
                (WorkrClas.class)
             //   .setConstraints(constraints)
                .build();
        workManager.enqueue(oneTimeWorkRequest);

    }

    public void perdctm(View view) {
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(false)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(
                WorkrClas.class, 24, TimeUnit.HOURS)
                .setConstraints(constraints)
                .build();
        workManager.enqueue(periodicWorkRequest);
    }

}

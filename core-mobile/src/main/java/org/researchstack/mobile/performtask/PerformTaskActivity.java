package org.researchstack.mobile.performtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.researchstack.mobile.R;


public class PerformTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rs_perform_task_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PerformTaskFragment.newInstance())
                    .commitNow();
        }
    }
}

package net.mishkovskyi.musings;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.content.SharedPreferences;

public class HelloWorldActivity extends Activity
{
    public static final String PREFERENCES = "preferences-helloworld";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle state)
    {
        super.onCreate(state);
        SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
        tasks =
        for (task in tasks) {
            TextView taskView = new TextView(this);
            taskView.setText();
            R.layout.main.addView(taskView);
        }
        setContentView(R.layout.main);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

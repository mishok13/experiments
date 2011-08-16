package net.mishkovskyi.musings;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.util.List;
import java.util.Arrays;
import net.mishkovskyi.musings.TaskView;

public class HelloWorldActivity extends Activity
{
    public static final String PREFERENCES = "preferences-helloworld";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle state)
    {
        super.onCreate(state);
        SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        List<String> tasks = Arrays.asList("First", "Foo", "Bar", "42");
        for (String task: tasks) {
            TaskView taskView = new TaskView(this);
            taskView.setText(task);
            mainLayout.addView(taskView);
        }
        setContentView(mainLayout);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

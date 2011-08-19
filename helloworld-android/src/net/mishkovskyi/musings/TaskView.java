package net.mishkovskyi.musings;

import android.widget.TextView;
import android.content.Context;
import android.view.MotionEvent;

public class TaskView extends TextView
{
    public TaskView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}

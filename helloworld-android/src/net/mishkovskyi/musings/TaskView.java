package net.mishkovskyi.musings;

import android.widget.TextView;
import android.view.MotionEvent;

public class TaskView extends TextView
{
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}

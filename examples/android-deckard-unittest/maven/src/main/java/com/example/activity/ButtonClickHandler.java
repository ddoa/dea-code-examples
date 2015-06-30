package com.example.activity;

import android.view.View;
import android.widget.EditText;
import com.example.R;
import com.google.inject.Inject;

/**
 * Description for the class ButtonClickHandler:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2012 HAN University, All rights reserved.
 */
public class ButtonClickHandler implements IButtonClickHandler {

    private DeckardActivity activity;

    public ButtonClickHandler() {
    }

    public void setActivity(DeckardActivity activity)
    {
         this.activity = activity;
    }

    @Override
    public void onClick(View arg0) {
        EditText editText = (EditText) activity.findViewById(R.id.editText);
        editText.setText("Hello World");
    }
}

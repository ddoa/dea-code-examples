package com.example.activity;

import android.widget.Button;
import android.widget.EditText;
import com.example.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

/**
 * Description for the class ButtonClickHandlerTest:
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

@RunWith(RobolectricTestRunner.class)
public class ButtonClickHandlerTest {
    @Test
    public void testOnClick() throws Exception {
        final DeckardActivity deckardActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();

        Button button = (Button) deckardActivity.findViewById(R.id.button);
        button.performClick();

        EditText editText = (EditText) deckardActivity.findViewById(R.id.editText);
        assertEquals(editText.getText(),"Hello World");
    }
}

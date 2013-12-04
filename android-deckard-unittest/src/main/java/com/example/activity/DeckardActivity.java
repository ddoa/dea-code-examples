package com.example.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.R;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.deckard)
public class DeckardActivity extends RoboActivity {
    @InjectView(R.id.button) Button button;
    @InjectView(R.id.textView) TextView textView;

    @Inject IButtonClickHandler buttonClickHandler;
    @Inject IDataController dataController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonClickHandler.setActivity(this);
        button.setOnClickListener(buttonClickHandler);
        textView.setText(dataController.getData());
    }
}

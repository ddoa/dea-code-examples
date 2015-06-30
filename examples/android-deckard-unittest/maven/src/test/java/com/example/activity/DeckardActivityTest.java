package com.example.activity;

import android.widget.TextView;
import com.example.R;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class DeckardActivityTest {
    public static final String TEXTVIEW_VALUE = "OK";
    // We want to mock the datacontroller to prevent the actual implementation to make HTTP-calls.
    @Mock
    IDataController dataController;


    @Test
    public void testSomething() throws Exception {
        when(dataController.getData()).thenReturn(TEXTVIEW_VALUE);
        DeckardActivity deckardActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();
        TextView textView = (TextView) deckardActivity.findViewById(R.id.textView);
        assertEquals(textView.getText(), TEXTVIEW_VALUE);
    }


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestGuiceModule module = new TestGuiceModule();
        // Tell Guice which bindings to use, during tests we use the mock-implementation for the IDataController
        module.addBinding(IDataController.class, dataController);
        TestGuiceModule.setUp(this, module);
    }

    @After
    public void tearDown() {
        TestGuiceModule.tearDown();
    }
}

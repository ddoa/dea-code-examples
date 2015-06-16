package com.example.activity;

import android.app.Application;
import roboguice.RoboGuice;

/**
 * Description for the class DeckardApplication:
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
public class DeckardApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
            RoboGuice.newDefaultRoboModule(this), new DeckardModule());
    }
}

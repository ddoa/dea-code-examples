package com.example.activity;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Description for the class DeckardModule:
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
public class DeckardModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(IButtonClickHandler.class).to(ButtonClickHandler.class);
        binder.bind(IDataController.class).to(RestDataController.class);
    }
}

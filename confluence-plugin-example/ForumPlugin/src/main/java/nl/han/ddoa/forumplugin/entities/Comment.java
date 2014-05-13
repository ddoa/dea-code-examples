package nl.han.ddoa.forumplugin.entities;

import net.java.ao.Entity;
import net.java.ao.Preload;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
@Preload
public interface Comment extends Entity {
    public String getText();
    public void setText(String text);

}

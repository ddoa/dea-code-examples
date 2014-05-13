package nl.han.ddoa.forumplugin.entities;

import net.java.ao.Entity;
import net.java.ao.OneToMany;
import net.java.ao.Preload;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
@Preload
public interface ForumThread extends Entity {
    public String getTitle();
    public void setTitle(String name);

    @OneToMany
    public Post[] getPosts();
}

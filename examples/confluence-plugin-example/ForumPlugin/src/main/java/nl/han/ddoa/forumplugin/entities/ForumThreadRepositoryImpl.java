package nl.han.ddoa.forumplugin.entities;

import com.atlassian.activeobjects.external.ActiveObjects;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class ForumThreadRepositoryImpl implements ForumThreadRepository {
    private final ActiveObjects ao;

    public ForumThreadRepositoryImpl(ActiveObjects ao)
    {
        this.ao = checkNotNull(ao);
    }

    @Override
    public ForumThread add(String title) {
        final ForumThread thread = ao.create(ForumThread.class);
        thread.setTitle(title);
        thread.save();
        return thread;
    }

    @Override
    public List<ForumThread> all() {
        return newArrayList(ao.find(ForumThread.class));
    }

    @Override
    public void delete(int id) {
        ao.delete(ao.get(ForumThread.class, id));
    }
}

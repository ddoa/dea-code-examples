package nl.han.ddoa.forumplugin.entities;

import com.atlassian.activeobjects.tx.Transactional;

import java.util.List;

/**
 * Description for the class ForumThreadRepository:
 * <p/>
 * Interface providing the DDD Repository pattern.
 * <p/>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */

@Transactional
public interface ForumThreadRepository {
    ForumThread add(String title);

    List<ForumThread> all();

    void delete(int id);
}

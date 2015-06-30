package nl.han.ddoa.forumplugin.entities;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.activeobjects.test.TestActiveObjects;
import net.java.ao.EntityManager;
import net.java.ao.test.jdbc.Data;
import net.java.ao.test.jdbc.DatabaseUpdater;
import net.java.ao.test.junit.ActiveObjectsJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
@RunWith(ActiveObjectsJUnitRunner.class)
@Data(ForumThreadRepositoryTest.ServiceTestDatabaseUpdater.class)
public class ForumThreadRepositoryTest {

    public EntityManager entityManager;
    private ActiveObjects ao;
    private ForumThreadRepository threadRepository;

    @Before
    public void setUp() throws Exception {
        assertNotNull(entityManager);
        ao = new TestActiveObjects(entityManager);
        threadRepository = new ForumThreadRepositoryImpl(ao);
    }

    @Test
    public void whenNothingAddedThereAreNoForumsAvailable() {
        assertEquals(0, threadRepository.all().size());
    }

    @Test
    public void whenOneForumIsCreatedThereCanBeOnlyOne()
    {
        threadRepository.add("Fourum");
        assertEquals(1, threadRepository.all().size());
    }

    public static final class ServiceTestDatabaseUpdater implements DatabaseUpdater {
        @Override
        public void update(EntityManager entityManager) throws Exception {
            entityManager.migrate(ForumThread.class);
        }
    }
}

package nl.han.ddoa.forumplugin.services.rest;

import nl.han.ddoa.forumplugin.entities.ForumThread;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Description for the class SerializableForumThread:
 * <p/>
 * Since you cannot put @XMLELement annotations on a Active Object Entity we need (for every Entity!)
 * a Serialized form of an AO entity.
 * <p/>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */

@XmlRootElement
public class SerializableForumThread {
    private String title;
    private int id;

    private SerializableForumThread() {
    }

    public SerializableForumThread(String title, int id) {
        this.title = title;
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static SerializableForumThread build(ForumThread forumThread) {
        return new SerializableForumThread(forumThread.getTitle(), forumThread.getID());
    }

    public static SerializableForumThread[] build(List<ForumThread> forumThreads) {
        SerializableForumThread[] serializableForumThreads = new SerializableForumThread[forumThreads.size()];
        for (int i = 0; i < forumThreads.size(); i++) {
            serializableForumThreads[i] = new SerializableForumThread(forumThreads.get(i).getTitle(), forumThreads.get(i).getID());
        }

        return serializableForumThreads;
    }
}

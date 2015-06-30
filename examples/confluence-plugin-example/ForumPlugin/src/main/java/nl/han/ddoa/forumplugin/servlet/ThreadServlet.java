package nl.han.ddoa.forumplugin.servlet;

import nl.han.ddoa.forumplugin.entities.ForumThread;
import nl.han.ddoa.forumplugin.entities.ForumThreadRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Description for the class ThreadServlet:
 * <p/>
 * Provides a good old Servlet interface to the ForumThreadRepository. It's default location is: /confluence/plugins/servlet/forum/list
 * <p/>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
public class ThreadServlet extends HttpServlet {
    private final ForumThreadRepository forumThreadRepository;


    public ThreadServlet(ForumThreadRepository forumThreadRepository) {
        this.forumThreadRepository = checkNotNull(forumThreadRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final PrintWriter w = res.getWriter();
        w.write("<h1>Threads</h1>");

        w.write("<form method=\"post\">");
        w.write("<input type=\"text\" name=\"title\" size=\"25\"/>");
        w.write("&nbsp;&nbsp;");
        w.write("<input type=\"submit\" name=\"submit\" value=\"Create New Thread\"/>");
        w.write("</form>");

        w.write("<ol>");

        for (ForumThread thread : forumThreadRepository.all()) {
            w.printf("<li>%s</li>", thread.getTitle());
        }

        w.write("</ol>");
        w.write("<script language='javascript'>document.forms[0].elements[0].focus();</script>");

        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        forumThreadRepository.add(req.getParameter("title"));
        res.sendRedirect(req.getContextPath() + "/plugins/servlet/forum/list");
    }
}
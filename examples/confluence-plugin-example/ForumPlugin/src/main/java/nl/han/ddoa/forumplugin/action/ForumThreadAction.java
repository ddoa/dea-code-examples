package nl.han.ddoa.forumplugin.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;

/**
 * Description for the class ForumThreadAction:
 * <p/>
 * We need a default XWORK Action for the forum-rest.vm.
 * <p/>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */

public class ForumThreadAction extends ConfluenceActionSupport
{
    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
}

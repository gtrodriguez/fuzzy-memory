package com.atlassian.cst.api;

import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ConnectXPanel extends AbstractJiraContextProvider
{
    private static final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;

    @Override
    public Map getContextMap(ApplicationUser user, JiraHelper jiraHelper) {
        Map contextMap = new HashMap();
        Issue currentIssue = (Issue) jiraHelper.getContextParams().get("issue");
        Timestamp dueDate = currentIssue.getDueDate();
        if (dueDate != null)
        {
            int currentTimeInDays = (int) (System.currentTimeMillis() / MILLIS_IN_DAY);
            int dueDateTimeInDays = (int) (dueDate.getTime() / MILLIS_IN_DAY);
            int daysAwayFromDueDateCalc = dueDateTimeInDays - currentTimeInDays + 1;
            contextMap.put("daysAwayFromDueDate", daysAwayFromDueDateCalc);
        }
        return contextMap;
    }
}
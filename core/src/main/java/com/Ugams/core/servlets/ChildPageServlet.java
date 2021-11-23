package com.Ugams.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;

import org.osgi.service.component.annotations.Component;


import javax.servlet.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "ugams/components/page"
)
public class ChildPageServlet  extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws  IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ugams/us/en");
        ArrayList pagesList = new ArrayList();
        Iterator<Page> childPages = page.listChildren();
        while (childPages.hasNext()) {
            Page childPage = childPages.next();
            String pageName;
            pageName =childPage.getTitle();
            pagesList.add(pageName);
        }

        response.setContentType("text/html");
        response.getWriter().print(pagesList);
    }
}

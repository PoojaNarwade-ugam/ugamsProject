package com.Ugams.core.Services.impl;

import com.Ugams.core.Services.ServiceUser;
import com.Ugams.core.utils.ResolverUtils;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;


import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import com.day.cq.search.result.Hit;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ServiceUserImpl implements ServiceUser {
    @SlingObject
    ResourceResolver resourceResolver;
    @OSGiService
    ResourceResolverFactory resourceResolverFactory;
    @Inject
    private QueryBuilder queryBuilder;
    @Override
    public List<String> getUsernames(){
        final Logger LOG = LoggerFactory.getLogger(ServiceUserImpl.class);
        List<String> usernames = new ArrayList<>();
        Map<String,String> userMap = new HashMap<>();
        userMap.put("path","/home/users");
        userMap.put("property","jcr:primaryType");
        userMap.put("p.hits","selective");
        userMap.put("p.properties","rep:principalName");
        try(ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)){
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = (Query) queryBuilder.createQuery(PredicateGroup.create(userMap),session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for(Hit hit : Hits)
            {
                Resource hitresults = hit.getResource();
                usernames.add(hitresults.getName());
                LOG.info("hitresults{}",hitresults.getName());
            }
        }
        catch (LoginException | RepositoryException exception){
            LOG.error("Service user ERROR",exception.getMessage());

        }
        return usernames;
    }
}

package com.Ugams.core.models.Impl;

import com.Ugams.core.models.HomeAbout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions ="json",selector = "homeabout",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
        })
@JsonRootName("Home-About")
public class HomeAboutImpl implements HomeAbout{

    final protected static String RESOURCE_TYPE="ugams/components/content/home-about";

    @Inject
    String title;

    @Inject
    String desc;

    @Inject
    String heading;

    @Inject
    String buttonTitle;

    @Inject
    String img;

    @Inject
    String path;

    @Override
    public String getHomeAboutTitle() {
        return title;
    }

    @Override
    public String getHomeAboutHeading() {
        return heading;
    }

    @Override
    public String getHomeAboutDescription() {
        return desc;
    }

    @Override
    public String getHomeAboutButtonTitle() {
        return buttonTitle;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public String getPathValue() {
        return path;
    }

    @JsonProperty(value = "Sample Test")
    public String Homeaboutsampletext() {return "Sample Text for custom exporter";}
}

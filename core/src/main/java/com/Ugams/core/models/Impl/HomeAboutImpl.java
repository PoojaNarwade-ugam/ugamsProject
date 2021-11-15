package com.Ugams.core.models.Impl;

import com.Ugams.core.models.HomeAbout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporters({
        @Exporter(name = "jackson", extensions = "json", selector = "homeabout"),
        @Exporter(name = "homeabout", extensions = "xml", selector = "homeabout")
})

@JsonRootName("Home-About")
@XmlRootElement(name = "HomeAbout")
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
    @XmlElement(name = "Title")
    @JsonProperty(value="Title")
    public String getHomeAboutTitle() {
        return title;
    }

    @Override
    @XmlElement(name = "Heading")
    @JsonProperty(value="Heading")
    public String getHomeAboutHeading() {
        return heading;
    }

    @Override
    @XmlElement(name = "Description")
    @JsonProperty(value="Description")
    public String getHomeAboutDescription() {
        return desc;
    }

    @Override
    @XmlElement(name = "ButtonTitle")
    @JsonProperty(value="ButtonTitle")
    public String getHomeAboutButtonTitle() {
        return buttonTitle;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    @XmlElement(name = "Pathvalue")
    @JsonProperty(value="Pathvalue")
    public String getPathValue() {
        return path;
    }

    @JsonProperty(value = "Sample Test")
    @XmlElement(name = "Sample Test")
    public String Homeaboutsampletext() {return "Sample Text for custom exporter";}
}

package com.Ugams.core.models.Impl;



import com.Ugams.core.models.Testimonial;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporters({
        @Exporter(name = "jackson", extensions = "json", selector = "testimonialjson",
        options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value="true"),
                  }),
        @Exporter(name = "testixml", extensions = "xml", selector = "testimonialxml")
})
@JsonRootName("Testimonial")
@XmlRootElement(name = "Testimonial")
public class TestimonialImpl implements Testimonial{

    final protected static String RESOURCE_TYPE="ugams/components/content/testimonial";

    @Inject
    String name;

    @Inject
    String desc;

    @Inject
    String desg;


    @Override
    @XmlElement(name = "Name")
    @JsonProperty(value="Name")
    public String getTestimonialName() {
        return name;
    }

    @Override
    @XmlElement(name = "Description")
    @JsonProperty(value="Description")
    public String getTestimonialDescription() {
        return desc;
    }

    @Override
    @XmlElement(name = "Designation")
    @JsonProperty(value="Designation")
    public String getTestimonialDesignation() {
        return desg;
    }

    @JsonProperty(value = "Sample Test")
    @XmlElement(name = "Sample Test")
    public String Testimonialsampletext(){return "Sample Text for custom exporter";}
}

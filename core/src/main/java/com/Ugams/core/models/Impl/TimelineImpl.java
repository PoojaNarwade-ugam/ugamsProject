package com.Ugams.core.models.Impl;


import com.Ugams.core.models.Timeline;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = Timeline.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporters({
        @Exporter(name = "jackson", extensions = "json", selector = "timelinjson"),
        @Exporter(name = "timeline", extensions = "xml", selector = "timelinxml")
})

@JsonRootName("Timeline")
@XmlRootElement(name = "Timeline")
public class TimelineImpl implements Timeline{

    final protected static String RESOURCE_TYPE="ugams/components/content/timeline";


    @ChildResource
    Resource timeline;

    @Override
    @XmlElement(name = "Timeline Details for various time")
    @JsonProperty(value = "Timeline Details for various time")
    public List<Map<String, String>> getTimelineDetails() {
        List<Map<String, String>> timelineMap = new ArrayList<>();
        if (timeline != null) {
            for (Resource fact : timeline.getChildren()) {
                Map<String, String> tMap = new HashMap<>();
                tMap.put("title", fact.getValueMap().get("title", String.class));
                tMap.put("text1", fact.getValueMap().get("text1", String.class));
                tMap.put("text2", fact.getValueMap().get("text2", String.class));
                timelineMap.add(tMap);
            }
        }
        return timelineMap;
    }
    @JsonProperty(value = "Sample Test")
    @XmlElement(name = "Sample Test")
    public String Timelinesampletext(){return "sample Text for custom exporter";}
}

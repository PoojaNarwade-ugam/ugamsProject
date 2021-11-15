package com.Ugams.core.models.Impl;

import com.Ugams.core.models.BannerArea;
import com.Ugams.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class})
class TimelineImplTest {
    private final AemContext aemContext=new AemContext();
    Timeline timeline;

    @BeforeEach
    void setUp() throws Exception {
        aemContext.load().json("/Timeline.json","/content");
    }

    @Test
    void getTimelineDetails() {
        Resource resource=aemContext.currentResource("/content/timeline");
        timeline= resource.adaptTo(Timeline.class);
        List<Map<String,String>> TimelineText=new ArrayList<>();
        TimelineText=timeline.getTimelineDetails();
        assertNotNull(TimelineText);
    }

}
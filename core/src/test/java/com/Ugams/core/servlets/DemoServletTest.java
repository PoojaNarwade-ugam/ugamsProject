package com.Ugams.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class DemoServletTest {

    private  DemoServlet demoServlet = new DemoServlet();
    @BeforeEach
    void setUp() throws Exception{

    }


    @Test
     void doGet(AemContext aemContext) throws  IOException {
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();


        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("firstvalue", 3);
        parameters.put("secondvalue", 4);
        request.setParameterMap(parameters);
        demoServlet.doGet(request,response);

        assertEquals(7 , Integer.parseInt(response.getOutputAsString()));
    }
}

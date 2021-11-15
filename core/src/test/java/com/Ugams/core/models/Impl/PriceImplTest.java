package com.Ugams.core.models.Impl;

import com.Ugams.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class PriceImplTest {
    private final AemContext aemContext=new AemContext();
    Price price;

    @BeforeEach
    void setUp()  {

        aemContext.load().json("/Price.json","/content");

    }

    @Test
    void getPriceType() {
        Resource resource = aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        assertEquals("Economy",price.getPriceType());
    }

    @Test
    void getPriceTitle() {
        Resource resource = aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        final String expected="For the individuals";
        String actual=price.getPriceTitle();
        assertEquals(expected,actual);

    }

    @Test
    void getPriceNumber() {
        Resource resource =aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        assertEquals("01",price.getPriceNumber());

    }

    @Test
    void getPriceText1() {
        Resource resource= aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        final String expected="Secure Online Transfer";
        String actual=price.getPriceText1();
        assertEquals(expected,actual);
    }

    @Test
    void getPriceText2() {
        Resource resource= aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        final String expected="Unlimited Styles for interface";
        String actual=price.getPriceText2();
        assertEquals(expected,actual);
    }

    @Test
    void getPriceText3() {
        Resource resource= aemContext.currentResource("/content/price");
        price=resource.adaptTo(Price.class);
        final String expected="Unlimited Styles for interface";
        String actual=price.getPriceText2();
        assertEquals(expected,actual);
    }
}
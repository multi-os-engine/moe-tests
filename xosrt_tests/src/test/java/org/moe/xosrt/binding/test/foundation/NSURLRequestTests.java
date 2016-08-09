package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.NSURL;
import ios.foundation.NSURLRequest;

import org.junit.Test;

public class NSURLRequestTests {

    @Test
    public void testURL1() {
        NSURL theURL = NSURL.URLWithString("http://www.google.com.ar");
        NSURLRequest urlRequest = NSURLRequest.requestWithURL(theURL);
        assertTrue(urlRequest.URL() != null) ;
    }

    @Test
    public void testRequestWithURL1() {
        NSURL theURL = NSURL.URLWithString("http://www.google.com.ar");
        NSURLRequest urlRequest = NSURLRequest.requestWithURL(theURL);
        assertTrue(urlRequest.URL() == theURL) ;
    }

    @Test
    public void testInitWithURL1() {
        NSURL theURL = NSURL.URLWithString("http://www.google.com.ar");
        NSURLRequest urlRequest1 = (NSURLRequest)NSURLRequest.alloc().initWithURL(theURL);
        assertTrue(urlRequest1.URL() == theURL) ;
    }

}

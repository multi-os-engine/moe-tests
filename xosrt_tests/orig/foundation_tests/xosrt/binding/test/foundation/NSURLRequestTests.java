package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSURLRequestTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testURL1() {
        NSURL theURL = NSURL.URLWithString(NSString.fromJavaString("http://www.google.com.ar"));
        NSURLRequest urlRequest = NSURLRequest.requestWithURL(theURL);
        assertTrue(urlRequest.getURL() != null) ;
    }

    @Test
    public void testRequestWithURL1() {
        NSURL theURL = NSURL.URLWithString(NSString.fromJavaString("http://www.google.com.ar"));
        NSURLRequest urlRequest = NSURLRequest.requestWithURL(theURL);
        assertTrue(urlRequest.getURL() == theURL) ;
    }

    @Test
    public void testInitWithURL1() {
        NSURL theURL = NSURL.URLWithString(NSString.fromJavaString("http://www.google.com.ar"));
        NSURLRequest urlRequest1 = (NSURLRequest)NSURLRequest.alloc().initWithURL(theURL);
        assertTrue(urlRequest1.getURL() == theURL) ;
    }

}

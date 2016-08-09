package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.NSURL;

import org.junit.Test;

public class NSURLTests {

    //Should be edited
    @Test
    public void simpleStaticCreationTest() {
        NSURL testUrl = NSURL.URLWithString("some/url");
        assertNotNull(testUrl);
    }


    @Test
    public void initWithSchemeHostAndPathObjectNotNullParametersTest() {

        NSURL initUrl = NSURL.alloc().initWithSchemeHostPath("www.example.com", "http", "/index.html");

        String actualHost = initUrl.host().toString();
        assertEquals( "http", actualHost);
        assertEquals( "www.example.com", initUrl.scheme().toString());

    }

    @Test
    public void URLWithStringRelativeToURLNotNullTest() {

        NSURL testBaseUrl = NSURL.URLWithString("some/url");
        NSURL testUrl = NSURL.URLWithStringRelativeToURL("src.java", testBaseUrl);

        assertNotNull(testUrl);
    }

    @Test
    public void URLWithStringRelativeToURLBaseUrlNotNullTest() {

        NSURL testBaseUrl = NSURL.URLWithString("some/url");
        NSURL testUrl = NSURL.URLWithStringRelativeToURL("src.java", testBaseUrl);

        assertNotNull(testUrl.baseURL());
    }

    @Test
    public void URLWithStringRelativeToURLCheckBaseUrlTest() {

        NSURL testBaseUrl = NSURL.URLWithString("some/url");
        NSURL testUrl = NSURL.URLWithStringRelativeToURL("src.java", testBaseUrl);

        assertEquals(testBaseUrl, testUrl.baseURL());
    }

    @Test
    public void absoluteUrlNotNullTest() {
        NSURL testUrl = NSURL.URLWithString("some/url");

        assertNotNull(testUrl.absoluteURL());
    }

    @Test
    public void absoluteUrlEqualsReceiverTest() {

        NSURL expectedUrl = NSURL.URLWithString("some/url");
        NSURL actualUrl = expectedUrl.absoluteURL();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void absoluteUrlEqualsAbsoluteUrlsTest() {

        NSURL expectedUrl = NSURL.URLWithString("some/url");
        NSURL actualUrl = expectedUrl.absoluteURL();

        String expectedAbsoluteString = expectedUrl.absoluteString().toString();
        String actualAbsoluteString = actualUrl.absoluteString().toString();

        assertEquals(expectedAbsoluteString, actualAbsoluteString);
    }

    @Test
    public void initWithStringNSURLNotNullTest() {

        NSURL initUrl = NSURL.alloc().initWithString("User/folder/");

        assertNotNull(initUrl);
    }

    @Test
    public void initWithStringRelativeToUrlNSURLNotNullTest() {

        NSURL baseUrl = NSURL.alloc();
        baseUrl = baseUrl.initWithStringRelativeToURL("src.java", baseUrl);

        assertNotNull(baseUrl);
    }


    @Test
    public void fileURLWithPathIsDirectoryNSURLNotNullTest() {

        boolean isDirectory = true;
        NSURL testUrl = NSURL.fileURLWithPathIsDirectory("some/url/folder", isDirectory);

        assertNotNull(testUrl);
    }

    @Test
    public void isFileURLReturnsTrueTest() {

        boolean isDirectory = false;
        NSURL testUrl = NSURL.fileURLWithPathIsDirectory("some/url/folder.txt", isDirectory);

        assertTrue(testUrl.isFileURL());
    }


    @Test
    public void URLWithStringPathSetUpTest() {
        String expectedPath = "/index.html";

        NSURL testUrl = NSURL.URLWithString("http://www.example.com/index.html");
        String actualPath = testUrl.path().toString();

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void URLWithStringHostSetUpTest() {
        String expectedHost = "www.example.com";

        NSURL testUrl = NSURL.URLWithString("http://www.example.com/index.html");
        String actualHost = testUrl.host().toString();

        assertEquals(expectedHost, actualHost);
    }

    @Test
    public void URLWithStringSchemeSetUpTest() {
        String expectedScheme = "http";

        NSURL testUrl = NSURL.URLWithString("http://www.example.com/index.html");
        String actualScheme = testUrl.scheme().toString();

        assertEquals(expectedScheme, actualScheme);
    }

    @Test
    public void fileURLWithPathSetUpTest() {
        String expectedPath = "/User/Folder/index.html";

        NSURL testUrl = NSURL.fileURLWithPath(expectedPath);
        String actualPath = testUrl.path().toString();

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testUser1() {
        NSURL theURL0 = NSURL.URLWithString("https://user1:pass123@www.mooral.com.ar:123/search?query=Hello");
        assertEquals ( "user1", theURL0.user() );
    }

    @Test
    public void testPassword1() {
        NSURL theURL1 = NSURL.URLWithString("https://user1:pass123@www.mooral.com.ar:123/search?query=Hello");
        String tempString1 = theURL1.password();
        assertTrue (tempString1.equals("pass123"));
    }

    @Test
    public void testPath1() {
        NSURL theURL2 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123/search?query=Hello");
        String tempString2 = theURL2.path();
        assertTrue (tempString2.equals("/search"));
    }

    @Test
    public void testPath2() {
        NSURL theURL3 = NSURL.fileURLWithPath("afile.txt");
        String tempString3 = theURL3.path();
        assertTrue (tempString3.endsWith("afile.txt"));
    }

    @Test
    public void testPath3() {
        NSURL theURL4 = NSURL.fileURLWithPathIsDirectory("Debug", true);
        String tempString4 = theURL4.path();
        assertTrue (tempString4.endsWith("Debug"));
    }

    @Test
    public void testHost1() {
        NSURL aURL0 = NSURL.URLWithString("https://user:pass@www.mooral.com.ar:123");
        assertEquals ( "www.mooral.com.ar", aURL0.host() );
    }

    @Test
    public void testPort1() {
        NSURL aURL1 = NSURL.URLWithString("https://user:pass@www.mooral.com.ar:123/search?query=Hello");
        assertTrue (aURL1.port().stringValue().equals("123"));
    }

    @Test
    public void testQuery1() {
        NSURL aURL2 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123");
        NSURL aURL3 = NSURL.URLWithStringRelativeToURL("/search?query=Hello2", aURL2);
        String queryString0 = aURL3.query();
        assertTrue (queryString0.equals("query=Hello2"));
    }

    @Test
    public void testFileURLWithPath1() {
        NSURL theURL5 = NSURL.fileURLWithPath("afile.txt");
        String absoluteString0 = theURL5.absoluteString();
        assertTrue (absoluteString0 != null);
    }

    @Test
    public void testFileURLWithPath_isDirectory1() {
        NSURL theURL6 = NSURL.fileURLWithPathIsDirectory("Debug", true);
        String absoluteString1 = theURL6.absoluteString();
        assertTrue (absoluteString1 != null && absoluteString1.length() > 0) ;
    }

    @Test
    public void testIsEqual1() {
        NSURL url0 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123");
        NSURL url1 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123");
        NSURL url2 = NSURL.URLWithString("http://www.menu.com/default.html");
        NSURL url3 = null;
        assertTrue (url0.isEqual(url0) && url1.isEqual(url1) && url1.isEqual(url0)
                && url2.isEqual(url2) && !url1.isEqual(url2) && !url0.isEqual(url3)
                && !url0.isEqual(null)
        );
    }

    @Test
    public void testURLWithString1() {
        NSURL url4 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123/");
        assertTrue (url4.absoluteString().equals("https://user(pass@www.mooral.com.ar(123/"));
    }

    @Test
    public void testInitWithString1() {
        NSURL theURL7  = NSURL.alloc().initWithString("https://user(pass@www.mooral.com.ar(123/");
        String tempString7 = theURL7.absoluteString();
        assertTrue(tempString7.equals("https://user(pass@www.mooral.com.ar(123/"));
    }

    @Test
    public void testBaseURL1() {
        NSURL url6 = NSURL.URLWithString("https://user(pass@www.mooral.com.ar(123/");
        NSURL url7 = NSURL.URLWithStringRelativeToURL("search?query=Hello2", url6);
        String aString0 = url7.baseURL().absoluteString();
        assertTrue (aString0.equals("https://user(pass@www.mooral.com.ar(123/"));
    }

}

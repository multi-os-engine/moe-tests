package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSURLTests {

    static {
        System.loadLibrary("Mac");
    }

    //Should be edited
    @Test
    public void simpleStaticCreationTest() {
        NSString targetString = NSString.fromJavaString("some/url");

        NSURL testUrl = NSURL.URLWithString(targetString);
        assertNotNull(testUrl);
    }


    @Test
    public void initWithSchemeHostAndPathObjectNotNullParametersTest() {

        NSString host = NSString.fromJavaString("www.example.com");
        NSString scheme = NSString.fromJavaString("http");
        NSString path = NSString.fromJavaString("/index.html");

        NSURL initUrl = NSURL.alloc().initWithSchemeHostPath(scheme, host, path);

        String actualHost = initUrl.getHost().toString();
        assertEquals(host.toString(), actualHost);
        assertEquals(scheme.toString(), initUrl.getScheme().toString());

    }

    @Test
    public void URLWithStringRelativeToURLNotNullTest() {
        NSString baseUrlString = NSString.fromJavaString("some/url");
        NSString testUrlString = NSString.fromJavaString("src.java");


        NSURL testBaseUrl = NSURL.URLWithString(baseUrlString);
        NSURL testUrl = NSURL.URLWithStringRelativeToURL(testUrlString, testBaseUrl);

        assertNotNull(testUrl);
    }

    @Test
    public void URLWithStringRelativeToURLBaseUrlNotNullTest() {
        NSString baseUrlString = NSString.fromJavaString("some/url");
        NSString testUrlString = NSString.fromJavaString("src.java");


        NSURL testBaseUrl = NSURL.URLWithString(baseUrlString);
        NSURL testUrl = NSURL.URLWithStringRelativeToURL(testUrlString, testBaseUrl);

        assertNotNull(testUrl.getBaseURL());
    }

    @Test
    public void URLWithStringRelativeToURLCheckBaseUrlTest() {
        NSString baseUrlString = NSString.fromJavaString("some/url");
        NSString testUrlString = NSString.fromJavaString("src.java");

        NSURL testBaseUrl = NSURL.URLWithString(baseUrlString);
        NSURL testUrl = NSURL.URLWithStringRelativeToURL(testUrlString, testBaseUrl);

        assertEquals(testBaseUrl, testUrl.getBaseURL());
    }

    @Test
    public void getAbsoluteUrlNotNullTest() {
        NSString testUrlString = NSString.fromJavaString("some/url");
        NSURL testUrl = NSURL.URLWithString(testUrlString);

        assertNotNull(testUrl.getAbsoluteURL());
    }

    @Test
    public void getAbsoluteUrlEqualsReceiverTest() {
        NSString testUrlString = NSString.fromJavaString("some/url");

        NSURL expectedUrl = NSURL.URLWithString(testUrlString);
        NSURL actualUrl = expectedUrl.getAbsoluteURL();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void getAbsoluteUrlEqualsAbsoluteUrlsTest() {
        NSString testUrlString = NSString.fromJavaString("some/url");

        NSURL expectedUrl = NSURL.URLWithString(testUrlString);
        NSURL actualUrl = expectedUrl.getAbsoluteURL();

        String expectedAbsoluteString = expectedUrl.getAbsoluteString().toString();
        String actualAbsoluteString = actualUrl.getAbsoluteString().toString();

        assertEquals(expectedAbsoluteString, actualAbsoluteString);
    }

    @Test
    public void initWithStringNSURLNotNullTest() {
        NSString initUrlString = NSString.fromJavaString("User/folder/");

        NSURL initUrl = NSURL.alloc().initWithString(initUrlString);

        assertNotNull(initUrl);
    }

    @Test
    public void initWithStringRelativeToUrlNSURLNotNullTest() {
        NSString baseString = NSString.fromJavaString("some/url");
        NSString fileString = NSString.fromJavaString("src.java");

        NSURL baseUrl = NSURL.alloc();
        baseUrl = baseUrl.initWithStringRelativeToURL(fileString, baseUrl);

        assertNotNull(baseUrl);
    }


    @Test
    public void fileURLWithPathIsDirectoryNSURLNotNullTest() {
        NSString testString = NSString.fromJavaString("some/url/folder");

        boolean isDirectory = true;
        NSURL testUrl = NSURL.fileURLWithPathIsDirectory(testString, isDirectory);

        assertNotNull(testUrl);
    }

    @Test
    public void isFileURLReturnsTrueTest() {
        NSString testString = NSString.fromJavaString("some/url/folder.txt");

        boolean isDirectory = false;
        NSURL testUrl = NSURL.fileURLWithPathIsDirectory(testString, isDirectory);

        assertTrue(testUrl.isFileURL());
    }


    @Test
    public void URLWithStringPathSetUpTest() {
        NSString targetString = NSString.fromJavaString("http(//www.example.com/index.html");
        String expectedPath = "/index.html";

        NSURL testUrl = NSURL.URLWithString(targetString);
        String actualPath = testUrl.getPath().toString();

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void URLWithStringHostSetUpTest() {
        NSString targetString = NSString.fromJavaString("http(//www.example.com/index.html");
        String expectedHost = "www.example.com";

        NSURL testUrl = NSURL.URLWithString(targetString);
        String actualHost = testUrl.getHost().toString();

        assertEquals(expectedHost, actualHost);
    }

    @Test
    public void URLWithStringSchemeSetUpTest() {
        NSString targetString = NSString.fromJavaString("http(//www.example.com/index.html");
        String expectedScheme = "http";

        NSURL testUrl = NSURL.URLWithString(targetString);
        String actualScheme = testUrl.getScheme().toString();

        assertEquals(expectedScheme, actualScheme);
    }

    @Test
    public void fileURLWithPathSetUpTest() {
        NSString targetString = NSString.fromJavaString("/User/Folder/index.html");
        String expectedPath = targetString.toString();

        NSURL testUrl = NSURL.fileURLWithPath(targetString);
        String actualPath = testUrl.getPath().toString();

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testUser1() {
        NSURL theURL0 = NSURL.URLWithString(
                NSString.fromJavaString("https(//user1(pass123@www.mooral.com.ar(123/search?query=Hello"));
        NSString tempString0 = theURL0.getUser();
        assertTrue (tempString0.isEqualToString(NSString.fromJavaString("user1")));
    }

    @Test
    public void testPassword1() {
        NSURL theURL1 = NSURL.URLWithString(NSString.fromJavaString(
                "https(//user1(pass123@www.mooral.com.ar(123/search?query=Hello"));
        NSString tempString1 = theURL1.getPassword();
        assertTrue (tempString1.isEqualToString(NSString.fromJavaString("pass123")));
    }

    @Test
    public void testPath1() {
        NSURL theURL2 = NSURL.URLWithString(
                NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/search?query=Hello"));
        NSString tempString2 = theURL2.getPath();
        assertTrue (tempString2.isEqualToString(NSString.fromJavaString("/search")));
    }

    @Test
    public void testPath2() {
        NSURL theURL3 = NSURL.fileURLWithPath(NSString.fromJavaString("afile.txt"));
        NSString tempString3 = theURL3.getPath();
        assertTrue (tempString3.hasSuffix(NSString.fromJavaString("afile.txt")));
    }

    @Test
    public void testPath3() {
        NSURL theURL4 = NSURL.fileURLWithPathIsDirectory(NSString.fromJavaString("Debug"), true);
        NSString tempString4 = theURL4.getPath();
        assertTrue (tempString4.hasSuffix(NSString.fromJavaString("Debug"))) ;
    }

    @Test
    public void testHost1() {
        NSURL aURL0 = NSURL.URLWithString(
                NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123"));
        assertTrue (aURL0.getHost().isEqualToString(NSString.fromJavaString("www.mooral.com.ar")));
    }

    @Test
    public void testPort1() {
        NSURL aURL1 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/search?query=Hello"));
        assertTrue (aURL1.getPort().getStringValue().isEqualToString(NSString.fromJavaString("123")));
    }

    @Test
    public void testQuery1() {
        NSURL aURL2 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123"));
        NSURL aURL3 = NSURL.URLWithStringRelativeToURL(NSString.fromJavaString("/search?query=Hello2"), aURL2);
        NSString queryString0 = aURL3.getQuery();
        assertTrue (queryString0.isEqualToString(NSString.fromJavaString("query=Hello2")));
    }

    @Test
    public void testFileURLWithPath1() {
        NSURL theURL5 = NSURL.fileURLWithPath(NSString.fromJavaString("afile.txt"));
        NSString absoluteString0 = theURL5.getAbsoluteString();
        assertTrue (absoluteString0 != null);
    }

    @Test
    public void testFileURLWithPath_isDirectory1() {
        NSURL theURL6 = NSURL.fileURLWithPathIsDirectory(NSString.fromJavaString("Debug"), true);
        NSString absoluteString1 = theURL6.getAbsoluteString();
        assertTrue (absoluteString1 != null && absoluteString1.getLength() > 0) ;
    }

    @Test
    public void testIsEqual1() {
        NSURL url0 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123"));
        NSURL url1 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123"));
        NSURL url2 = NSURL.URLWithString(NSString.fromJavaString("http(//www.menu.com/default.html"));
        NSURL url3 = null;
        assertTrue (url0.isEqual(url0) && url1.isEqual(url1) && url1.isEqual(url0)
                && url2.isEqual(url2) && !url1.isEqual(url2) && !url0.isEqual(url3)
                && !url0.isEqual(null)
        );
    }

    @Test
    public void testURLWithString1() {
        NSURL url4 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/"));
        assertTrue (url4.getAbsoluteString().isEqualToString(NSString.fromJavaString(
                "https(//user(pass@www.mooral.com.ar(123/")));
    }

    @Test
    public void testInitWithString1() {
        NSURL theURL7  = NSURL.alloc().initWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/"));
        NSString tempString7 = theURL7.getAbsoluteString();
        assertTrue(tempString7.isEqualToString(
                NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/")));
    }

    @Test
    public void testBaseURL1() {
        NSURL url6 = NSURL.URLWithString(NSString.fromJavaString("https(//user(pass@www.mooral.com.ar(123/"));
        NSURL url7 = NSURL.URLWithStringRelativeToURL(NSString.fromJavaString("search?query=Hello2"), url6);
        NSString aString0 = url7.getBaseURL().getAbsoluteString();
        assertTrue (aString0.isEqualToString(NSString.fromJavaString(
                "https(//user(pass@www.mooral.com.ar(123/")));
    }

}

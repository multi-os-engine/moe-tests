package xosrt.binding.test.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSURL;
import org.junit.Assert;
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

        NSURL initUrl = NSURL.alloc().initWithSchemeHostAndPath(scheme, host, path);

        String actualHost = initUrl.getHost().toString();
        Assert.assertEquals(host.toString(), actualHost);
        Assert.assertEquals(scheme.toString(), initUrl.getScheme().toString());

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
        NSString targetString = NSString.fromJavaString("http://www.example.com/index.html");
        String expectedPath = "/index.html";

        NSURL testUrl = NSURL.URLWithString(targetString);
        String actualPath = testUrl.getPath().toString();

        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void URLWithStringHostSetUpTest() {
        NSString targetString = NSString.fromJavaString("http://www.example.com/index.html");
        String expectedHost = "www.example.com";

        NSURL testUrl = NSURL.URLWithString(targetString);
        String actualHost = testUrl.getHost().toString();

        assertEquals(expectedHost, actualHost);
    }

    @Test
    public void URLWithStringSchemeSetUpTest() {
        NSString targetString = NSString.fromJavaString("http://www.example.com/index.html");
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

}

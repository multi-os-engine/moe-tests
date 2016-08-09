package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSCachedURLResponse;
import ios.foundation.NSInputStream;
import ios.foundation.NSMutableData;
import ios.foundation.NSMutableURLRequest;
import ios.NSObject;
import ios.foundation.NSString;
import ios.foundation.NSURL;
import ios.foundation.NSURLAuthenticationChallenge;
import ios.foundation.NSURLConnection;
import ios.foundation.NSURLProtectionSpace;
import ios.foundation.NSURLRequest;
import ios.foundation.NSURLResponse;
import ios.foundation.enums.NSURLRequestCachePolicy;
import ios.foundation.protocol.NSURLConnectionDataDelegate;

public class ThreadTestTarget extends NSObject implements NSURLConnectionDataDelegate {

    public boolean passed = false;
    public boolean finish = false;
    private NSMutableData receivedData = null;
    NSURLConnection theConnection = null;

    static {
        NatJ.register();
    }

    protected ThreadTestTarget(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native ThreadTestTarget alloc();

    @Selector("init")
    public native ThreadTestTarget init();

    public void reset() {
        passed = false;
        finish = false;
        receivedData = null;
    }

    @Selector("doHttp")
    public void doHttp(NSObject obj) {
        passed = true;
    }

    public void runURLConn() {
        reset();
        NSURLRequest theRequest = NSURLRequest.requestWithURLCachePolicyTimeoutInterval(
                NSURL.URLWithString("http://www.google.com/"),
                NSURLRequestCachePolicy.ReturnCacheDataElseLoad,
                60.0);
        theConnection = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
        receivedData = (NSMutableData)NSMutableData.data();
    }

    public void runURLConn2() {
        reset();
        receivedData = (NSMutableData)NSMutableData.data();
        NSURLRequest theRequest = NSURLRequest.requestWithURL(
                NSURL.URLWithString("http://www.mooral.com.ar/"));

        theConnection = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
    }

    public void runURLConn3() {
        reset();
        receivedData = (NSMutableData)NSMutableData.data();
        NSMutableURLRequest theRequest = (NSMutableURLRequest)NSURLRequest.requestWithURL(
                NSURL.URLWithString("http://www.moe.com/"));
        theRequest.setHTTPMethod("POST");
        theRequest.setValueForHTTPHeaderField("application/x-www-form-urlencoded", "Content-Type");

        theConnection = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
    }

    @Override
    @Selector("connectionDidFinishLoading:")
    public void connectionDidFinishLoading(ios.foundation.NSURLConnection connection) {
        passed = receivedData != null;
        finish = true;
    }

    @Override
    public boolean connectionCanAuthenticateAgainstProtectionSpace(NSURLConnection nsurlConnection, NSURLProtectionSpace nsurlProtectionSpace) {
        return false;
    }

    @Override
    public void connectionDidCancelAuthenticationChallenge(NSURLConnection nsurlConnection, NSURLAuthenticationChallenge nsurlAuthenticationChallenge) {

    }

    @Override
    @Selector("connection:didFailWithError:")
    public void connectionDidFailWithError(ios.foundation.NSURLConnection connection,
                                           ios.foundation.NSError error) {
        theConnection.cancel();
        finish = true;
        passed = false;
    }

    @Override
    public void connectionDidReceiveAuthenticationChallenge(NSURLConnection nsurlConnection, NSURLAuthenticationChallenge nsurlAuthenticationChallenge) {

    }

    @Override
    public void connectionWillSendRequestForAuthenticationChallenge(NSURLConnection nsurlConnection, NSURLAuthenticationChallenge nsurlAuthenticationChallenge) {

    }

    @Override
    public boolean connectionShouldUseCredentialStorage(NSURLConnection nsurlConnection) {
        return false;
    }

    @Override
    @Selector("connection:didReceiveData:")
    public void connectionDidReceiveData(ios.foundation.NSURLConnection connection,
                                         ios.foundation.NSData data) {
        receivedData.appendData(data);
    }

    @Override
    public void connectionDidReceiveResponse(NSURLConnection nsurlConnection, NSURLResponse nsurlResponse) {

    }

    @Override
    public void connectionDidSendBodyDataTotalBytesWrittenTotalBytesExpectedToWrite(NSURLConnection nsurlConnection, @NInt long l, @NInt long l2, @NInt long l3) {

    }

    @Override
    public NSInputStream connectionNeedNewBodyStream(NSURLConnection nsurlConnection, NSURLRequest nsurlRequest) {
        return null;
    }

    @Override
    public NSCachedURLResponse connectionWillCacheResponse(NSURLConnection nsurlConnection, NSCachedURLResponse nsCachedURLResponse) {
        return null;
    }

    @Override
    public NSURLRequest connectionWillSendRequestRedirectResponse(NSURLConnection nsurlConnection, NSURLRequest nsurlRequest, NSURLResponse nsurlResponse) {
        return null;
    }


}

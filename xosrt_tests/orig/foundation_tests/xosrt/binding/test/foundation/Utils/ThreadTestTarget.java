package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSMutableData;
import xosrt.binding.foundation.NSMutableURLRequest;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSURL;
import xosrt.binding.foundation.NSURLConnection;
import xosrt.binding.foundation.NSURLConnectionDataDelegate;
import xosrt.binding.foundation.NSURLConnectionDataDelegateAdapter;
import xosrt.binding.foundation.NSURLRequest;
import xosrt.binding.foundation.NSURLRequestCachePolicy;

public class ThreadTestTarget extends NSURLConnectionDataDelegateAdapter {

    public boolean passed = false;
    public boolean finish = false;
    private NSMutableData receivedData = null;
    NSURLConnection theConnaction = null;

    static {
        Registrator.registerClassObject(ThreadTestTarget.class);
    }

    @NativeSelector("alloc")
    public static native ThreadTestTarget alloc();

    @NativeSelector("init")
    public native ThreadTestTarget init();

    public void reset() {
        passed = false;
        finish = false;
        receivedData = null;
    }

    public void doHttp(NSObject obj) {
        passed = true;
    }

    public void runURLConn() {
        reset();
        NSURLRequest theRequest = NSURLRequest.requestWithURLCachePolicyTimeoutInterval(
                NSURL.URLWithString(NSString.fromJavaString("http://www.google.com/")),
                NSURLRequestCachePolicy.ReturnCacheDataElseLoad,
                60.0);
        theConnaction = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
        receivedData = (NSMutableData)NSMutableData.data();
    }

    public void runURLConn2() {
        reset();
        receivedData = (NSMutableData)NSMutableData.data();
        NSURLRequest theRequest = NSURLRequest.requestWithURL(
                NSURL.URLWithString(NSString.fromJavaString("http://www.mooral.com.ar/")));

        theConnaction = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
    }

    public void runURLConn3() {
        reset();
        receivedData = (NSMutableData)NSMutableData.data();
        NSMutableURLRequest theRequest = (NSMutableURLRequest)NSURLRequest.requestWithURL(
                NSURL.URLWithString(NSString.fromJavaString("http://www.moe.com/")));
        theRequest.setHTTPMethod(NSString.fromJavaString("POST"));
        theRequest.setValueForHTTPHeaderField(NSString.fromJavaString("application/x-www-form-urlencoded"),
                NSString.fromJavaString("Content-Type"));

        theConnaction = NSURLConnection.alloc().initWithRequestDelegate(theRequest, this);
    }

    @Override
    @NativeSelector("connectionDidFinishLoading:")
    public void connectionDidFinishLoading(xosrt.binding.foundation.NSURLConnection connection) {
        passed = receivedData != null;
        finish = true;
    }

    @Override
    @NativeSelector("connection:didFailWithError:")
    public void connectionDidFailWithError(xosrt.binding.foundation.NSURLConnection connection,
                                           xosrt.binding.foundation.NSError error) {
        theConnaction.cancel();
        finish = true;
        passed = false;
    }

    @Override
    @NativeSelector("connection:didReceiveData:")
    public void connectionDidReceiveData(xosrt.binding.foundation.NSURLConnection connection,
                                         xosrt.binding.foundation.NSData data) {
        receivedData.appendData(data);
    }



}

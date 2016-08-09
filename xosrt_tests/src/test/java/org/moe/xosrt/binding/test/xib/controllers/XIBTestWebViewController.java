package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSBundle;
import ios.foundation.NSURL;
import ios.foundation.NSURLRequest;
import ios.uikit.UIViewController;
import ios.uikit.UIWebView;

public class XIBTestWebViewController extends UIViewController {

    public UIWebView webView = null;

    public static volatile boolean testOrigin1 = false;
    public static volatile boolean testSize1 = false;

    static {
        NatJ.register();
    }

    protected XIBTestWebViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestWebViewController alloc();

    @Selector("init")
    public native XIBTestWebViewController init();

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        NSURL url = NSURL.fileURLWithPathIsDirectory(NSBundle.mainBundle().pathForResourceOfType("htmlExample", "html"), false);
        NSURLRequest requestObj = NSURLRequest.requestWithURL(url);
        webView.loadRequest(requestObj);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
    }


    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        if (key.equals("webView")) {
            webView = (UIWebView)value;
        } else {
            super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        if (key.equals("webView")) {
            return webView;
        }
        return super.valueForKey(key);
    }

    /*
    @IBOutlet
    @CVariable(name = "webView", isGetter = true)
    public void getWebView(UIWebView view) {
        webView = view;
    }

    @IBOutlet
    @CVariable(name = "webView", isGetter = false)
    public UIWebView setWebView() {
        return webView;
    }*/

    public void testMethod() {
        testOrigin1 = (webView.frame().origin().x() == 0 && webView.frame().origin().y() == 21);
        testSize1 =  (webView.frame().size().width() == 320 && webView.frame().size().height() == 460);
    }
}

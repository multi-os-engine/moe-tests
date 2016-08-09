package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.*;
import ios.uikit.*;

public class UIImageViewViewController extends UIViewController {
    static {
        NatJ.register();
    }

    protected UIImageViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIImageViewViewController alloc();

    @Selector("init")
    public native UIImageViewViewController init();

    
    UIImage  newImage;

    public static volatile boolean testImage1 = false;
    public static volatile boolean testInitWithImage_without_frame1 = false;
    public static volatile boolean testInitWithImage1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        testMethod();
    }

    public void testMethod() {
        String nameImage = "balloons.png";
        newImage = UIImage.imageNamed(nameImage);
        String nameImage2 = "logo.jpeg";
        UIImage newImage2 = UIImage.imageNamed(nameImage2);
        UIImageView newImageView2 = UIImageView.alloc().initWithFrame(CoreGraphics.CGRectMake(120, 0, 120, 100));
        newImageView2.setImage(newImage2);
        newImageView2.setTag(2);
		view().addSubview(newImageView2);
		
        UIImageView newImageView3 = UIImageView.alloc().initWithFrame(CoreGraphics.CGRectMake(120, 200, 120, 100));
        newImageView3.setImage(null);
        newImageView3.setTag(3);
        view().addSubview(newImageView3);

        testImage1 = (newImageView2.image() == newImage2 && newImageView3.image() == null);

        UIImageView  newImageView1 = UIImageView.alloc().initWithImage(newImage);
        newImageView1.setTag(1);
        view().addSubview(newImageView1);

        CGRect rectView = newImageView1.frame();
        CGSize sizeImage = newImage.size();
        testInitWithImage_without_frame1 = (rectView.size().width() == sizeImage.width()
                && rectView.size().height() == sizeImage.height());

        UIImageView newImageView4 = UIImageView.alloc().initWithImage(null);
        newImageView4.setFrame(CoreGraphics.CGRectMake(0, 100, 120, 100));
        newImageView4.setTag(4);
        view().addSubview(newImageView4);

        NSArray array = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UIImageView.class, new UIImageView[] {
                        newImageView1, newImageView4
                }
        ), 2);

        if (newImageView1.frame().size().width() == 0 && newImageView1.frame().size().height() == 0) {
            performSelectorWithObjectAfterDelay(new SEL("checkInitWithImage:"), array, 1);
        } else {
            checkInitWithImage(array);
        }
    }

    @Selector("checkInitWithImage:")
    public void checkInitWithImage(NSArray array) {
        UIImageView newImageView = (UIImageView)array.objectAtIndex(0);
        UIImageView newImageView1 = (UIImageView)array.objectAtIndex(1);
        testInitWithImage1 = (newImageView.image() == newImage && newImageView1.image() == null);
    }
}

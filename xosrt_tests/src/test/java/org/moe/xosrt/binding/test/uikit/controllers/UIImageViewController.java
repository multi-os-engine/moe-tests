package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.UserView;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGSize;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIImageOrientation;

public class UIImageViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIImageViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIImageViewController alloc();

    @Selector("init")
    public native UIImageViewController init();


    public static volatile boolean testImageNamed1 = false;
    public static volatile boolean testImageWithContentsOfFile1 = false;
    public static volatile boolean testImageOrientation1 = false;
    public static volatile boolean testScale1 = false;
    public static volatile boolean testSize1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIImage image0 = UIImage.imageNamed("balloons.png");
        UIImageView imageView0 = UIImageView.alloc().initWithImage(image0);
        imageView0.setTag(1);

        UIImageView imageView1 = UIImageView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 100, 100, 100));
        String pathImage = NSBundle.mainBundle().pathForResourceOfType("images", "jpeg");
        UIImage image1 = UIImage.imageWithContentsOfFile(pathImage);
        imageView1.setImage(image1);
        imageView1.setTag(2);

        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 320, 460)));
        view().setBackgroundColor(UIColor.whiteColor());

        UserView view0 = (UserView)UserView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 220, 200, 200));
        view().addSubview(imageView0);
        view().addSubview(imageView1);
        view().addSubview(view0);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        performSelectorWithObjectAfterDelay(new SEL("testAllMethods"), null, 1);
    }

    @Selector("testAllMethods")
    public void testAllMethods() {

        UIImage image0 = UIImage.imageNamed("logo.jpeg");
        UIImageView imageView0 = UIImageView.alloc().initWithImage(image0);
        testImageNamed1 = (image0 != null && imageView0.frame().size().width() - 110 < 0.01
                && imageView0.frame().size().height() - 110 < 0.01 ) ;

        String pathImage0 = NSBundle.mainBundle().pathForResourceOfType("images", "jpeg");
        UIImage image1 = UIImage.imageWithContentsOfFile(pathImage0);
        UIImageView imageView1 = UIImageView.alloc().initWithImage(image1);
        testImageWithContentsOfFile1 = (image1 != null && imageView1.frame().size().width() - 106 < 0.01
                && imageView1.frame().size().height() - 76 < 0.01) ;

        UIImage image2 = UIImage.imageNamed("logo.jpeg");
        testImageOrientation1 = (image2 != null && image2.imageOrientation() == UIImageOrientation.Up) ;

        UIImage image4 = UIImage.imageNamed("balloons.png");
        testScale1 = (image4 != null && image4.scale() == 1.0);

        testSize();
    }

    public void testSize() {
        UIImage image = UIImage.imageNamed("balloons.png");
        CGSize size = image == null ? CoreGraphics.CGSizeZero() : image.size();
        if (size.width() == 0 && size.height() == 0) {
            performSelectorWithObjectAfterDelay(new SEL("checkSize:"), image, 1);
        } else {
            checkSize(image);
        }
    }

    @Selector("checkSize:")
    public void checkSize(UIImage image) {
        testSize1 = image != null && image.size().width() == 94 && image.size().height() == 77;
    }
}

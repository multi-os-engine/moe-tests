package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.XMLParserDelegate;
import org.junit.Test;

public class NSXMLParserDelegateTests {

    static {
        System.loadLibrary("Mac");
    }

    private static NSString XML_TEXT = NSString.fromJavaString(
            "<h:tree xmlns:h=\"http://www.plantleaf.org/brakedplants/\" height=\"58m\">\n<h:stem lengthy=\"54cm\" radius=\"12cm\"></h:stem>\n<h:root size=\"54cm\"></h:root>\n<h:branch idNumber=\"100\" lengthy=\"20cm\"><h:leaf>1</h:leaf></h:branch></h:tree>"
    );

    @Test
    public void testParserDidStartDocument1() {
        XMLParserDelegate parserDelegate = XMLParserDelegate.alloc().init();
        NSXMLParser parser = NSXMLParser.alloc().initWithData(
                XML_TEXT.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        parserDelegate.treeParser = parser;
        parser.setDelegate(parserDelegate);
        parser.setShouldProcessNamespaces(true);
        parser.parse(); //All assertions are being done during parsing process

        parser.release();
        parserDelegate.release();
    }

}

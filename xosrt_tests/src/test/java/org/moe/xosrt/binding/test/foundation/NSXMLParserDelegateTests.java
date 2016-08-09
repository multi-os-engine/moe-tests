package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import ios.foundation.*;
import ios.foundation.enums.Enums;

import org.moe.xosrt.binding.test.foundation.Utils.XMLParserDelegate;
import org.junit.BeforeClass;
import org.junit.Test;

public class NSXMLParserDelegateTests {

    private static NSString XML_TEXT = NSString.stringWithString(
            "<h:tree xmlns:h=\"http://www.plantleaf.org/brakedplants/\" height=\"58m\">\n<h:stem lengthy=\"54cm\" radius=\"12cm\"></h:stem>\n<h:root size=\"54cm\"></h:root>\n<h:branch idNumber=\"100\" lengthy=\"20cm\"><h:leaf>1</h:leaf></h:branch></h:tree>"
    );

    @BeforeClass
    public static void setup() {
        XMLParserDelegate parserDelegate = XMLParserDelegate.alloc().init();
        NSXMLParser parser = NSXMLParser.alloc().initWithData(
                XML_TEXT.dataUsingEncoding(Enums.NSASCIIStringEncoding));
        parserDelegate.treeParser = parser;
        parser.setDelegate(parserDelegate);
        parser.setShouldProcessNamespaces(true);
        parser.parse();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDidStartDocument() {
        assertTrue(XMLParserDelegate.testDidStartDocument);
    }

    @Test
    public void testDidEndDocument() {
        assertTrue(XMLParserDelegate.testDidEndDocument);
    }

    @Test
    public void testDidStartElement() {
        assertTrue(XMLParserDelegate.testDidStartElement);
    }

    @Test
    public void testDidEndElement() {
        assertTrue(XMLParserDelegate.testDidEndElement);
    }

    @Test
    public void testFoundCharacters() {
        assertTrue(XMLParserDelegate.testFoundCharacters);
    }


}

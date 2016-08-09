package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import ios.foundation.*;
import ios.foundation.enums.Enums;

import org.moe.xosrt.binding.test.foundation.Utils.MailXMLParserDelegate;
import org.moe.xosrt.binding.test.foundation.Utils.PersonXMLParserDelegate;
import org.moe.xosrt.binding.test.foundation.Utils.XMLElementParserDelegate;
import org.junit.Test;

public class NSXMLParserTests {

    private static final NSString MAIL_XML_STRING = NSString.stringWithString(
            "<mail><to>guy incognito</to><header>Hello Tito</header><body>Come vai</body></mail>");
    private static final NSString PERSON_XML_STRING = NSString.stringWithString(
            "<person gender=\"male\" witness-protection=\"yes\"><firstname isreal=\"yes\">Homer J.</firstname><lastname isreal=\"no\">Thompson</lastname></person>");

    @Test
    public void testInitWithData1() {
        NSData data0 = MAIL_XML_STRING.dataUsingEncoding(Enums.NSASCIIStringEncoding);
        NSXMLParser XMLparser0 = NSXMLParser.alloc().initWithData(data0);
        assertTrue (XMLparser0 != null);
    }

    @Test
    public void testDelegate1() {
        NSXMLParser mailXMLParser = NSXMLParser.alloc().initWithData(
                MAIL_XML_STRING.dataUsingEncoding(Enums.NSASCIIStringEncoding));
        MailXMLParserDelegate mailXMLParserDelegate = MailXMLParserDelegate.alloc().init();
        mailXMLParser.setDelegate(mailXMLParserDelegate);
        NSXMLParser personXMLParser = NSXMLParser.alloc().initWithData(
                PERSON_XML_STRING.dataUsingEncoding(Enums.NSASCIIStringEncoding));
        PersonXMLParserDelegate personXMLParserDelegate = PersonXMLParserDelegate.alloc().init();
        personXMLParser.setDelegate(personXMLParserDelegate);

        assertTrue (mailXMLParser.delegate() == mailXMLParserDelegate
                && personXMLParser.delegate() == personXMLParserDelegate);
    }

    @Test
    public void testParse1() {
        NSXMLParser mailXMLParser = (NSXMLParser)NSXMLParser.alloc().initWithData(
                MAIL_XML_STRING.dataUsingEncoding(Enums.NSASCIIStringEncoding));
        MailXMLParserDelegate mailXMLParserDelegate = MailXMLParserDelegate.alloc().init();
        mailXMLParser.setDelegate(mailXMLParserDelegate);
        mailXMLParser.parse();

        NSXMLParser personXMLParser = (NSXMLParser)NSXMLParser.alloc().initWithData(
                PERSON_XML_STRING.dataUsingEncoding(Enums.NSASCIIStringEncoding));
        PersonXMLParserDelegate personXMLParserDelegate = (PersonXMLParserDelegate)PersonXMLParserDelegate
                .alloc().init();
        personXMLParser.setDelegate(personXMLParserDelegate);
        personXMLParser.parse();

        assertTrue (mailXMLParserDelegate.mail.to.isEqual(NSString.stringWithString("guy incognito"))
                && mailXMLParserDelegate.mail.header.isEqual(NSString.stringWithString("Hello Tito"))
                && mailXMLParserDelegate.mail.body.isEqual(NSString.stringWithString("Come vai"))
                && personXMLParserDelegate.person.gender.isEqual(NSString.stringWithString("male"))
                && personXMLParserDelegate.person.witnessProtection.isEqual(NSString.stringWithString("yes"))
                && personXMLParserDelegate.person.firstname.isEqual(NSString.stringWithString("Homer J."))
                && personXMLParserDelegate.person.firstnameIsReal.isEqual(NSString.stringWithString("yes"))
                && personXMLParserDelegate.person.lastname.isEqual(NSString.stringWithString("Thompson"))
                && personXMLParserDelegate.person.lastnameIsReal.isEqual(NSString.stringWithString("no"))
        );
    }

    @Test
    public void testShouldProcessNamespaces1() {
        NSXMLParser xmlParser0 = NSXMLParser.alloc().initWithData(
                NSString.stringWithString("<good>No</good>").dataUsingEncoding(Enums.NSASCIIStringEncoding));
        xmlParser0.setShouldProcessNamespaces(false);
        NSString str = NSString.stringWithString(
                "<h:good xmlns:h=\"http://this.org\" idNumber=\"99\">No</h:good>");
        NSData data = str.dataUsingEncoding(Enums.NSASCIIStringEncoding);
        NSXMLParser xmlParser1 = NSXMLParser.alloc().initWithData( data );
        xmlParser1.setShouldProcessNamespaces(true);
        XMLElementParserDelegate xmlElementParserDelegate = (XMLElementParserDelegate)XMLElementParserDelegate
                .alloc().init();
        xmlParser1.setDelegate(xmlElementParserDelegate);
        if ( !xmlParser1.parse() ) {
        	System.err.println( xmlParser1.parserError().description() );
        }
        assertTrue(!xmlParser0.shouldProcessNamespaces()
                && xmlParser1.shouldProcessNamespaces()
                && xmlElementParserDelegate.element.name.isEqual(NSString.stringWithString("good"))
                && xmlElementParserDelegate.element.namespaceURI.isEqual(NSString.stringWithString("http://this.org"))
                && xmlElementParserDelegate.element.qName.isEqual(NSString.stringWithString("h:good"))
                && xmlElementParserDelegate.element.attributes.valueForKey("idNumber").equals("99")
                && xmlElementParserDelegate.element.characters.isEqual(NSString.stringWithString("No"))
        );
    }

}

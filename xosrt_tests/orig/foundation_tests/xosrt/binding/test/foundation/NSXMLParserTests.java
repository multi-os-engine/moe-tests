package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.MailXMLParserDelegate;
import xosrt.binding.test.foundation.Utils.PersonXMLParserDelegate;
import xosrt.binding.test.foundation.Utils.XMLElementParserDelegate;
import org.junit.Test;

public class NSXMLParserTests {

    private static final NSString MAIL_XML_STRING = NSString.fromJavaString(
            "<mail><to>guy incognito</to><header>Hello Tito</header><body>Come vai</body></mail>");
    private static final NSString PERSON_XML_STRING = NSString.fromJavaString(
            "<person gender=\"male\" witness-protection=\"yes\"><firstname isreal=\"yes\">Homer J.</firstname><lastname isreal=\"no\">Thompson</lastname></person>");

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithData1() {
        NSData data0 = MAIL_XML_STRING.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        NSXMLParser XMLparser0 = NSXMLParser.alloc().initWithData(data0);
        assertTrue (XMLparser0 != null);
    }

    @Test
    public void testDelegate1() {
        NSXMLParser mailXMLParser = NSXMLParser.alloc().initWithData(
                MAIL_XML_STRING.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        MailXMLParserDelegate mailXMLParserDelegate = MailXMLParserDelegate.alloc().init();
        mailXMLParser.setDelegate(mailXMLParserDelegate);
        NSXMLParser personXMLParser = NSXMLParser.alloc().initWithData(
                PERSON_XML_STRING.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        PersonXMLParserDelegate personXMLParserDelegate = PersonXMLParserDelegate.alloc().init();
        personXMLParser.setDelegate(personXMLParserDelegate);

        assertTrue (mailXMLParser.getDelegate() == mailXMLParserDelegate
                && personXMLParser.getDelegate() == personXMLParserDelegate);
    }

    @Test
    public void testParse1() {
        NSXMLParser mailXMLParser = (NSXMLParser)NSXMLParser.alloc().initWithData(
                MAIL_XML_STRING.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        MailXMLParserDelegate mailXMLParserDelegate = (MailXMLParserDelegate)MailXMLParserDelegate
                .alloc().init();
        mailXMLParser.setDelegate(mailXMLParserDelegate);
        mailXMLParser.parse();

        NSXMLParser personXMLParser = (NSXMLParser)NSXMLParser.alloc().initWithData(
                PERSON_XML_STRING.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        PersonXMLParserDelegate personXMLParserDelegate = (PersonXMLParserDelegate)PersonXMLParserDelegate
                .alloc().init();
        personXMLParser.setDelegate(personXMLParserDelegate);
        personXMLParser.parse();

        assertTrue (mailXMLParserDelegate.mail.to.isEqual(NSString.fromJavaString("guy incognito"))
                && mailXMLParserDelegate.mail.header.isEqual(NSString.fromJavaString("Hello Tito"))
                && mailXMLParserDelegate.mail.body.isEqual(NSString.fromJavaString("Come vai"))
                && personXMLParserDelegate.person.gender.isEqual(NSString.fromJavaString("male"))
                && personXMLParserDelegate.person.witnessProtection.isEqual(NSString.fromJavaString("yes"))
                && personXMLParserDelegate.person.firstname.isEqual(NSString.fromJavaString("Homer J."))
                && personXMLParserDelegate.person.firstnameIsReal.isEqual(NSString.fromJavaString("yes"))
                && personXMLParserDelegate.person.lastname.isEqual(NSString.fromJavaString("thompson"))
                && personXMLParserDelegate.person.lastnameIsReal.isEqual(NSString.fromJavaString("no"))
        );
    }

    @Test
    public void testShouldProcessNamespaces1() {
        NSXMLParser xmlParser0 = NSXMLParser.alloc().initWithData(
                NSString.fromJavaString("\"<good>No</good>\"").dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        xmlParser0.setShouldProcessNamespaces(false);
        NSXMLParser xmlParser1 = NSXMLParser.alloc().initWithData(NSString.fromJavaString(
                "\"<h:good xmlns:h=\\\"http://this.org\\\" idNumber=\\\"99\\\">No</h:good>\"")
                    .dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding));
        xmlParser1.setShouldProcessNamespaces(true);
        XMLElementParserDelegate xmlElementParserDelegate = (XMLElementParserDelegate)XMLElementParserDelegate
                .alloc().init();
        xmlParser1.setDelegate(xmlElementParserDelegate);
        xmlParser1.parse();
        assertTrue(!xmlParser0.shouldProcessNamespaces()
                && xmlParser1.shouldProcessNamespaces()
                && xmlElementParserDelegate.element.name.isEqual(NSString.fromJavaString("good"))
                && xmlElementParserDelegate.element.namespaceURI.isEqual(NSString.fromJavaString("http://this.org"))
                && xmlElementParserDelegate.element.qName.isEqual(NSString.fromJavaString("h:good"))
                && xmlElementParserDelegate.element.attributes.valueForKey(NSString.fromJavaString("idNumber"))
                    .isEqual(NSString.fromJavaString("99"))
                && xmlElementParserDelegate.element.characters.isEqual(NSString.fromJavaString("No"))
        );
    }

}

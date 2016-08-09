package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSMutableString;
import ios.NSObject;
import ios.foundation.NSString;
import ios.foundation.NSXMLParser;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Mail;
import ios.foundation.protocol.NSXMLParserDelegate;

public class MailXMLParserDelegate extends NSObject implements NSXMLParserDelegate {

    public Mail mail = null;
    public NSMutableString accumulatorString = null;

    static {
        NatJ.register();
    }

    protected MailXMLParserDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native MailXMLParserDelegate alloc();

    @Selector("init")
    public native MailXMLParserDelegate init();

    @Selector("parser:didEndElement:namespaceURI:qualifiedName:")
    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser nsxmlParser, String elementName, String s2, String s3) {
        if (elementName.equals("to")) {
            mail.to = accumulatorString;
        } else if (elementName.equals("header")) {
            mail.header = accumulatorString;
        } else if (elementName.equals("body")) {
            mail.body = accumulatorString;
        }
    }

    @Override
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, String s) {

    }

    @Selector("parser:didStartElement:namespaceURI:qualifiedName:attributes:")
    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser nsxmlParser, String elementName, String s2, String s3, NSDictionary nsDictionary) {
        if (elementName.equals("mail")) {
            mail = Mail.alloc().init();
        }
        accumulatorString = NSMutableString.alloc().init();
    }

    @Override
    public void parserDidStartMappingPrefixToURI(NSXMLParser nsxmlParser, String s, String s2) {

    }

    @Override
    public void parserFoundAttributeDeclarationWithNameForElementTypeDefaultValue(NSXMLParser nsxmlParser, String s, String s2, String s3, String s4) {

    }

    @Override
    public void parserFoundCDATA(NSXMLParser nsxmlParser, NSData nsData) {

    }

	@Selector("parser:foundCharacters:")
    @Override
    public void parserFoundCharacters(NSXMLParser nsxmlParser, String string) {
        accumulatorString.appendString(string);
    }

    @Override
    public void parserFoundComment(NSXMLParser nsxmlParser, String s) {

    }

    @Override
    public void parserFoundElementDeclarationWithNameModel(NSXMLParser nsxmlParser, String s, String s2) {

    }

    @Override
    public void parserFoundExternalEntityDeclarationWithNamePublicIDSystemID(NSXMLParser nsxmlParser, String s, String s2, String s3) {

    }

    @Override
    public void parserFoundIgnorableWhitespace(NSXMLParser nsxmlParser, String s) {

    }

    @Override
    public void parserFoundInternalEntityDeclarationWithNameValue(NSXMLParser nsxmlParser, String s, String s2) {

    }

    @Override
    public void parserFoundNotationDeclarationWithNamePublicIDSystemID(NSXMLParser nsxmlParser, String s, String s2, String s3) {

    }

    @Override
    public void parserFoundProcessingInstructionWithTargetData(NSXMLParser nsxmlParser, String s, String s2) {

    }

    @Override
    public void parserFoundUnparsedEntityDeclarationWithNamePublicIDSystemIDNotationName(NSXMLParser nsxmlParser, String s, String s2, String s3, String s4) {

    }

    @Override
    public void parserParseErrorOccurred(NSXMLParser nsxmlParser, NSError nsError) {

    }

    @Override
    public NSData parserResolveExternalEntityNameSystemID(NSXMLParser nsxmlParser, String s, String s2) {
        return null;
    }

    @Override
    public void parserValidationErrorOccurred(NSXMLParser nsxmlParser, NSError nsError) {

    }

    @Override
    public void parserDidEndDocument(NSXMLParser nsxmlParser) {

    }

    @Override
    public void parserDidStartDocument(NSXMLParser nsxmlParser) {

    }
}

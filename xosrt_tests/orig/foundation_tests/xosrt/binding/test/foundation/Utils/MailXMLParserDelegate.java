package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSData;
import xosrt.binding.foundation.NSDictionary;
import xosrt.binding.foundation.NSError;
import xosrt.binding.foundation.NSMutableString;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSXMLParser;
import xosrt.binding.foundation.NSXMLParserDelegate;
import xosrt.binding.test.foundation.Utils.XMLParser.Mail;

public class MailXMLParserDelegate extends NSObject implements NSXMLParserDelegate {

    public Mail mail = null;
    public NSMutableString accumulatorString = null;

    static {
        Registrator.registerClassObject(MailXMLParserDelegate.class);
    }

    @NativeSelector("alloc")
    public static native MailXMLParserDelegate alloc();

    @NativeSelector("init")
    public native MailXMLParserDelegate init();

    @Override
    public void parserDidStartDocument(NSXMLParser nsxmlParser) {

    }

    @Override
    public void parserDidEndDocument(NSXMLParser nsxmlParser) {

    }

    @Override
    public void parserFoundNotationDeclarationWithNamePublicIDSystemID(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2, NSString nsString3) {

    }

    @Override
    public void parserFoundUnparsedEntityDeclarationWithNamePublicIDSystemIDNotationName(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2, NSString nsString3, NSString nsString4) {

    }

    @Override
    public void parserFoundAttributeDeclarationWithNameForElementTypeDefaultValue(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2, NSString nsString3, NSString nsString4) {

    }

    @Override
    public void parserFoundElementDeclarationWithNameModel(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {

    }

    @Override
    public void parserFoundInternalEntityDeclarationWithNameValue(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {

    }

    @Override
    public void parserFoundExternalEntityDeclarationWithNamePublicIDSystemID(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2, NSString nsString3) {

    }

    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser nsxmlParser, NSString elementName,
                                                                         NSString namespaceURI, NSString nsString3,
                                                                         NSDictionary nsDictionary) {
        if (elementName.isEqualToString(NSString.fromJavaString("mail"))) {
            mail = Mail.alloc().init();
        }
        accumulatorString = NSMutableString.alloc().init();
    }

    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser nsxmlParser, NSString elementName, NSString nsString2, NSString nsString3) {
        if (elementName.isEqualToString(NSString.fromJavaString("to"))) {
            mail.to = accumulatorString;
        } else if (elementName.isEqualToString(NSString.fromJavaString("header"))) {
            mail.header = accumulatorString;
        } else if (elementName.isEqualToString(NSString.fromJavaString("body"))) {
            mail.body = accumulatorString;
        }
    }

    @Override
    public void parserDidStartMappingPrefixToURI(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {

    }

    @Override
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, NSString nsString) {

    }

    @Override
    public void parserFoundCharacters(NSXMLParser nsxmlParser, NSString string) {
        accumulatorString.appendString(string);
    }

    @Override
    public void parserFoundIgnorableWhitespace(NSXMLParser nsxmlParser, NSString nsString) {

    }

    @Override
    public void parserFoundProcessingInstructionWithTargetData(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {

    }

    @Override
    public void parserFoundComment(NSXMLParser nsxmlParser, NSString nsString) {

    }

    @Override
    public void parserFoundCDATA(NSXMLParser nsxmlParser, NSData nsData) {

    }

    @Override
    public NSData parserResolveExternalEntityNameSystemID(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {
        return null;
    }

    @Override
    public void parserParseErrorOccurred(NSXMLParser nsxmlParser, NSError nsError) {

    }

    @Override
    public void parserValidationErrorOccurred(NSXMLParser nsxmlParser, NSError nsError) {

    }
}

package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.NSObject;
import ios.foundation.NSString;
import ios.foundation.NSXMLParser;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Person;
import ios.foundation.protocol.NSXMLParserDelegate;

public class PersonXMLParserDelegate extends NSObject implements NSXMLParserDelegate {

    public Person person = null;
    public boolean startFirstName = false, endFirstName = false;

    static {
        NatJ.register();
    }

    protected PersonXMLParserDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native PersonXMLParserDelegate alloc();

    @Selector("init")
    public native PersonXMLParserDelegate init();

    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser nsxmlParser, String s, String s2, String s3) {

    }

    @Override
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, String s) {

    }

    @Selector("parser:didStartElement:namespaceURI:qualifiedName:attributes:")
    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser nsxmlParser, String elementName, String s2, String s3, NSDictionary attributeDict) {
        if (elementName.equals("person")) {
            person = Person.alloc().init();
            person.gender = NSString.stringWithString(attributeDict.valueForKey("gender").toString());
            person.witnessProtection = NSString.stringWithString(attributeDict.valueForKey("witness-protection").toString());
        } else if (elementName.equals("firstname")) {
            person.firstnameIsReal = NSString.stringWithString(attributeDict.valueForKey("isreal").toString());

        } else if (elementName.equals("lastname")) {
            person.lastnameIsReal = NSString.stringWithString(attributeDict.valueForKey("isreal").toString());
        }
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
    public void parserFoundCharacters(NSXMLParser nsxmlParser, String nsString) {
        if (person.firstnameIsReal != null && person.firstname == null ) {
            person.firstname = NSString.stringWithString(nsString);
        } else if (person.lastnameIsReal != null && person.lastname == null) {
            person.lastname = NSString.stringWithString(nsString);
        }
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

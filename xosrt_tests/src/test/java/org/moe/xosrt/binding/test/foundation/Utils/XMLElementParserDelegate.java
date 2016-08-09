package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.NSObject;
import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.XMLElement;
import ios.foundation.NSXMLParser;
import ios.foundation.protocol.NSXMLParserDelegate;

public class XMLElementParserDelegate extends NSObject implements NSXMLParserDelegate {

    public XMLElement element = null;

    static {
        NatJ.register();
    }

    protected XMLElementParserDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XMLElementParserDelegate alloc();

    @Selector("init")
    public native XMLElementParserDelegate init();

    @Selector("parser:didEndElement:namespaceURI:qualifiedName:")
    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser nsxmlParser, String s, String s2, String s3) {

    }

    @Override
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, String s) {

    }

    @Selector("parser:didStartElement:namespaceURI:qualifiedName:attributes:")
    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser nsxmlParser, String elementName,
                                                                         String namespaceURI, String qName, NSDictionary attributeDict) {
        element = (XMLElement) XMLElement.alloc().init();
        element.name = NSString.stringWithString(elementName);
        element.namespaceURI = NSString.stringWithString(namespaceURI);
        element.qName = NSString.stringWithString(qName);
        element.attributes = attributeDict;
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
        element.characters = NSString.stringWithString(string);
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

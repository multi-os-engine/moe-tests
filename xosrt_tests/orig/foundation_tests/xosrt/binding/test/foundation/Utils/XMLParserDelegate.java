package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSData;
import xosrt.binding.foundation.NSDictionary;
import xosrt.binding.foundation.NSError;
import xosrt.binding.foundation.NSMutableArray;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSXMLParser;
import xosrt.binding.foundation.NSXMLParserDelegate;
import xosrt.binding.test.foundation.Utils.XMLParser.Branch;
import xosrt.binding.test.foundation.Utils.XMLParser.Leaf;
import xosrt.binding.test.foundation.Utils.XMLParser.Tree;
import xosrt.binding.test.foundation.Utils.XMLParser.Root;
import xosrt.binding.test.foundation.Utils.XMLParser.Stem;

import static org.junit.Assert.assertTrue;

public class XMLParserDelegate extends NSObject implements NSXMLParserDelegate {

    private int count = 0;
    public NSXMLParser treeParser = null;
    private Tree tree = null;
    private Branch branch = null;
    private Leaf leaf = null;

    static {
        Registrator.registerClassObject(XMLParserDelegate.class);
    }

    @NativeSelector("alloc")
    public static native XMLParserDelegate alloc();

    @NativeSelector("init")
    public native XMLParserDelegate init();

    private void testDidStartDocument(NSXMLParser parser) {
        assertTrue(count == 1 && parser == treeParser) ;
    }

    private void testDidEndDocument(NSXMLParser parser) {
        assertTrue(count == 16 && parser == treeParser) ;
    }

    private void testDidStartElement(NSXMLParser parser, NSString elementName, NSString namespaceURI,
                                     NSString qName, NSDictionary attributes) {
        assertTrue(count == 2 && parser == treeParser
                && elementName.isEqual(NSString.fromJavaString("tree"))
                && namespaceURI.isEqual(NSString.fromJavaString("http://www.plantleaf.org/brakedplants/"))
                && qName.isEqual(NSString.fromJavaString("h:tree"))
                && attributes.valueForKey(NSString.fromJavaString("height"))
                    .isEqual(NSString.fromJavaString("58m"))
        );
    }

    private void testDidEndElement(NSXMLParser parser, NSString elementName, NSString namespaceURI,
                                     NSString qName) {
        assertTrue(count == 13 && parser == treeParser
                && elementName.isEqual(NSString.fromJavaString("leaf"))
                && namespaceURI.isEqual(NSString.fromJavaString("http://www.plantleaf.org/brakedplants/"))
                && qName.isEqual(NSString.fromJavaString("h:leaf"))
        );

    }

    private void testFoundCharacters(NSXMLParser parser, NSString string) {
        assertTrue(count == 12 && parser == treeParser && string.isEqual(NSString.fromJavaString("1")));
    }

    @Override
    public void parserDidStartDocument(NSXMLParser nsxmlParser) {
        count++;
        testDidStartDocument(nsxmlParser);
    }

    @Override
    public void parserDidEndDocument(NSXMLParser nsxmlParser) {
        count++;
        testDidEndDocument(nsxmlParser);
    }

    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser parser, NSString elementName,
                                                                         NSString namespaceURI, NSString qName,
                                                                         NSDictionary attributeDict) {
        count++;
        if (parser == treeParser) {

            if(elementName.isEqual(NSString.fromJavaString("tree"))) {
                tree = Tree.alloc().init();
                tree.height = (NSString)attributeDict.valueForKey(NSString.fromJavaString("height"));
                testDidStartElement(parser, elementName, namespaceURI, qName, attributeDict);
            }

            if(elementName.isEqual(NSString.fromJavaString("root"))) {
                tree.root = (Root)Root.alloc().init();
                tree.root.size = (NSString) attributeDict.valueForKey(NSString.fromJavaString("size"));
            }

            if(elementName.isEqual(NSString.fromJavaString("stem"))) {
                tree.stem = (Stem)Stem.alloc().init();
                tree.stem.lengthy = (NSString) attributeDict.valueForKey(NSString.fromJavaString("lengthy"));
                tree.stem.radius = (NSString) attributeDict.valueForKey(NSString.fromJavaString("radius"));
            }

            if(elementName.isEqual(NSString.fromJavaString("branch"))) {
                branch = (Branch)Branch.alloc().init();
                branch.idNumber = (NSString) attributeDict.valueForKey(NSString.fromJavaString("idNumber"));
                branch.lengthy = (NSString) attributeDict.valueForKey(NSString.fromJavaString("lengthy"));
            }

            if(elementName.isEqual(NSString.fromJavaString("leaf"))) {
                leaf = (Leaf)Leaf.alloc().init();
                leaf.idNumber = (NSString) attributeDict.valueForKey(NSString.fromJavaString("idNumber"));
            }
        }
    }

    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser parser, NSString elementName,
                                                             NSString namespaceURI, NSString qName) {
        count++;
        if (parser == treeParser) {

            if(elementName.isEqual(NSString.fromJavaString("leaf"))) {
                if(branch != null) {
                    if(branch.leaves == null) {
                        branch.leaves = (NSMutableArray)NSMutableArray.alloc().init();
                    }
                    branch.leaves.addObject(leaf);
                    testDidEndElement(parser, elementName, namespaceURI, qName);
                }
                leaf = null;
            }

            if(elementName.isEqual(NSString.fromJavaString("branch"))) {
                if(branch != null) {
                    if(tree.branches == null) {
                        tree.branches = (NSMutableArray)NSMutableArray.alloc().init();
                    }
                    tree.branches.addObject(branch);
                }
                branch = null;
            }

        }
    }

    @Override
    public void parserFoundCharacters(NSXMLParser parser, NSString string) {
        count++;
        if (parser == treeParser) {
            if (leaf != null) {
                leaf.idNumber = string;
                testFoundCharacters(parser, string);
            }
        }
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
    public void parserDidStartMappingPrefixToURI(NSXMLParser nsxmlParser, NSString nsString, NSString nsString2) {

    }

    @Override
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, NSString nsString) {

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

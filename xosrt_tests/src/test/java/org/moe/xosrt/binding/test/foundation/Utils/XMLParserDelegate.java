package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSMutableArray;
import ios.NSObject;
import ios.foundation.NSString;
import ios.foundation.NSXMLParser;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Branch;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Leaf;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Tree;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Root;
import org.moe.xosrt.binding.test.foundation.Utils.XMLParser.Stem;
import ios.foundation.protocol.NSXMLParserDelegate;

import static org.junit.Assert.assertTrue;

public class XMLParserDelegate extends NSObject implements NSXMLParserDelegate {

    private int count = 0;
    public NSXMLParser treeParser = null;
    private Tree tree = null;
    private Branch branch = null;
    private Leaf leaf = null;

    static {
        NatJ.register();
    }

    public static volatile boolean testDidStartDocument = false;
    public static volatile boolean testDidEndDocument = false;
    public static volatile boolean testDidStartElement = false;
    public static volatile boolean testDidEndElement = false;
    public static volatile boolean testFoundCharacters = false;

    protected XMLParserDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XMLParserDelegate alloc();

    @Selector("init")
    public native XMLParserDelegate init();

    private void testDidStartDocument(NSXMLParser parser) {
        testDidStartDocument = (count == 1 && parser == treeParser) ;
    }

    private void testDidEndDocument(NSXMLParser parser) {
        testDidEndDocument = (count == 16 && parser == treeParser) ;
    }

    private void testDidStartElement(NSXMLParser parser, NSString elementName, NSString namespaceURI,
                                     NSString qName, NSDictionary attributes) {
        testDidStartElement = (count == 2 && parser == treeParser
                && elementName.isEqual(NSString.stringWithString("tree"))
                && namespaceURI.isEqual(NSString.stringWithString("http://www.plantleaf.org/brakedplants/"))
                && qName.isEqual(NSString.stringWithString("h:tree"))
                && attributes.valueForKey("height").equals("58m")
        );
    }

    private void testDidEndElement(NSXMLParser parser, NSString elementName, NSString namespaceURI,
                                     NSString qName) {
        testDidEndElement = (count == 13 && parser == treeParser
                && elementName.isEqual(NSString.stringWithString("leaf"))
                && namespaceURI.isEqual(NSString.stringWithString("http://www.plantleaf.org/brakedplants/"))
                && qName.isEqual(NSString.stringWithString("h:leaf"))
        );

    }

    private void testFoundCharacters(NSXMLParser parser, NSString string) {
        testFoundCharacters = (count == 12 && parser == treeParser && string.isEqual(NSString.stringWithString("1")));
    }

    @Selector("parserDidStartDocument:")
    @Override
    public void parserDidStartDocument(NSXMLParser nsxmlParser) {
        count++;
        testDidStartDocument(nsxmlParser);
    }

    @Selector("parser:didEndElement:namespaceURI:qualifiedName:")
    @Override
    public void parserDidEndElementNamespaceURIQualifiedName(NSXMLParser parser, String elementName, String namespaceURI, String qName) {
        count++;
        if (parser == treeParser) {

            if(elementName.equals("leaf")) {
                if(branch != null) {
                    if(branch.leaves == null) {
                        branch.leaves = (NSMutableArray)NSMutableArray.alloc().init();
                    }
                    branch.leaves.addObject(leaf);
                    testDidEndElement(parser,
                            NSString.stringWithString(elementName),
                            NSString.stringWithString(namespaceURI),
                            NSString.stringWithString(qName));
                }
                leaf = null;
            }

            if(elementName.equals("branch")) {
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
    public void parserDidEndMappingPrefix(NSXMLParser nsxmlParser, String s) {

    }

    @Selector("parser:didStartElement:namespaceURI:qualifiedName:attributes:")
    @Override
    public void parserDidStartElementNamespaceURIQualifiedNameAttributes(NSXMLParser parser, String elementName,
                                                                         String namespaceURI, String qName, NSDictionary attributeDict) {
        count++;
        if (parser == treeParser) {

            if(elementName.equals("tree")) {
                tree = Tree.alloc().init();
                Object val = attributeDict.valueForKey("height");
                tree.height = NSString.stringWithString(val == null ? "" : val.toString());
                testDidStartElement(parser,
                        NSString.stringWithString(elementName),
                        NSString.stringWithString(namespaceURI),
                        NSString.stringWithString(qName),
                        attributeDict);
            }

            if(elementName.equals("root")) {
                tree.root = (Root)Root.alloc().init();
                Object val = attributeDict.valueForKey("size");
                tree.root.size = NSString.stringWithString(val == null ? "" : val.toString());
            }

            if(elementName.equals("stem")) {
                tree.stem = (Stem)Stem.alloc().init();
                Object val1 = attributeDict.valueForKey("lengthy");
                Object val2 = attributeDict.valueForKey("radius");
                tree.stem.lengthy = NSString.stringWithString(val1 == null ? "" : val1.toString());
                tree.stem.radius = NSString.stringWithString(val2 == null ? "" : val2.toString());
            }

            if(elementName.equals("branch")) {
                branch = (Branch)Branch.alloc().init();
                Object val1 = attributeDict.valueForKey("idNumber");
                Object val2 = attributeDict.valueForKey("lengthy");
                branch.idNumber = NSString.stringWithString(val1 == null ? "" : val1.toString());
                branch.lengthy = NSString.stringWithString(val2 == null ? "" : val2.toString());
            }

            if(elementName.equals("leaf")) {
                leaf = (Leaf)Leaf.alloc().init();
                Object val = attributeDict.valueForKey("idNumber");
                leaf.idNumber = NSString.stringWithString(val == null ? "" : val.toString());
            }
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
    public void parserFoundCharacters(NSXMLParser parser, String string) {
        count++;
        if (parser == treeParser) {
            if (leaf != null) {
                leaf.idNumber = NSString.stringWithString(string);
                testFoundCharacters(parser, NSString.stringWithString(string));
            }
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

    @Selector("parserDidEndDocument:")
    @Override
    public void parserDidEndDocument(NSXMLParser nsxmlParser) {
        count++;
        testDidEndDocument(nsxmlParser);
    }

}

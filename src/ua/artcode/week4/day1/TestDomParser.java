package ua.artcode.week4.day1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by admin on 20.09.2014.
 */
public class TestDomParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document tree =
                documentBuilder.parse(String.valueOf(TestDomParser.class.getResource("company.xml")));
        Element element  = tree.getDocumentElement();

        showElement(element.getChildNodes(),"");


    }

    public static void showElement(NodeList childs, String spaces){
        for (int i = 0; i < childs.getLength(); i++) {
            Node node = childs.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element el = (Element) childs.item(i);
                System.out.println(spaces + "<"+el.getTagName()+">");
                if(el.hasChildNodes()){
                    showElement(el.getChildNodes(), spaces + "\t");
                }
                System.out.println(spaces + "</"+el.getTagName()+">");
            } else if(node.getNodeType() == Node.TEXT_NODE) {
                if(!node.getNodeValue().contains("\n")){
                    System.out.println("\t\t" + node.getNodeValue());
                }
            }
        }
    }
}

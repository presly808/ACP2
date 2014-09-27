package ua.artcode.week4.day1;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by 1 on 20.09.14.
 */
public class TestDOM {
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document tree = null;//
        try {
            tree = documentBuilder.parse(String.valueOf(TestDOM.class.getResource("company.xml")));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element elem = tree.getDocumentElement();
        System.out.println(elem.getTagName());
        System.out.println(elem.getNodeValue());
        showElement(elem.getChildNodes(),"");
    }
    public static void showElement(NodeList childs, String spaces){
        for (int i = 0; i < childs.getLength(); i++) {
            Node node = childs.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element el = (Element) childs.item(i);
                NamedNodeMap map = el.getAttributes();
                String temp = "";
                    for (int j = 0; j < map.getLength(); j++){
                        Attr attr = (Attr) map.item(j);
                        temp += attr.toString() + " ";
                    }

                    System.out.println(spaces + "<"+el.getTagName()+ " " + temp + ">");

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

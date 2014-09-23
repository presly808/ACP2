package my_tmp.MyXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Admin on 20.09.14.
 */
public class MyTestXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document root = builder.parse(String.valueOf(MyTestXML.class.getResource("MyCompany.xml")));
        Element element = root.getDocumentElement();
        System.out.println(element.getTagName());
        System.out.println(element);

    }
}

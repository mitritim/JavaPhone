package javaphone;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author iGroup
 */
public abstract class FileIO {

    public boolean writeFile(String fileName,
            String rootElementName,
            String objectElementName,
            ArrayList<HashMap> fileData) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement(rootElementName);
            doc.appendChild(rootElement);

            //customer.setAttribute("id", "1");
            for (HashMap objectFields : fileData) {
                //main object element
                Element objectElement = doc.createElement(objectElementName);
                rootElement.appendChild(objectElement);
                Set set = objectFields.entrySet();
                Iterator i = set.iterator();

                while (i.hasNext()) {
                    Map.Entry me = (Map.Entry) i.next();
                    Element element = doc.createElement(me.getKey().toString());
                    //object sub-elements
                    element.appendChild(doc.createTextNode(me.getValue().toString()));
                    objectElement.appendChild(element);
                }
            }

            //write dom to xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            return true;

        } catch (ParserConfigurationException | TransformerException pce) {
            return false;
        }
    }

    public ArrayList readFile(String fileName, String objectElementName) {

        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(file);

            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName(objectElementName);

            ArrayList objects = new ArrayList();

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nNode;
                    NodeList children = element.getChildNodes();

                    HashMap fieldValues = new HashMap();

                    for (int j = 0; j < children.getLength(); j++) {
                        if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            fieldValues.put(children.item(j).getNodeName(),
                                    children.item(j).getTextContent());
                        }
                        objects.add(fieldValues);
                    }
                }
            }
            return objects;
            
        } catch (ParserConfigurationException |
                SAXException |
                IOException |
                DOMException ex) {
            return null;
        }
    }
}

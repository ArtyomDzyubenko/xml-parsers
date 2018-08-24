package parser;

import entity.AccountingPoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class MyDOMParser {
    ArrayList<AccountingPoint> accountingPoints = new ArrayList<>();

    public boolean parse(String xsdFilename, String xmlFilename){
        XSDValidator xsdValidator = new XSDValidator();

        if(!xsdValidator.validate(xsdFilename, xmlFilename)){
            return false;
        }

        File xmlFile = new File(xmlFilename);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder;

        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("AccountingPoint");

            for(int i=0; i<nodeList.getLength(); i++){
                accountingPoints.add(getAccountingPoint(nodeList.item(i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<AccountingPoint> getAccountingPoints(){
        return accountingPoints;
    }

    private AccountingPoint getAccountingPoint(Node node){
        AccountingPoint accountingPoint = new AccountingPoint();

        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            accountingPoint.setId(Integer.parseInt(element.getAttribute("id")));
            accountingPoint.getTenant().getAddress().setCity(getNodeValue("city", element));
            accountingPoint.getTenant().getAddress().setStreet(getNodeValue("street", element));
            accountingPoint.getTenant().getAddress().setBuilding(getNodeValue("building", element));
            accountingPoint.getTenant().getAddress().setFlat(getNodeValue("flat", element));
            accountingPoint.getTenant().setFirstName(getNodeValue("firstName", element));
            accountingPoint.getTenant().setLastName(getNodeValue("lastName", element));
            accountingPoint.getTenant().setPhoneNumber(getNodeValue("phoneNumber", element));
            accountingPoint.getTenant().setEmail(getNodeValue("email", element));
            accountingPoint.getTenant().setAccount(Integer.parseInt(getNodeValue("account", element)));
            accountingPoint.getPowerMeter().setNumber(Integer.parseInt(getNodeValue("powerMeterNumber", element)));
        }

        return accountingPoint;
    }

    private String getNodeValue(String tagName, Element element){
        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}

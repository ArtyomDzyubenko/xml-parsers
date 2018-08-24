package parser;

import entity.AccountingPoint;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;

public class MyStAXParser {
    ArrayList<AccountingPoint> accountingPoints = new ArrayList<>();

    public boolean parse(String xsdFilename, String xmlFilename) {
        XSDValidator xsdValidator = new XSDValidator();

        if(!xsdValidator.validate(xsdFilename, xmlFilename)){
            return false;
        }

        AccountingPoint accountingPoint = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFilename));

            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equals("AccountingPoint")) {
                        accountingPoint = new AccountingPoint();

                        Attribute id = startElement.getAttributeByName(new QName("id"));

                        if (id != null) {
                            accountingPoint.setId(Integer.parseInt(id.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("city")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().getAddress().setCity(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("street")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().getAddress().setStreet(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("building")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().getAddress().setBuilding(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("flat")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().getAddress().setFlat(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("firstName")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().setFirstName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("lastName")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().setLastName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("phoneNumber")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().setPhoneNumber(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("email")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().setEmail(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("account")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getTenant().setAccount(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("powerMeterNumber")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountingPoint.getPowerMeter().setNumber(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }

                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("AccountingPoint")){
                        accountingPoints.add(accountingPoint);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  true;
    }

    public ArrayList<AccountingPoint> getAccountingPoints() {
        return accountingPoints;
    }
}


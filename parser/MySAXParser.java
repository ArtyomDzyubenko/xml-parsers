package parser;

import entity.AccountingPoint;
import entity.PowerMeterType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

public class MySAXParser {
    ArrayList<AccountingPoint> accountingPoints = null;
    AccountingPoint accountingPoint = null;

    public MySAXParser(){

    }

    public void parse(String fileName) throws ParserConfigurationException, SAXException {
       SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        try {
            saxParser.parse(fileName, new Handler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AccountingPoint> getAccountingPoints() {
        return accountingPoints;
    }

    private class Handler extends DefaultHandler {
        boolean city = false;
        boolean street = false;
        boolean building = false;
        boolean flat = false;
        boolean firstName = false;
        boolean lastName = false;
        boolean phoneNumber = false;
        boolean email = false;
        boolean account = false;
        boolean powerMeterNumber = false;
        boolean powerMeterType = false;

        private void setCity(boolean city) {
            this.city = city;
        }

        private void setStreet(boolean street) {
            this.street = street;
        }

        private void setBuilding(boolean building) {
            this.building = building;
        }

        private void setFlat(boolean flat) {
            this.flat = flat;
        }

        private void setFirstName(boolean firstName) {
            this.firstName = firstName;
        }

        private void setLastName(boolean lastName) {
            this.lastName = lastName;
        }

        private void setPhoneNumber(boolean phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        private void setEmail(boolean email) {
            this.email = email;
        }

        private void setAccount(boolean account) {
            this.account = account;
        }

        private void setPowerMeterNumber(boolean powerMeterNumber) {
            this.powerMeterNumber = powerMeterNumber;
        }

        private void setPowerMeterType(boolean powerMeterType) {
            this.powerMeterType = powerMeterType;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("AccountingPoint")) {
                int id = Integer.parseInt(attributes.getValue("id"));

                accountingPoint = new AccountingPoint();
                accountingPoint.setId(id);
                if (accountingPoints == null) {
                    accountingPoints = new ArrayList<>();
                }
            } else if (qName.equalsIgnoreCase("city")) {
                setCity(true);
            } else if (qName.equalsIgnoreCase("street")) {
                setStreet(true);
            } else if (qName.equalsIgnoreCase("building")) {
                setBuilding(true);
            } else if (qName.equalsIgnoreCase("flat")) {
                setFlat(true);
            } else if (qName.equalsIgnoreCase("firstName")){
                setFirstName(true);
            } else if (qName.equalsIgnoreCase("lastName")) {
                setLastName(true);
            } else if (qName.equalsIgnoreCase("phoneNumber")) {
                setPhoneNumber(true);
            } else if (qName.equalsIgnoreCase("email")){
                setEmail(true);
            } else if (qName.equalsIgnoreCase("account")){
                setAccount(true);
            } else if (qName.equalsIgnoreCase("powerMeterNumber")) {
                setPowerMeterNumber(true);
            } else if (qName.equalsIgnoreCase("powerMeterType")){
                setPowerMeterType(true);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("AccountingPoint")){
                accountingPoints.add(accountingPoint);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (city){
                accountingPoint.getTenant().getAddress().setCity(new String(ch, start, length));
                setCity(false);
            } else if (street) {
                accountingPoint.getTenant().getAddress().setStreet(new String(ch, start, length));
                setStreet(false);
            } else if (building) {
                accountingPoint.getTenant().getAddress().setBuilding(new String(ch, start, length));
                setBuilding(false);
            } else if (flat){
                accountingPoint.getTenant().getAddress().setFlat(new String(ch, start, length));
                setFlat(false);
            } else if (firstName) {
                accountingPoint.getTenant().setFirstName(new String(ch, start, length));
                setFirstName(false);
            } else if (lastName) {
                accountingPoint.getTenant().setLastName(new String(ch, start, length));
                setLastName(false);
            } else if (phoneNumber){
                accountingPoint.getTenant().setPhoneNumber(new String(ch, start, length));
                setPhoneNumber(false);
            } else if (email) {
                accountingPoint.getTenant().setEmail(new String(ch, start, length));
                setEmail(false);
            } else if (account){
                accountingPoint.getTenant().setAccount(Integer.parseInt(new String(ch, start, length)));
                setAccount(false);
            } else if (powerMeterNumber) {
                accountingPoint.getPowerMeter().setNumber(Integer.parseInt(new String(ch, start, length)));
                setPowerMeterNumber(false);
            } else if (powerMeterType) {
                accountingPoint.getPowerMeter().setType(PowerMeterType.valueOf(new String(ch, start, length)));
                setPowerMeterType(false);
            }
        }
    }

}

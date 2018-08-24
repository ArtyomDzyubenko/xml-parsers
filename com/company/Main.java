package com.company;

import entity.AccountingPoint;
import org.xml.sax.SAXException;
import parser.MyDOMParser;
import parser.MySAXParser;
import parser.MyStAXParser;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xsdFilename = "C:\\Users\\Artem\\IdeaProjects\\xml-parsers\\src\\Accounting points.xsd";
        String xmlFilename = "C:\\Users\\Artem\\IdeaProjects\\xml-parsers\\src\\Accounting points.xml";

        System.out.println("SAX PARSER\n");

        MySAXParser mySAXParser = new MySAXParser();
        mySAXParser.parse(xsdFilename, xmlFilename);

        ArrayList<AccountingPoint> accountingPoints = mySAXParser.getAccountingPoints();

        for (AccountingPoint item : accountingPoints){
            System.out.println(item);
        }

        System.out.println("StAX PARSER\n");

        MyStAXParser myStaxParser = new MyStAXParser();
        myStaxParser.parse(xsdFilename, xmlFilename);

        ArrayList<AccountingPoint> accountingPoints1 = myStaxParser.getAccountingPoints();

        for (AccountingPoint item : accountingPoints1){
            System.out.println(item);
        }

        System.out.println("DOM PARSER\n");

        MyDOMParser myDOMParser = new MyDOMParser();
        myDOMParser.parse(xsdFilename, xmlFilename);

        ArrayList<AccountingPoint> accountingPoints2 = myDOMParser.getAccountingPoints();

        for(AccountingPoint item : accountingPoints2){
            System.out.println(item);
        }
    }
}

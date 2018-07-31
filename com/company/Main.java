package com.company;

import entity.AccountingPoint;
import org.xml.sax.SAXException;
import parser.MySAXParser;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        MySAXParser mySAXParser = new MySAXParser();
        mySAXParser.parse("D:\\Accounting points.xml");

        ArrayList<AccountingPoint> accountingPoints = mySAXParser.getAccountingPoints();

        for (AccountingPoint item : accountingPoints){
            System.out.println(item);
        }
    }
}

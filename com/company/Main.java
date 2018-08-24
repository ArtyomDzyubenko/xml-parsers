package com.company;

import entity.AccountingPoint;
import org.xml.sax.SAXException;
import parser.MySAXParser;
import parser.MyStAXParser;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        MySAXParser mySAXParser = new MySAXParser();
        //mySAXParser.parse("C:\\Users\\Artem\\IdeaProjects\\xml-parsers\\src\\Accounting points.xml");

        ArrayList<AccountingPoint> accountingPoints = mySAXParser.getAccountingPoints();

        /*for (AccountingPoint item : accountingPoints){
            System.out.println(item);
        }*/

        MyStAXParser myStaxParser = new MyStAXParser();
        myStaxParser.parse("C:\\Users\\Artem\\IdeaProjects\\xml-parsers\\src\\Accounting points.xml");

        ArrayList<AccountingPoint> accountingPoints1 = myStaxParser.getAccountingPoints();

        for (AccountingPoint item : accountingPoints1){
            System.out.println(item);
        }
    }
}

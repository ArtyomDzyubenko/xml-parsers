package parser;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {
    public  XSDValidator(){

    }

    public boolean validate(String xsdFilename, String xmlFilename){
        try{
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilename));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilename)));
        } catch (SAXException | IOException e){
            System.out.println("Invalid XML file!");
            return false;
        }

        return true;
    }
}

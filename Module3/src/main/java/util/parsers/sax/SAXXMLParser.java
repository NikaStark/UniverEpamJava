package util.parsers.sax;

import model.Dance;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class SAXXMLParser {

    private static Logger logger = Logger.getLogger(SAXXMLParser.class);
    private SAXParser saxParser;

    public SAXXMLParser(){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
        }catch (SAXException | ParserConfigurationException e){
            logger.error(e.getMessage());
        }
    }

    public List<Dance> getObjects(String path){
        DanceHandler handler = new DanceHandler();
        List<Dance> dances;
        XMLReader xmlReader;
        try{
            xmlReader = saxParser.getXMLReader();
        }catch(SAXException e){
            logger.error(e.getMessage());
            return null;
        }
        xmlReader.setContentHandler(handler);
        File xmlFile = new File(path);
        try {
            xmlReader.parse(xmlFile.toURI().toString());
        }catch (IOException | SAXException e){
            logger.error(e.getMessage());
            return null;
        }
        dances = handler.getDances();
        logger.debug("XML Document is parsed");
        return dances;
    }

}

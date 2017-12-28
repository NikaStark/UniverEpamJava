import model.exceptions.DiscrepancyXSDException;
import model.Dance;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import util.parsers.dom.DOMXMLParser;
import util.parsers.sax.SAXXMLParser;
import util.parsers.stax.StAXXMLParser;
import util.validator.XMLValidator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        String pathFileXML = "Module3\\src\\main\\resources\\dances.xml";
        String pathFileXSD = "Module3\\src\\main\\resources\\dance.xsd";

        try {
            XMLValidator.validateXMLByXSD(new File(pathFileXML), new File(pathFileXSD));

            DOMXMLParser domxmlParser = new DOMXMLParser();
            List<Dance> dancesDom = domxmlParser.read(pathFileXML);
            logger.debug("Dances objects are extracted from DOM parser:" + Arrays.deepToString(dancesDom.toArray()));

            SAXXMLParser saxXmlParser = new SAXXMLParser();
            List<Dance> dancesSax = saxXmlParser.getObjects(pathFileXML);
            logger.debug("Aircraft objects are extracted from SAX parser:" + Arrays.deepToString(dancesSax.toArray()));

            StAXXMLParser staxXmlParser = new StAXXMLParser();
            List<Dance> dancesStAX = staxXmlParser.getDances(pathFileXML);
            logger.debug("Aircraft objects are extracted from StAX parser:" + Arrays.deepToString(dancesStAX.toArray()));

        } catch (SAXException | IOException e) {
            logger.error(e.getMessage());
            throw new DiscrepancyXSDException(e);
        }
    }

}

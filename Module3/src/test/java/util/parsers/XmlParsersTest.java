package util.parsers;

import model.Dance;
import org.junit.Before;
import org.junit.Test;
import util.parsers.dom.DOMXMLParser;
import util.parsers.sax.SAXXMLParser;
import util.parsers.stax.StAXXMLParser;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlParsersTest {

    DOMXMLParser domXmlParser = null;
    SAXXMLParser saxXmlParser = null;
    StAXXMLParser staxXmlParser = null;
    List<Dance> danceDom = null;
    List<Dance> danceSax = null;
    List<Dance> danceStax = null;


    @Before
    public void beforeTesting(){
        String path = "src\\main\\resources\\dances.xml";
        domXmlParser = new DOMXMLParser();
        saxXmlParser = new SAXXMLParser();
        staxXmlParser = new StAXXMLParser();
        danceDom = domXmlParser.read(path);
        danceSax = saxXmlParser.getObjects(path);
        danceStax = staxXmlParser.getDances(path);
    }

    @Test
    public void testObjects(){
        assertEquals(danceDom.toString(), danceSax.toString());
        assertEquals(danceDom.toString(), danceStax.toString());
    }

}
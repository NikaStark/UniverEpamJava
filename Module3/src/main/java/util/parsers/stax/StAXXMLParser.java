package util.parsers.stax;

import model.Dance;
import model.Dancer;
import model.enums.Music;
import model.enums.NumberOfDancers;
import model.enums.Scene;
import model.enums.Type;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class StAXXMLParser {

    private static Logger logger = Logger.getLogger(StAXXMLParser.class);

    public List<Dance> getDances(String path) {
        logger.debug("Start parse XML...");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        List<Dance> dances = null;
        Dance dance = null;
        List<Dancer> dancers = null;
        Dancer dancer = null;
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case Dance.LIST_CLASS_TAG:
                            dances = new ArrayList<>();
                            break;
                        case Dance.CLASS_TAG:
                            dance = new Dance();
                            break;
                        case Dance.ID_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setId(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case Dance.TYPE_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setType(Type.parseType(xmlEvent.asCharacters().getData()));
                            break;
                        case Dance.SCENE_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setScene(Scene.parseScene(xmlEvent.asCharacters().getData()));
                            break;
                        case Dance.NUMBER_OF_DANCERS_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setNumberOfDancers(NumberOfDancers.parseNumberOfDancers(xmlEvent.asCharacters().getData()));
                            break;
                        case Dance.MUSIC_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setMusic(Music.parseMusic(xmlEvent.asCharacters().getData()));
                            break;
                        case Dance.ORDER_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dance.setOrder(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case Dancer.LIST_CLASS_TAG:
                            dancers = new ArrayList<>();
                            break;
                        case Dancer.CLASS_TAG:
                            dancer = new Dancer();
                        case Dancer.NAME_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dancer.setName(xmlEvent.asCharacters().getData());
                            break;
                        case Dancer.AGE_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dancer.setAge(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case Dancer.WORKING_AGE_FIELD_TAG:
                            xmlEvent = xmlEventReader.nextEvent();
                            dancer.setWorkingAge(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()) {
                        case Dance.CLASS_TAG:
                            dances.add(dance);
                            break;
                        case Dancer.CLASS_TAG:
                            dancers.add(dancer);
                            break;
                        case Dancer.LIST_CLASS_TAG:
                            dance.setDancers(dancers);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error(e.getMessage());
        }
        logger.debug("XML Document is parsed");
        return dances;
    }

}

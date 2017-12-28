package util.parsers.sax;

import model.Dance;
import model.Dancer;
import model.enums.Music;
import model.enums.NumberOfDancers;
import model.enums.Scene;
import model.enums.Type;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class DanceHandler extends DefaultHandler {

    private static Logger logger = Logger.getLogger(DanceHandler.class);
    private List<Dance> dances;
    private Dance dance;
    private List<Dancer> dancers;
    private Dancer dancer;

    private boolean bId;
    private boolean bType;
    private boolean bScene;
    private boolean bNumberOfDancers;
    private boolean bMusic;
    private boolean bOrder;
    private boolean bName;
    private boolean bAge;
    private boolean bWorkingAge;

    public List<Dance> getDances() {
        return this.dances;
    }

    @Override
    public void startDocument() throws SAXException {
        logger.debug("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case Dance.LIST_CLASS_TAG:
                dances = new ArrayList<>();
                break;
            case Dance.CLASS_TAG:
                dance = new Dance();
                break;
            case Dance.ID_FIELD_TAG:
                bId = true;
                break;
            case Dance.TYPE_FIELD_TAG:
                bType = true;
                break;
            case Dance.SCENE_FIELD_TAG:
                bScene = true;
                break;
            case Dance.NUMBER_OF_DANCERS_FIELD_TAG:
                bNumberOfDancers = true;
                break;
            case Dance.MUSIC_FIELD_TAG:
                bMusic = true;
                break;
            case Dance.ORDER_FIELD_TAG:
                bOrder = true;
                break;
            case Dancer.LIST_CLASS_TAG:
                dancers = new ArrayList<>();
                break;
            case Dancer.CLASS_TAG:
                dancer = new Dancer();
                break;
            case Dancer.NAME_FIELD_TAG:
                bName = true;
                break;
            case Dancer.AGE_FIELD_TAG:
                bAge = true;
                break;
            case Dancer.WORKING_AGE_FIELD_TAG:
                bWorkingAge = true;
                break;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bId) {
            dance.setId(Integer.parseInt(new String(ch, start, length)));
            bId = false;
        } else if (bType) {
            dance.setType(Type.parseType(new String(ch, start, length)));
            bType = false;
        } else if (bScene) {
            dance.setScene(Scene.parseScene(new String(ch, start, length)));
            bScene = false;
        } else if (bNumberOfDancers) {
            dance.setNumberOfDancers(NumberOfDancers.parseNumberOfDancers(new String(ch, start, length)));
            bNumberOfDancers = false;
        } else if (bMusic) {
            dance.setMusic(Music.parseMusic(new String(ch, start, length)));
            bMusic = false;
        } else if (bOrder) {
            dance.setOrder(Integer.valueOf(new String(ch, start, length)));
            bOrder = false;
        } else if (bName) {
            dancer.setName(new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            dancer.setAge(Integer.valueOf(new String(ch, start, length)));
            bAge = false;
        } else if (bWorkingAge) {
            dancer.setWorkingAge(Integer.valueOf(new String(ch, start, length)));
            bWorkingAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
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
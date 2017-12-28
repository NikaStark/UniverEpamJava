package util.parsers.dom;

import model.Dance;
import model.Dancer;
import model.enums.Music;
import model.enums.NumberOfDancers;
import model.enums.Scene;
import model.enums.Type;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class DOMXMLParser {

    private static Logger logger = Logger.getLogger(DOMXMLParser.class);

    private DocumentBuilder db;

    public DOMXMLParser() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("DocumentBuilder exception" + e.getMessage());
        }
    }

    public List<Dance> read(String path) {
        List<Dance> dances = new ArrayList<>();
        Document doc;
        try {
            doc = db.parse(new File(path));
            logger.debug("Document from file " + path + " is created");

        } catch (Exception e) {
            logger.error("Document from file " + path + "doesn't created " + e.getMessage());
            return Collections.emptyList();
        }

        Element root = doc.getDocumentElement();

        if (root.getTagName().equals(Dance.LIST_CLASS_TAG)) {
            NodeList dancesList = root.getElementsByTagName(Dance.CLASS_TAG);
            for (int i = 0; i < dancesList.getLength(); i++) {
                Dance dance = new Dance();
                Element danceElement = (Element) dancesList.item(i);
                dance.setId(Integer.valueOf(danceElement.getElementsByTagName(Dance.ID_FIELD_TAG).item(0).getTextContent()));
                dance.setType(Type.parseType(danceElement.getElementsByTagName(Dance.TYPE_FIELD_TAG).item(0).getTextContent()));
                dance.setScene(Scene.parseScene(danceElement.getElementsByTagName(Dance.SCENE_FIELD_TAG).item(0).getTextContent()));
                dance.setNumberOfDancers(NumberOfDancers.parseNumberOfDancers(danceElement.
                        getElementsByTagName(Dance.NUMBER_OF_DANCERS_FIELD_TAG).item(0).getTextContent()));
                dance.setMusic(Music.parseMusic(danceElement.getElementsByTagName(Dance.MUSIC_FIELD_TAG).item(0).getTextContent()));
                dance.setOrder(Integer.valueOf(danceElement.getElementsByTagName(Dance.ORDER_FIELD_TAG).item(0).getTextContent()));

                NodeList dancersList = danceElement.getElementsByTagName(Dancer.CLASS_TAG);
                ArrayList<Dancer> dancers = new ArrayList<>();
                for (int j = 0; j < dancersList.getLength(); j++) {
                    Dancer dancer = new Dancer();
                    Element dancerElement = (Element) dancersList.item(j);
                    dancer.setName(dancerElement.getElementsByTagName(Dancer.NAME_FIELD_TAG).item(0).getTextContent());
                    dancer.setAge(Integer.valueOf(dancerElement.getElementsByTagName(Dancer.AGE_FIELD_TAG).
                            item(0).getTextContent()));
                    dancer.setWorkingAge(Integer.valueOf(dancerElement.getElementsByTagName(Dancer.WORKING_AGE_FIELD_TAG).
                            item(0).getTextContent()));
                    dancers.add(dancer);
                }
                dance.setDancers(dancers);
                dances.add(dance);
            }
            logger.debug("XML Document is parsed");
        }
        return dances;

    }
}
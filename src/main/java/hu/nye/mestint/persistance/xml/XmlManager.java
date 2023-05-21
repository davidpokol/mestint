package hu.nye.mestint.persistance.xml;

import hu.nye.mestint.model.table.Tables;
import hu.nye.mestint.util.ArrayUtil;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlManager {

    private static final String FILE_NAME = "tables.xml";

    public Tables getTables() {

        Tables tables;
        try {
            File file = new File(FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Tables.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            tables = (Tables) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException | RuntimeException e) {
            e.printStackTrace();
            tables = null;
        }
        return tables;
    }
}

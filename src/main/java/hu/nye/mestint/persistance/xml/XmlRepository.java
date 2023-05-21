package hu.nye.mestint.persistance.xml;
import hu.nye.mestint.model.table.Tables;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlRepository {


    private Tables tables;
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    private static final String FILE_NAME = "table.xml";

    public XmlRepository(Tables tables, Marshaller marshaller, Unmarshaller unmarshaller) {
        this.tables = tables;
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    private void load() {
        try {

            tables = (Tables) unmarshaller.unmarshal(new File(FILE_NAME));

        } catch (JAXBException e) {
            initXml();
            e.printStackTrace();

        }
    }

    private void initXml() {
        try {
            marshaller.marshal(tables, new File(FILE_NAME));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

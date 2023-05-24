package hu.nye.mestint.persistance.xml;

import hu.nye.mestint.model.table.Tables;
import hu.nye.mestint.service.TableValidator;
import hu.nye.mestint.service.exception.TableSizeException;
import hu.nye.mestint.util.ArrayUtil;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlManager {

    private static final String FILE_NAME = "tables.xml";
    private final TableValidator tableValidator = new TableValidator();
    private final ArrayUtil arrayUtil = new ArrayUtil();

    public Tables getTables() {

        Tables tables;
        try {
            File file = new File(FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Tables.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            tables = (Tables) jaxbUnmarshaller.unmarshal(file);

            String[][] initTable = arrayUtil.convertTableToStringArray(tables.getInitialTable());
            String[][] endTable = arrayUtil.convertTableToStringArray(tables.getEndTable());

            tableValidator.validate(initTable);
            tableValidator.validate(endTable);
            tableValidator.compare(initTable.length, endTable.length);

        } catch (JAXBException | TableSizeException e) {
            e.printStackTrace();
            tables = null;
        }
        return tables;
    }
}
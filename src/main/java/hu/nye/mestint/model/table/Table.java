package hu.nye.mestint.model.table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Table {
    @XmlElement(name = "row")
    private List<Row> rows;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Setter
    static public class Row {
        @XmlElement(name = "element")
        private List<String> elements;
    }
}
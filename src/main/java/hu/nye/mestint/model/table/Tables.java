package hu.nye.mestint.model.table;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class Tables {
    @XmlElement(name = "init-table")
    private Table initialTable;
    @XmlElement(name = "end-table")
    private Table endTable;
}
package ru.nvg.simple.entities;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Package")
@JacksonXmlRootElement(localName = "package")
public final class Package {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private String id;

    @OneToMany(mappedBy = "aPackage", cascade = CascadeType.ALL)
    @JacksonXmlElementWrapper(localName = "doc")
    private List<Doc> docs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }
}

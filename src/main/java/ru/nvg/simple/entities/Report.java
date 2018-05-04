package ru.nvg.simple.entities;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import ru.nvg.simple.data.GetXML;

import java.util.List;

@JacksonXmlRootElement(localName = "report")
public class Report {
    @JacksonXmlElementWrapper(localName = "package")
    private List<Package> packages;

    private GetXML getXML;

    public Report(List<Package> packages) {
        this.packages = packages;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public GetXML getGetXML() {
        return getXML;
    }

    public void setGetXML(GetXML getXML) {
        this.getXML = getXML;
    }
}

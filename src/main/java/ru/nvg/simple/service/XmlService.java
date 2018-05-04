package ru.nvg.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nvg.simple.model.XMLOperations;

@RestController
public class XmlService {

    @Autowired
    XMLOperations xmlOperations;

    @RequestMapping("/start")
    String startLoadXML() {
        //xmlOperations.loadXMLs();
        return null;
    }

    @RequestMapping("/stop")
    String stopLoadXML() {
        return null;
    }
}

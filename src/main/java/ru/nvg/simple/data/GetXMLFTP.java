package ru.nvg.simple.data;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.nvg.simple.entities.Report;

@Component
@Scope(value="singleton")
public class GetXMLFTP implements GetXML {

    @Override
    public Report getXML() {
        return null;
    }

    @Override
    public boolean confirmSave(Report report) {
        return false;
    }
}

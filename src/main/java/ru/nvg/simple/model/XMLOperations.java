package ru.nvg.simple.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.nvg.simple.data.GetXMLPool;
import ru.nvg.simple.data.dao.interfaces.DocDAO;
import ru.nvg.simple.data.dao.interfaces.PackageDAO;
import ru.nvg.simple.entities.Report;

@Component
public class XMLOperations {

    private static Log log = LogFactory.getLog(XMLOperations.class);

    @Autowired
    private DocDAO docDAO;

    @Autowired
    private PackageDAO packageDAO;

    @Autowired
    private GetXMLPool getXMLPool;

    @Transactional
    public void saveDBXML(Report report) {
        //здесь может использовать очистка сессии
        report.getPackages().stream().forEach(p->packageDAO.savePackage(p));
        //сообщаем источнику что всё успешно сохранили и можно удалить данный XML
        report.getGetXML().confirmSave(report);

    }

    public void loadXMLs(){
        try {
            while (true) {
                Report report = getXMLPool.getXMLfromPool();
                if (report == null) break;
                saveDBXML(report);
            }
        }
        catch (Exception e)
        {
            log.error("Ошибка при загрузке данных" + e);
            //Выход
            return;
        }
    }
}

package ru.nvg.simple.data;


import ru.nvg.simple.entities.Report;

public interface GetXML {
    //получение XML от источника
    Report getXML();
    //сообщаем источнику что всё успешно сохранили и можно удалить данный XML или пометить его загруженным
    //всё зависит от того какая нужна реализация для определённого источника
    boolean confirmSave(Report report);
}

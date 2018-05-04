package ru.nvg.simple.data;


import ru.nvg.simple.entities.Report;

import java.util.List;


public class GetXMLPool {
    private List<GetXML> getXMLs;

    public GetXMLPool(List<GetXML> getXMLs) {
        this.getXMLs = getXMLs;
    }

    public List<GetXML> getGetXMLs() {
        return getXMLs;
    }

    public void setGetXMLs(List<GetXML> getXMLs) {
        this.getXMLs = getXMLs;
    }


    public Report getXMLfromPool()
    {
        long cntBeans = getXMLs.stream().count();

        int i=0;
        while(i<cntBeans) {
            Report report = getXMLs.get(i).getXML();
            if(report==null){ //если XML нет переходим к следующему источнику
                i++;
            } else {
                //для того чтобы знать от какого источника пришла XML
                report.setGetXML(getXMLs.get(i));
                return report;
            }
        }

        return null;
    }
}

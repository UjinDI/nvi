package ru.nvg.simple;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.nvg.simple.data.GetXML;
import ru.nvg.simple.data.GetXMLFTP;
import ru.nvg.simple.data.GetXMLPool;
import ru.nvg.simple.model.XMLOperations;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class StartServiceApplication implements CommandLineRunner {

    private static Log logger = LogFactory.getLog(StartServiceApplication.class);

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    XMLOperations xmlOperations;

    @Bean
    @Scope("singletone")
    public GetXMLPool getXMLPool(){
        List<GetXML> getXMLs = new ArrayList<>();
        getXMLs.add(appContext.getBean(GetXMLFTP.class));
        //здесь можно добавить разные реализации
        return new GetXMLPool(getXMLs);
    }

    @Override
    public void run(String... args) {
        xmlOperations.loadXMLs();
    }

    public static void main(String[] args) {
        SpringApplication.run(StartServiceApplication.class, args);
    }

}

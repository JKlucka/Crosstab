package com.garrett;
import com.garrett.Workbook.LoadWorkbook;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
	String path = "C:\\Users\\Jara\\Desktop\\test\\test.xlsx";

	LoadWorkbook wb = new LoadWorkbook(path);
    /* 
	try {
        CreateWorkbook crt = new CreateWorkbook(wb.getDataList(), "FailureModeCausesSymptom");
    }
    catch (IOException e) { e.printStackTrace(); }
	*/
        // PropertyConfigurator.configure("/Config/log4j.properties");
       // BasicConfigurator.configure();
        String log4jConfPath = "C:\\Users\\Jara\\IdeaProjects\\CrosstabReport\\src\\main\\resources\\Config\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);log.info("Log test");

	
    }
    
    static Logger log = Logger.getLogger(Main.class);
}

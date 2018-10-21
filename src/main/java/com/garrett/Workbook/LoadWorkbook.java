package com.garrett.Workbook;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class LoadWorkbook {
    private Workbook wb;
    private Sheet sheet;
    private List<List<String>> dataList = new ArrayList<>();

    public LoadWorkbook(String pathFile) {

        Properties config = new Properties();
        String configFile = "/Config/config.properties";

        System.out.println(LoadWorkbook.class. getName());
        InputStream inputStream = LoadWorkbook.class.getResourceAsStream(configFile);

        try {
            if(inputStream != null) {
                config.load(inputStream);
            }
            else
                throw new FileNotFoundException("Zlo");

            wb = WorkbookFactory.create(new FileInputStream(new File(config.getProperty("inputFilePath"))));
            //wb = WorkbookFactory.create(new FileInputStream(new File(pathFile)));
            sheet = wb.getSheetAt(0);
        }
        catch (FileNotFoundException e1) {
            System.out.println("FileNotFound");
        }
        catch (IOException e2) {
            System.out.println("IO");
        }
        catch (InvalidFormatException e3) {
            System.out.println("Invalid Format");
        }

        fillDataList();
    }

    public List<String> getRowList(int num) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < sheet.getRow(num).getLastCellNum(); i++) {
            list.add(sheet.getRow(num).getCell(i).toString());
        }
        return list;
    }

    public List<String> getColumnList(int num) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            list.add(sheet.getRow(i).getCell(num).toString());
        }
        return list;
    }

    public Set<String> getColumnSet(int num) {
        Set<String> list = new HashSet<>();
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            list.add(sheet.getRow(i).getCell(num).toString());
        }
        return list;
    }

    public Workbook getWorkBook() {
        return wb;
    }

    private void fillDataList() {
        for(int i = 1; i <= sheet.getLastRowNum(); i++) {
            List<String> rowList= new ArrayList<>();
            for(int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
                rowList.add(sheet.getRow(i).getCell(j).toString());
            }
            dataList.add(rowList);
        }
        System.out.println(dataList.size());
    }

    public List<List<String>> getDataList() {
        return dataList;
    }
}

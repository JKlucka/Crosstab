package com.garrett.Workbook;

import com.garrett.Entity.Entity;

import com.garrett.Entity.FailureMode;
import com.garrett.Entity.Symptom;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class CreateWorkbook {
    List<List<String>> dataList;
    private Workbook wb = new XSSFWorkbook();
    private String relName;
    private Sheet sheet;

    private Entity fm;
    private Entity sym;

    private final String outputFile = "C:\\Users\\Jara\\Desktop\\test\\new.xlsx";
    CellStyle axisCellStyle = wb.createCellStyle();
    Font headerFont = wb.createFont();

    public CreateWorkbook(List<List<String>> dataList, String relName) throws  IOException {
        this.dataList = dataList;
        this.relName = relName;
        sheet = wb.createSheet(relName);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        axisCellStyle.setFont(headerFont);
        axisCellStyle.setWrapText(true);
        fm = new FailureMode(dataList, relName);
        sym = new Symptom(dataList, relName);

        this.writeX();
        this.writeY();
        this.writeRelations();
        this.writeFile();
    }

    public void writeFile() throws IOException
    {
        FileOutputStream newWb = new FileOutputStream(outputFile);
        wb.write(newWb);
        newWb.close();
    }

    private void writeX() {
        int i = 1;
        for(String key : fm.getEntityMap().keySet()) {
            Row firstRow = sheet.createRow(i);
            Cell cell = firstRow.createCell(0);
            cell.setCellStyle(axisCellStyle);
            cell.setCellValue(key);
            i++;
        }
    }

    private void writeY() {
        Row firstRow = sheet.createRow(0);
        int i = 1;
        for(String key : sym.getEntityMap().keySet()) {
            Cell cell = firstRow.createCell(i);
            cell.setCellStyle(axisCellStyle);
            cell.setCellValue(key);
            i++;
        }
    }

    private void writeRelations() {
        int rowNum = 1;
        for(Map.Entry<String, String> mFm : fm.getEntityMap().entrySet()) {
            Row r = sheet.createRow(rowNum);
            for (List<String> lst : dataList) {
                // create method to cover
                Cell cellY = r.createCell(0);
                cellY.setCellStyle(axisCellStyle);
                cellY.setCellValue(mFm.getKey());
                if(lst.get(0).equalsIgnoreCase(relName)  && lst.get(2).equals(mFm.getValue())) {
                    int colNum = 1;
                    for(Map.Entry<String, String> mS : sym.getEntityMap().entrySet()) {
                        if(mS.getValue().equals(lst.get(6))) {
                            break;
                        }
                        else
                            colNum++;

                    }
                    //System.out.println("[Row: " + rowNum + " ; " + colNum + "]" );
                    Cell cell = r.createCell(colNum);
                    cell.setCellStyle(axisCellStyle);
                    cell.setCellValue("X");
                }
                    else
                        continue;
            }
            rowNum++;

        }

    }
}

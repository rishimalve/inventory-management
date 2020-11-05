package com.example.inventorymanagementbackend.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExcelFileUpload {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "id", "Name", "Price", "Type", "Medium", "Dimensions", "ImgPath" };

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType()))
            return false;

        return true;

    }

    public static List<Painting> readFromExcel(InputStream is) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Painting> paintings = new ArrayList<Painting>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Painting pobj = new Painting();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            pobj.setName(currentCell.getStringCellValue());
                            break;

                        case 4:
                            pobj.setPrice(currentCell.getNumericCellValue());
                            break;

                        case 1:
                            pobj.setType(currentCell.getStringCellValue());
                            break;

                        case 2:
                            pobj.setMedium(currentCell.getStringCellValue());
                            break;

                        case 3:
                            pobj.setDimensions(currentCell.getStringCellValue());
                            break;

                        case 5:
                            pobj.setImgPath(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }
                    cellIdx++;
                }

                paintings.add(pobj);
            }

            return paintings;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed to parse Excel file: " + e.getMessage());
        }
    }

}

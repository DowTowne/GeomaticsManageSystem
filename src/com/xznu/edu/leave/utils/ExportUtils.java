package com.xznu.edu.leave.utils;

import com.google.gson.Gson;
import com.xznu.edu.leave.model.Equipment;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.struts2.ServletActionContext;
import org.eclipse.swt.widgets.DateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

public class ExportUtils {

    public static String export(List<Equipment> list, HttpServletRequest request) throws IOException {
        // 生成Workbook
        HSSFWorkbook wb = new HSSFWorkbook();
        // 追加Sheet
        Sheet sheet = wb.createSheet("Sheet");
        // 总列数
        Integer CountColumnNum = 6;
        Cell[] firstCell = new Cell[CountColumnNum];
        String[] firstCellNames = new String[CountColumnNum];
        firstCellNames[0] = "设备型号";
        firstCellNames[1] = "设备价格";
        firstCellNames[2] = "设备制造商";
        firstCellNames[3] = "设备序列号";
        firstCellNames[4] = "服务开始时间";
        // 插入行
        Row firstRow = sheet.createRow(0);
        for (int j = 0; j < CountColumnNum; j++) {
            firstCell[j] = firstRow.createCell(j);
            firstCell[j].setCellValue(new HSSFRichTextString(firstCellNames[j]));
        }
        BigDecimal bd;
        for (int i = 0; i < list.size(); i++) {
            // 创建一行
            Row row = sheet.createRow(i + 1);
            Cell id = row.createCell(0);
            id.setCellValue(list.get(i).getXh().toString());
            bd = new BigDecimal(list.get(i).getJg().toString());
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            Cell by = row.createCell(1);
            by.setCellValue(bd.toString());
            Cell zzs = row.createCell(2);
            zzs.setCellValue(list.get(i).getZzs().toString());
            Cell xh = row.createCell(3);
            xh.setCellValue(list.get(i).getXh().toString());
            Cell sj = row.createCell(4);
            sj.setCellValue(list.get(i).getFwTime().toString());
        }
        // 创建文件输出流，准备输出电子表格
        String realPath = request.getServletContext().getRealPath("excel");
        FileOutputStream out = null;
        String fileName = "sorry：导出异常";
        try {
            fileName = System.currentTimeMillis() + ".xls";
            out = new FileOutputStream(realPath + "/" + fileName);
            wb.write(out);
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return "excel/" + fileName;
    }
}

package com.ssm.chapter14.view;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {
    void makeWorkBook(Map<String, Object> model, Workbook workBook);
}

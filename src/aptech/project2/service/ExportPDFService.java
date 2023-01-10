/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.common.FileCommon;
import aptech.project2.constant.Constant1;
import aptech.project2.dao.Orders;
import aptech.project2.jasper.JasperPrintService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author PC
 */
public class ExportPDFService {
    
    private final JasperPrintService jasperPrintService;
    
    public ExportPDFService() {
        this.jasperPrintService = new JasperPrintService();
    }
    
    public String requestInvoicePdf(Orders order) throws Exception {
        List<Orders> lst = new ArrayList<>();
        String file = null;
        JasperPrint jp;
        try {
            FileCommon fileUtils = new FileCommon();
            File invoice = fileUtils.getFileFromResource(Constant1.INVOICE_TEMPLATE_FILE);
            System.out.println("logggggg: " + invoice.toString());
            File bill = fileUtils.getFileFromResource(Constant1.INVOICE_EXPORT_FILE);
            System.out.println("logggggg22: " + bill.toString());
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(lst);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ItemDataSource", itemsJRBean);
            parameters.put("cashier", "Thành");
            parameters.put("customerName", "test"); 
            parameters.put("customerAddress", "Hà Nội");
            parameters.put("customerPhone", "0987654321");
            parameters.put("invoiceNumber", 1);
            parameters.put(JRParameter.REPORT_LOCALE, new Locale("vi", "VN"));

            InputStream input = new FileInputStream(invoice);
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jp = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            FileUtils.writeByteArrayToFile(bill, jasperPrintService.exportReportXlsx(jp));
            file = bill.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }
    public static void main(String[] args) {
        ExportPDFService ex = new ExportPDFService();
        Orders o = new Orders();
        o.setId(1);
        o.setAmount(new BigDecimal(1));
        o.setData("abcd");
        try {
            ex.requestInvoicePdf(o);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
}

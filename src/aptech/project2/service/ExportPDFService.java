/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service;

import aptech.project2.common.FileCommon;
import aptech.project2.constant.Constant;
import aptech.project2.model.Orders;
import aptech.project2.jasper.JasperPrintService;
import aptech.project2.jasper.OrderResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        List<OrderResponse> lst = new ArrayList<>();
        OrderResponse or = new OrderResponse();
        or.setProductName(order.getProductId().getName());
        or.setProductPrice(order.getProductId().getPrice());
        or.setQuantity(order.getQuantity());
        or.setTotalAmount(order.getTotal());
        lst.add(or);
        String file = null;
        JasperPrint jp;
        try {
            FileCommon fileUtils = new FileCommon();
            File invoice = fileUtils.getFileFromResource(Constant.INVOICE_TEMPLATE_FILE);
            File bill = fileUtils.getFileFromResource(Constant.INVOICE_EXPORT_FILE);
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(lst);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ItemDataSource", itemsJRBean);
            parameters.put("cashier", order.getCustomerName());
            parameters.put("customerName", order.getCustomerName()); 
            parameters.put("customerAddress", order.getCustomerAddress());
            parameters.put("customerPhone", order.getCustomerPhone());
            parameters.put("invoiceNumber", order.getOrderNo());
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
}

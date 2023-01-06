/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 *
 * @author PC
 */
public class JasperPrintService {
    

    public JasperPrintService() {
        // empty contructor
    }


    /**
     * Returns PDF report as byte[]
     *
     * @param jasperPrint
     * @return byte[]
     * @throws JRException
     */
    public byte[] exportReportPdf(final JasperPrint jasperPrint) throws Exception {
        final JRPdfExporter pdfExporter = new JRPdfExporter();
        final byte[] rawBytes;

        try (final ByteArrayOutputStream pdfReport = new ByteArrayOutputStream()) {
            pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReport));
            pdfExporter.exportReport();

            rawBytes = pdfReport.toByteArray();
        } catch (JRException | IOException e) {
            throw new Exception(e.getMessage());
        }
        return rawBytes;
    }

    /**
     * Returns xlsx report as byte[]
     *
     * @param jasperPrint
     * @return byte[]
     * @throws JRException
     * @throws IOException
     */
    public byte[] exportReportXlsx(final JasperPrint jasperPrint, final String sheetName) throws Exception {
        final JRXlsxExporter xlsxExporter = new JRXlsxExporter();
        final byte[] rawBytes;

        try (final ByteArrayOutputStream xlsReport = new ByteArrayOutputStream()) {
            SimpleXlsxReportConfiguration reportConfig
                    = new SimpleXlsxReportConfiguration();
            reportConfig.setSheetNames(new String[] { sheetName });
            xlsxExporter.setConfiguration(reportConfig);
            xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
            xlsxExporter.exportReport();

            rawBytes = xlsReport.toByteArray();
        } catch (JRException | IOException e) {
            throw new Exception(e.getMessage());
        }

        return rawBytes;
    }

    public byte[] exportReportXlsxMultiSheet(final JasperPrint jasperPrint, final String[] sheetNames) throws Exception {
        final JRXlsxExporter xlsxExporter = new JRXlsxExporter();
        final byte[] rawBytes;

        try (final ByteArrayOutputStream xlsReport = new ByteArrayOutputStream()) {
            SimpleXlsxReportConfiguration reportConfig
                    = new SimpleXlsxReportConfiguration();
            reportConfig.setSheetNames(sheetNames);
            xlsxExporter.setConfiguration(reportConfig);
            xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
            xlsxExporter.exportReport();

            rawBytes = xlsReport.toByteArray();
        } catch (JRException | IOException e) {
            throw new Exception(e.getMessage());
        }

        return rawBytes;
    }

    public byte[] exportReportXlsx(final JasperPrint jasperPrint) throws Exception {
        final JRXlsxExporter xlsxExporter = new JRXlsxExporter();
        final byte[] rawBytes;

        try (final ByteArrayOutputStream xlsReport = new ByteArrayOutputStream()) {
            SimpleXlsxReportConfiguration reportConfig
                    = new SimpleXlsxReportConfiguration();
            xlsxExporter.setConfiguration(reportConfig);
            xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
            xlsxExporter.exportReport();

            rawBytes = xlsReport.toByteArray();
        } catch (JRException | IOException e) {
            throw new Exception(e.getMessage());
        }

        return rawBytes;
    }

    /**
     * Returns docx report as byte[]
     *
     * @param jasperPrint
     * @return byte[]
     * @throws JRException
     * @throws IOException
     */
    public byte[] exportReportDocx(final JasperPrint jasperPrint) throws Exception {
        final JRDocxExporter docxExporter = new JRDocxExporter();
        final byte[] rawBytes;

        try (final ByteArrayOutputStream docxReport = new ByteArrayOutputStream()) {
            docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxReport));
            SimpleDocxReportConfiguration config = new SimpleDocxReportConfiguration();
            docxExporter.setConfiguration(config);
            docxExporter.exportReport();

            rawBytes = docxReport.toByteArray();
        } catch (JRException | IOException e) {
            throw new Exception(e.getMessage());
        }

        return rawBytes;
    }
}


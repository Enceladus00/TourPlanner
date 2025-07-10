package com.cgproject.tourguide.util;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PdfGenerator {
    private static final Logger logger = LogManager.getLogger(PdfGenerator.class);

    public void generateTourPdf(String filePath, String tourName, String from, String to,
                                String transportType, double estimatedTime, double distance, String description) throws IOException {

        logger.info("Starting PDF generation for tour: {}", tourName);
        logger.debug("PDF will be saved to: {}", filePath);

        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            logger.debug("Adding tour details to PDF document");
            document.add(new Paragraph("Tour Details").setBold().setFontSize(16));
            document.add(new Paragraph("Tour Name: " + tourName));
            document.add(new Paragraph("From: " + from));
            document.add(new Paragraph("To: " + to));
            document.add(new Paragraph("Transport Type: " + transportType));
            document.add(new Paragraph("Estimated Time: " + estimatedTime + " hours"));
            document.add(new Paragraph("Distance: " + distance + " km"));
            document.add(new Paragraph("Description: " + description));

            document.close();
            logger.info("Successfully generated PDF for tour: {} at {}", tourName, filePath);

        } catch (IOException e) {
            logger.error("Failed to generate PDF for tour: {}. Error: {}", tourName, e.getMessage());
            throw e;
        }
    }
}
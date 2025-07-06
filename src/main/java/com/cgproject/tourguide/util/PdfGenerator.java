package com.cgproject.tourguide.util;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class PdfGenerator {

    public void generateTourPdf(String filePath, String tourName, String from, String to, String transportType, double estimatedTime, double distance, String description) throws IOException {
        // Create a PdfWriter instance
        PdfWriter writer = new PdfWriter(filePath);

        // Create a PdfDocument instance
        PdfDocument pdfDocument = new PdfDocument(writer);

        // Create a Document instance
        Document document = new Document(pdfDocument);

        // Add tour details to the document
        document.add(new Paragraph("Tour Details").setBold().setFontSize(16));
        document.add(new Paragraph("Tour Name: " + tourName));
        document.add(new Paragraph("From: " + from));
        document.add(new Paragraph("To: " + to));
        document.add(new Paragraph("Transport Type: " + transportType));
        document.add(new Paragraph("Estimated Time: " + estimatedTime + " hours"));
        document.add(new Paragraph("Distance: " + distance + " km"));
        document.add(new Paragraph("Description: " + description));

        // Close the document
        document.close();

        System.out.println("Tour PDF generated successfully at: " + filePath);
    }
}
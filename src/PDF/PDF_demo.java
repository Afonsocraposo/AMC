package PDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;


 
public class PDF_demo {
 
    public static final String DEST
        = "results_pdf/test2.pdf";
 
    public static void main(String[] args)
    	throws DocumentException, IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
    	new PDF_demo().createPdf(DEST);
    }
 
    
    public void createPdf(String dest)
	    throws DocumentException, IOException {
    	
    	Font title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30);
    	title.setColor(new BaseColor(39, 140, 153));
    	Font subtitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
    	Font h3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
    	Font h4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
    	Font p = FontFactory.getFont(FontFactory.HELVETICA, 12);
    	
    	
    	PdfPCell cell;
 	
    	Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        String para1 = "MEDICINE FOR DUMMIES";
        String para2 = "Medical Report";     
        String para3 = "BREAST CANCER EXAM:";   
        	      
        // Creating Paragraphs       
        Paragraph paragraph1 = new Paragraph(para1,title); 
        paragraph1.setIndentationLeft(120);
        Paragraph paragraph2 = new Paragraph(para2,subtitle);
        paragraph2.setIndentationLeft(120);
        Paragraph paragraph3 = new Paragraph(para3,h3);

        
        
// ------------------ CLIENT TABLE ----------------------
        
        //Create the table which will be 8 Columns wide and make it 100% of the page
        PdfPTable clientTable = new PdfPTable(8);
        clientTable.setWidthPercentage(100.0f);

        
        // Create cells to add to table
        
        cell = new PdfPCell(new Paragraph("Client Identification",h3));
        cell.setColspan(8);
        cell.setBorder(PdfPCell.TOP);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("Name:",h4));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Afonso Raposo",p));
        cell.setColspan(3);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Gender:",h4));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("M",p));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Age:",h4));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("20",p));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(" ",p));
        cell.setColspan(4);
        cell.setBorder(PdfPCell.NO_BORDER);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Date of Birth:",h4));
        cell.setColspan(2);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("1997-10-07",p));
        cell.setColspan(2);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Responsible",h3));
        cell.setColspan(8);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Doctor:",h4));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Unkown",h4));
        cell.setColspan(7);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph(" ",p));
        cell.setColspan(8);
        cell.setBorder(PdfPCell.NO_BORDER);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Diagnostic Exam",h4));
        cell.setColspan(6);
        cell.setBorder(PdfPCell.BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Date/Time",h4));
        cell.setColspan(2);
        cell.setBorder(PdfPCell.BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("BREAST CANCER",h3));
        cell.setColspan(6);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        clientTable.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("2018-05-13   16:34",p));
        cell.setColspan(2);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        clientTable.addCell(cell);
        
 // ------------------ END CLIENT TABLE -----------------
        
        
        
        
// ------------------ SIGNS TABLE ----------------------
        
        //Create the table which will be 8 Columns wide and make it 100% of the page
        PdfPTable signsTable = new PdfPTable(2);
        signsTable.setWidthPercentage(30);
        
        cell = new PdfPCell(new Paragraph("Doctor:",h4));
        cell.setColspan(1);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        signsTable.addCell(cell);
        
        
        
// ------------------ END SIGNS TABLE -----------------
        

        // Creating Images
        Image img = Image.getInstance("images/logo.png");
        img.scalePercent(20);
        img.setAbsolutePosition(60, document.getPageSize().getHeight()-120);
       
        // Adding images to document
        document.add(img);
        
        // Adding paragraphs to document       
        document.add(paragraph1);       
        document.add(paragraph2); 
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        // Adding table
        document.add(clientTable);
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(paragraph3);
        
        // Adding table
        document.add(signsTable);
        
        
        
        
        
        document.close();
      
        System.out.println("All goodie!");
    
    }
    
}

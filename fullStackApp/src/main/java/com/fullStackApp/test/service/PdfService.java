package com.fullStackApp.test.service;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
		
	Logger logger= LoggerFactory.getLogger(PdfService.class);
	public ByteArrayInputStream createPdf()
	{
		logger.info("create Pdf Started :  ");
		String tilte="Welcome to learn code";
		String content="Code with Sachin, we provide technical content";
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Document document=new Document();
		PdfWriter.getInstance(document, out);
		document.open();
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Paragraph titlePara=new Paragraph(tilte,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		Font paraFont=FontFactory.getFont(FontFactory.HELVETICA,18);
		Paragraph paragraph=new Paragraph(content);
		paragraph.add(new Chunk("Wow this text isa added After creating paragraph"));
		document.add(titlePara);
		document.add(paragraph);
		document.close();
		
		try {
			
		}catch (DocumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
}

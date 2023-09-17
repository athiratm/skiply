package com.example.skiply.service;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.mapper.DataMapper;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class InvoiceService {

	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	@Autowired
	private DataMapper dataMapper;

	public String htmlToPdf(String processedHtml, Long id) throws SkiplyException {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		try {

			PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);

			DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);

			ConverterProperties converterProperties = new ConverterProperties();

			converterProperties.setFontProvider(defaultFont);

			HtmlConverter.convertToPdf(processedHtml, pdfwriter, converterProperties);

			FileOutputStream fout = new FileOutputStream("/Users/SSD/Desktop/invoice_" + id + ".pdf");

			byteArrayOutputStream.writeTo(fout);
			byteArrayOutputStream.close();

			byteArrayOutputStream.flush();
			fout.close();

			return "Invoice generated successfully";

		} catch (Exception e) {
			throw new SkiplyException(e.getMessage());
		}
	}

	public String generateInvoice(Long studentId) throws SkiplyException {
		String finalHtml = null;
		Context dataContext = dataMapper.setData(studentId);
		finalHtml = springTemplateEngine.process("template", dataContext);

		try {
			return htmlToPdf(finalHtml, studentId);
		} catch (SkiplyException e) {
			throw new SkiplyException(e.getMessage());
		}

	}

}

package com.rvs.api.utils;

import com.rvs.api.service.DocumentsService;
import org.docx4j.Docx4J;
import org.docx4j.fonts.BestMatchingMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DocToPdfConverter {

    public static byte[] convert(byte[] docBytes) {
        try {
            InputStream inputStream = new ByteArrayInputStream(docBytes);
            WordprocessingMLPackage wordMLPackage = Docx4J.load(inputStream);
            Mapper fontMapper = new BestMatchingMapper();
            wordMLPackage.setFontMapper(fontMapper);

            URL url = DocumentsService.class.getResource("/fonts/timesnrcyrmt.ttf");
            PhysicalFonts.addPhysicalFonts("TimesCyr", url.toURI());
            PhysicalFont font = PhysicalFonts.get("TimesCyr");

            fontMapper.put("Times New Roman", font);
            fontMapper.put("Calibri", font);
            wordMLPackage.setFontMapper(fontMapper);

            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            Docx4J.toPDF(wordMLPackage, pdfOutputStream);
            return pdfOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


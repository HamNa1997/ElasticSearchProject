package com.nazih.elasticsearchproject.helper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.extractor.ExtractorFactory;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


public class Parser {
    private String outputString;
    private Boolean status;
    private MultipartFile inputfile;

    Logger LOG= LoggerFactory.getLogger(Parser.class);

    public Parser(MultipartFile file) {
        status = false;
        inputfile = file;
        outputString = null;
    }

    public Boolean getStatus(){ return this.status;}
    public String getOutputString(){
        return this.outputString;
    }


    public void fileParser() {
        if (Objects.equals(inputfile.getContentType(), "application/pdf")) {
            try {
                PDDocument ResumePDF = PDDocument.load(inputfile.getInputStream());
                PDFTextStripper stripper = new PDFTextStripper();
                outputString = stripper.getText(ResumePDF);
                ResumePDF.close();
                status=true;
            } catch (final Exception e) {
                LOG.error("PDF PARSING ERROR", e);
            }
        }
        if (Objects.equals(inputfile.getContentType(), "application/msword")
        || Objects.equals(inputfile.getContentType()
                , "application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            try {
                POITextExtractor poitex = ExtractorFactory.createExtractor(inputfile.getInputStream());
                outputString = poitex.getText();
                poitex.close();
                status=true;
            } catch (final Exception e) {
                LOG.error("WORD PARSING ERROR", e);
            }
        }
    }



}

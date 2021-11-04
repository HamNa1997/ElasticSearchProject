package com.nazih.elasticsearchproject.Controller;


import com.nazih.elasticsearchproject.doc.Resume;

import com.nazih.elasticsearchproject.helper.Parser;
import com.nazih.elasticsearchproject.services.Resumeservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.util.List;


@RestController
@RequestMapping("/api")
public class Controller {
    Logger LOG= LoggerFactory.getLogger(Controller.class);
    private Resumeservice service;


    @Autowired
    public Controller(Resumeservice service){
        this.service = service;

    }

    @PostMapping("/upload")
    public void Upload(@RequestParam("file") MultipartFile file)  {
        LOG.info("UPLOAD REQUEST, FILE NAME : "
                +file.getOriginalFilename()
                +" ,TYPE : "
                +file.getContentType());
        Parser parser = new Parser(file);
        parser.fileParser();

        if(parser.getStatus()){
            service.saveIndex(parser.getOutputString(), file.getOriginalFilename());
        }
        else {
            LOG.info("FILE FORMAT NOT SUPPORTED, "
                    +file.getContentType());
        }
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Resume> Search(@RequestParam("keyword") String keyword){
        LOG.info("SEARCH REQUEST, KEYWORD : "+keyword);
        return service.Search(keyword);
    }

}

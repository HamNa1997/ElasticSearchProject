package com.nazih.elasticsearchproject.services;

import com.nazih.elasticsearchproject.Repo.resumeRepository;
import com.nazih.elasticsearchproject.doc.Resume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Resumeservice {
    Logger LOG= LoggerFactory.getLogger(Resumeservice.class);
    private resumeRepository  resumerepo;

    @Autowired
    public Resumeservice(resumeRepository resumerepo){
        this.resumerepo=resumerepo;
    }

    public void saveIndex(String content,String fileName){
        Resume resume=new Resume(UUID.randomUUID().toString()
                , content , fileName );
        resumerepo.save(resume);
        LOG.info("NEW RESUME INDEXED, "+fileName);
    }

    public List<Resume> Search(String keyword){
        List<Resume> Result = resumerepo.findByContentContaining(keyword);
        LOG.info("SEARCH RESULT, "+Result.size()+" RESUMES");
        return Result;
    }


}

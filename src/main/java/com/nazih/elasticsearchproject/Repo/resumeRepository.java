package com.nazih.elasticsearchproject.Repo;

import com.nazih.elasticsearchproject.doc.Resume;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface resumeRepository extends ElasticsearchRepository<Resume,String> {
    List<Resume> findByContentContaining(String content);
}

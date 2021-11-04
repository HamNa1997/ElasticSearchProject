package com.nazih.elasticsearchproject.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "resume")
public class Resume {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "filename")
    private String filename;

    @Field(type = FieldType.Text, name = "content")
    private String content;



    public Resume(String id, String content, String filename){
        this.id=id;
        this.content=content;
        this.filename=filename;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setContent(String content){
        this.content=content;
    }

    public String getContent(){
        return content;
    }
    public String getId(){
        return id;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }
    public String getFilename(){
        return filename;
    }
}

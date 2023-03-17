package site.srht.xerexcoded.content.calender.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import site.srht.xerexcoded.content.calender.model.Content;
import site.srht.xerexcoded.content.calender.model.Status;
import site.srht.xerexcoded.content.calender.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRespository {
    private final List<Content> contentList = new ArrayList<>();

    //constructor
    public ContentCollectionRespository(){

    }
    public List<Content> getContentList() {
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }
    public void save(Content content){
        contentList.add(content);
    }
    @PostConstruct
    public void init(){
        Content c = new Content( 1, "test",  "test", Status.IDEA, Type.ARTICLE, LocalDateTime.now(),  null,  "");
        contentList.add(c);
    }

}

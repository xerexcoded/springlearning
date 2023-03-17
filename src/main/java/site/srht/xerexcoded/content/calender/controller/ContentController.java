package site.srht.xerexcoded.content.calender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import site.srht.xerexcoded.content.calender.model.Content;
import site.srht.xerexcoded.content.calender.repository.ContentCollectionRespository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    // avoid using new keyword
    // use dependency injection instead
    // final means that the variable can only be set once,
    // and it can only be set in the constructor
    // this is a good practice to make sure that the variable is set
    private final  ContentCollectionRespository contentCollectionRespository;
    // get dependency from constructor injection that comes from the application context
    //Constructor injection is the preferred way to inject dependencies
    public ContentController(ContentCollectionRespository contentCollectionRespository) {
        this.contentCollectionRespository = contentCollectionRespository;
    }
    @GetMapping
    public List<Content> findAll(){
        return contentCollectionRespository.getContentList();
    }
    //CRUD operations
    //Create
    //Read
    //Update
    //Delete
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return contentCollectionRespository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void save(@RequestBody Content content){ // RequestBody is used to bind the HTTP request body with a domain object in method parameter or return type
        contentCollectionRespository.getContentList().add(content);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if (content.id() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content id does not match");
        }
        contentCollectionRespository.save(content);

    }

}

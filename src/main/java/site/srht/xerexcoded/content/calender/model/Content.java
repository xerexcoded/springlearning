package site.srht.xerexcoded.content.calender.model;


import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type ContentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url

) {

}

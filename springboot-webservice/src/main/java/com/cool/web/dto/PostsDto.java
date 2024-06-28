package com.cool.web.dto;

import com.cool.web.domain.post.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    @Builder
    public PostsDto(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public PostsDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }
}



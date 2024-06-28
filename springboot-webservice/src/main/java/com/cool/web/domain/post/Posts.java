package com.cool.web.domain.post;

import com.cool.web.domain.BaseTimeEntity;
import com.cool.web.dto.PostsDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ③
    private Long id;

    @Column(length = 500, nullable = false)  // ④
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder  // ⑦
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(PostsDto postsDto){
        this.title = postsDto.getTitle();
        this.content = postsDto.getContent();
    }
}

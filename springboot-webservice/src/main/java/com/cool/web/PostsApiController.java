package com.cool.web;

import com.cool.web.domain.post.Posts;
import com.cool.service.PostsService;
import com.cool.web.dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    @Autowired
    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public Posts select(@PathVariable Long id){
        return postsService.select(id);
    }

    @PostMapping("/api/v1/posts")
    public Long insert(@RequestBody PostsDto requestDto){
        return postsService.insert(requestDto);
    }

    @PutMapping("/api/vl/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
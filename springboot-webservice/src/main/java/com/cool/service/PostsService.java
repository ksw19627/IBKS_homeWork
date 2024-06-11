package com.cool.service;

import com.cool.web.domain.post.Posts;
import com.cool.web.domain.post.PostsRepository;
import com.cool.web.dto.PostsResponseDto;
import com.cool.web.dto.PostsSaveRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id" + id)
        );
        return new PostsResponseDto(entity);
    }

    public Long update(Long id, PostsSaveRequestDto requestDto){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id" + id)
        );
        entity.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}

package com.cool.service;

import com.cool.web.domain.post.Posts;
import com.cool.web.domain.post.PostsRepository;
import com.cool.web.dto.PostsDto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long insert(PostsDto postsDto){
        return postsRepository.save(postsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsDto postsDto){
        Posts post = select(id);
        post.update(postsDto);

        return post.getId();
    }

    @Transactional
    public Long delete(Long id) {
        postsRepository.deleteById(id);
        return id;
    }

    @Transactional(readOnly = true)
    public Posts select(Long id) {
        return  postsRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<PostsDto> selectListSort() {
        return postsRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(PostsDto::new)  // .map( post -> new PostsListResponseDto(post) )
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsDto> selectListDesc() {
        return postsRepository.selectListDesc().stream()
                .map(PostsDto::new)  // .map( post -> new PostsListResponseDto(post) )
                .collect(Collectors.toList());
    }
}

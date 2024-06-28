package com.cool.web;

import com.cool.web.domain.post.Posts;
import com.cool.web.domain.post.PostsRepository;
import com.cool.web.dto.PostsDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("Posts Create")
    public void test_postCreate() {
        // given
        String expectedTitle = "title";
        String expectedContent = "content";

        PostsDto requestDto
                = PostsDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity
                = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> postsList = postsRepository.findAll();

        assertThat(postsList.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(postsList.get(0).getContent()).isEqualTo(expectedContent);
    }

    @Test
    @DisplayName("Posts Update")
    public void test_postUpdate() throws Exception{
        //given
        Posts savedPosts = postsRepository.save(
                Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build()
        );

        Long updateId = savedPosts.getId();
        String newTitle = "title";
        String newContent = "content3";
        PostsDto requestDto =
                PostsDto.builder()
                        .title(newTitle)
                        .content(newContent)
                        .build();

        String url = "http://localhost:"+port+"/api/v1/posts/"+updateId;
        HttpEntity<PostsDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(newTitle);
        assertThat(all.get(0).getContent()).isEqualTo(newContent);
    }

    @Test
    @DisplayName("생성시간/수정시간 자동화 테스트")
    public void test_baseTimeEntityPost(){

        //given
        LocalDateTime now = LocalDateTime.now();

        String title = "테스트 제목";
        String content = "테스트 본문";
        String author = "테스트 저자";

        postsRepository.save( Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);

        System.out.println(">>>>>>>>>> nowDate="+now);
        System.out.println(">>>>>>>>>> CreateDate="+post.getCreatedDate()+", modifiedDate="+post.getModifiedDate() );

        Assertions.assertThat(post.getCreatedDate()).isAfter(now);
        Assertions.assertThat(post.getModifiedDate()).isAfter(now);
    }
}



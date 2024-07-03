package com.cool.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cool.service.PostsService;
import com.cool.config.auth.SessionUser;
import com.cool.config.auth.LoginUser;
import com.cool.web.domain.post.Posts;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser sessionUser){
        model.addAttribute("posts", postsService.selectListDesc());
        if(sessionUser!=null){
            model.addAttribute("userName", sessionUser.getName());
        }
        return "index";
    }

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";   // posts-save.mustache 화면 표시
    }

    @GetMapping("/posts/list")
    public String selectList(Model model){
        model.addAttribute("posts", postsService.selectListSort());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("post", postsService.select(id));
        return "posts-edit";   // posts-save.mustache 화면 표시
    }
}

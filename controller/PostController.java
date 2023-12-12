package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.PostRequestDto;
import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
//    @GetMapping(value="/post")
//    public List<PostResponseDto> getPostList(@RequestParam Integer page){
//        List<Post> postList = postService.getPostByPage(page, 3);
//
//        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
//        for(Post post : postList){
//            postResponseDtoList.add(new PostResponseDto(post));
//        }
//        return postResponseDtoList ;
//    }

    @GetMapping
    public List<Post> getAllPost() {

        return postService.getAllPost();

    }


    @PostMapping(value="/post")
    public String createPost(@RequestBody PostRequestDto postDto){
        Post post = postDto.getPost();
        postService.savePost(post);

        return "success";
    }

    @PutMapping(value="/post")
    public String updatePost(@RequestBody PostRequestDto postDto){
        Post post = postDto.getPost();
        postService.updatePost(post);

        return "success";
    }


}

package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostPageController {
    private PostService postService;
    public PostPageController(PostService postService){
        this.postService=postService;
    }
    @RequestMapping(value="/post/{id}")
    public String getPostDetailPage(Model model, @PathVariable Integer id){
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post_detail";

    }
    @RequestMapping(value="/post/create")
    public String getPostCreatePage(){

        return "post_write";
    }
    @RequestMapping(value="/post/edit/{id}")
    public String getPostEditPage(Model model, @PathVariable Integer id){
        //Đoạn code dưới đây để lưu dữ liệu nội dung và tiêu đề đã tạo trước đó trên biểu mẫu đã sửa đổi,
        //cần đặt mô hình dưới đây để tra cứu đối tượng bài đăng
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post_edit";
    }

}

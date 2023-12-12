package com.codepresso.codepressoblog.controller.dto;

import com.codepresso.codepressoblog.vo.Post;
import lombok.Setter;

@Setter
public class PostRequestDto {
    Integer id;
    String title;
    String content;
    String username;

    //Tạo đối tượng post từ PostRequestDto
    public Post getPost(){

        return new Post(this.id, this.title, this.content, this.username);
    }
}

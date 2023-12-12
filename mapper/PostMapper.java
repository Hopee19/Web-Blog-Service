package com.codepresso.codepressoblog.mapper;

import com.codepresso.codepressoblog.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    List<Post> findByPage(@Param("limit") Integer limit, @Param("offset") Integer offset);

    Post findOne(@Param("id") Integer id);


    // Chỉ thêm 1 hàng
    Integer save(@Param("post") Post post);


    //Khi sửa update trả về số bản ghi bị ảnh hưởng dưới dạng số, chỉ sửa trên 1 hàng
    Integer update(@Param("post") Post post);

}

package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostMapper postMapper;
    public PostService(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public List<Post> getAllPost(){
        return postMapper.findAll();
    }
//    public List<Post> getPostByPage(Integer page, Integer size){
//
//        return postMapper.findByPage(size, (page-1) * size);
//    }

    public Post getPostById(Integer id){
        return postMapper.findOne(id);
    }

    public boolean savePost(Post post){
        Integer result = postMapper.save(post);
        return result == 1;
    }


    //Phương thức này chỉ chỉnh sửa 1 raw duy nhất với 1 id duy nhất, vì vậy nếu sửa đổi thực hiện thành công, sẽ trả về 1
// boolean là để trả về giá trị đúng khi sửa đổi đc thực hiện thành công, tại vì sẽ có thêm code nếu update kh thực hiện thành công
    //và sẽ sinh ra nhiều lỗi cần đc xử lý.
    public boolean updatePost(Post post){
        Integer result1 = postMapper.update(post);
        return result1 == 1;
    }


}

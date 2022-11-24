package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.Post;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    List<Post> selectPosts();

    Post selectPost(Long postId);

    void insertPost(Post post);

    void updatePost(Post post);

//    Optional<Student> selectStudent(long id);
//    List<Student> selectStudents();
//    void insertStudent(Student student);
//    void updateNameById(String name, long id);
//    void deleteById(long id);
}

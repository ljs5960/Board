package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.Post;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    List<Post> selectPosts();

//    Optional<Post> selectPost(Long id);
//

    void insertPost(Post post);

//    Optional<Student> selectStudent(long id);
//    List<Student> selectStudents();
//    void insertStudent(Student student);
//    void updateNameById(String name, long id);
//    void deleteById(long id);
}
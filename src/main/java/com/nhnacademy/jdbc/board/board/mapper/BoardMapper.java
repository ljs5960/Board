package com.nhnacademy.jdbc.board.board.mapper;

import com.nhnacademy.jdbc.board.board.domain.Post;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
//    Optional<Post> selectPost(Long id);
//
//    List<Post> selectPosts();

    void insertPost(Post post);

//    Optional<Student> selectStudent(long id);
//    List<Student> selectStudents();
//    void insertStudent(Student student);
//    void updateNameById(String name, long id);
//    void deleteById(long id);
}

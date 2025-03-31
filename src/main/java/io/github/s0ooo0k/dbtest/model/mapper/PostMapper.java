package io.github.s0ooo0k.dbtest.model.mapper;

import io.github.s0ooo0k.dbtest.model.vo.Post;
import io.github.s0ooo0k.dbtest.model.vo.PostDTO;

import java.util.List;

// Mapper 인터페이스
// Java 메서드와 XML 작성한 SQL 쿼리 연결 - 자동으로 Mapper Proxy 객체 주입
public interface PostMapper {
    void insert(Post post);
    List<Post> findAll();
    Post findById(int id);
    void like(int id);
}

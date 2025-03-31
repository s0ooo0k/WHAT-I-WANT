package io.github.s0ooo0k.dbtest.model.vo;

import java.sql.Timestamp;

// DB 조회/반환용 (전체 row 대응)
// vo는 DB의 row와 1:1로 매칭되는 객체
// DB 테이블 <-> VO <-> Mapper(MyBatis)
public record Post(
        int id,
        String title,
        String content,
        String imgUrl,
        int likes,
        Timestamp createdAt
) {
}

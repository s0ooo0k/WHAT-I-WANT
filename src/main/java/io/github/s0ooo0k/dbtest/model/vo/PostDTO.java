package io.github.s0ooo0k.dbtest.model.vo;

// DTO - 요청/응답에 사용되는 데이터 전달 객체
// 입력값 처리, 가공 데이터 담기
// 사용자 폼 입력 -> DTO -> insert 호출
public record PostDTO(
        // 실제 입력이 필요한 내용만
        String title,
        String content,
        String imgUrl
) {
}

package com.example.boardSonic.model.request;


import lombok.Data;

/**
 * @Data 어노테이션
 * Getter, Setter, toString()
 * equals(), hashCode()
 * 클래스 내의 모든 필드에 대한 이 메서드들을 자동생성
 */
@Data
public class BoardDeleteRequest {
    private Long boardNo;
}

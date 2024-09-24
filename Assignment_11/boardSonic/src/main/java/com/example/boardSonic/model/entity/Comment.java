package com.example.boardSonic.model.entity;

import com.example.boardSonic.model.DeleteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(length = 1000, nullable = false)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeleteStatus deleteStatus = DeleteStatus.ACTIVE;

    //연관관계 매핑
    //OneToMany, ManyToOne ... // 일대다, 다대일
    //Board : Comment = 1 : N
    //즉시로딩과 지연로딩
    //N + 1 댓글만 조회를 하고 싶은데 댓글수 + 보드 1개만큼 쿼리가 날아가는 문제
    //지연로딩 적용 : DB가 아닌 프록시에서 데이터를 가져옴. 엔티티(프록시)객체에서 데이터를 가져옴!
    // -> 이렇게 하면 N+1에서 +1만큼(board 조회) 해결!
    //n개의 쿼리 발생 문제 -> JOIN FETCH 라는것을 이용
    @ManyToOne(fetch = FetchType.LAZY) //N+1문제 해결방법! - 지연로딩
    @JoinColumn(name = "BOARD_NO", nullable = false)
    private Board board;

    //소프트 삭제 상태 확인 메서드
    public boolean isDeleted(){
        return this.deleteStatus == DeleteStatus.DELETE;
    }

    //댓글 삭제 메서드(소프트삭제)
    public void delete(){
        this.deleteStatus = DeleteStatus.DELETE;
    }

}

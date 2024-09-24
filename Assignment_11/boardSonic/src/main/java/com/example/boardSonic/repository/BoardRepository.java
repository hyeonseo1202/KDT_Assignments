package com.example.boardSonic.repository;

import com.example.boardSonic.model.DeleteStatus;
import com.example.boardSonic.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //삭제 상태를 기준으로 Board엔티티를 페이지별로 조회
    Page<Board> findAllByDeleteStatus(DeleteStatus deleteStatus, Pageable pageable);

    //커스텀 쿼리 정의한 것
    //Board엔티티와 관련된 comments를 함께 가져오는 JPQL쿼리
    //LEFT JOIN FETCH는 해당 Board엔티티와 관련도니 comments 엔티티들을 한 번의 조회로 가져오기 위해 사용된다.
    //이게 N+1문제 해결에 가장 많이 사용되는 패치 조인 방식이다.
    //b.boardNo = :boardNo는 게시글 번호로 특정 게시글을 조회하는 조건을 나타낸다.
    //조회 결과가 없을 수도 있어서 반환 타입이 Optional로 정의되어있다.
    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.comments c WHERE b.boardNo = :boardNo")
    Optional<Board> findBoardWithCommentsByBoardNo(@Param("boardNo") Long boardNo);
}

package com.example.boardSonic.controller;

import com.example.boardSonic.model.response.BoardListResponse;
import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시물 등록
    @PostMapping("board/create")
    public BoardResponse writeBoard(
            @RequestParam("title") String title,
            @RequestParam("body") String body
    ) {
        return boardService.writeBoard(title,body);
    }

    //게시물 수정
    //Post는 create. put은 update or replace
    @PutMapping("board/update")
    public BoardResponse updateBoard(
            @RequestParam("boardNo") Long boardNo,
            @RequestParam("title") String title,
            @RequestParam("body") String body
    ){
        return boardService.updateBoard(boardNo, title, body);
    }


    //조회
    //페이징조회. 다건. 댓글 가져오지 않음. 게시물 목록
    //페이징 : 데이터베이스에서 많은 양의 데이터를 분할하여 불러오는 방법
    //@RequestParam은 Url에 변수를 포함시켜야함.
    //예시 : localhost:8080/board/check/several?page=1&pageSize=4
    //페이지 번호는 0번부터 시작
    @GetMapping("board/check/several")
    public List<BoardListResponse> searchBoardList(
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize
    ) {
        return boardService.searchBoardList(page, pageSize);
    }
    //단건조회
    @GetMapping("board/check/one")
    public BoardResponse searchBoard(
            @RequestParam("boardNo") Long boardNo
    ) {
        return boardService.searchBoard(boardNo);
    }

    //게시물삭제(소프트 삭제)
    @DeleteMapping("board/delete")
    public String deleteBoard(
            @RequestParam("boardNo") Long boardNo
    ) {
        return boardService.deleteBoard(boardNo);
    }
}

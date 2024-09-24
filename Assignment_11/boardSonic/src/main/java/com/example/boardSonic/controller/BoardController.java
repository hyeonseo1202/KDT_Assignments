package com.example.boardSonic.controller;

import com.example.boardSonic.model.request.BoardDeleteRequest;
import com.example.boardSonic.model.request.BoardPostRequest;
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
    @PostMapping("board")
    public BoardResponse writeBoard(
            @RequestBody BoardPostRequest boardPostRequest //JSON형식
    ) {
        return boardService.writeBoard(boardPostRequest);
    }

    //조회
    //페이징조회. 다건. 댓글 가져오지 않음. 게시물 목록
    @GetMapping("boards")
    public List<BoardListResponse> searchBoardList(
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize
    ) {
        return boardService.searchBoardList(page, pageSize);
    }
    //단건조회
    @GetMapping("board")
    public BoardResponse searchBoard(
            @RequestParam("boardNo") Long boardNo
    ) {
        return boardService.searchBoard(boardNo);
    }

    //게시물삭제
    @DeleteMapping("board")
    public String deleteBoard(
            @RequestBody BoardDeleteRequest boardDeleteRequest
    ) {
        return boardService.deleteBoard(boardDeleteRequest);
    }
}

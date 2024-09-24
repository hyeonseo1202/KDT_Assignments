package com.example.boardSonic.controller;

import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.model.response.CommentResponse;
import com.example.boardSonic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 등록
    @PostMapping("comment/create")
    public BoardResponse writeComment(
            @RequestParam("boardNo") Long boardNo,
            @RequestParam("comment") String comment
    ) {
        return commentService.writeComment(boardNo,comment);
    }
    // 댓글 수정
    @PutMapping("comment/update")
    public CommentResponse updateComment(
            @RequestParam("commentNo") Long commentNo,
            @RequestParam("newComment") String newComment
    ) {
        return commentService.updateComment(commentNo, newComment);
    }

    // 댓글 삭제
    @DeleteMapping("comment/delete")
    public String deleteComment(
            @RequestParam("commentNo") Long commentNo
    ) {
        return commentService.deleteComment(commentNo);
    }

}
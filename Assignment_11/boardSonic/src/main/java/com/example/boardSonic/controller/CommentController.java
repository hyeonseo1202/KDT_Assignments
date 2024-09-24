package com.example.boardSonic.controller;

import com.example.boardSonic.model.request.CommentPostRequest;
import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 등록
    @PostMapping("comment/create")
    public BoardResponse writeComment(
            @RequestBody CommentPostRequest commentPostRequest
    ) {
        return commentService.writeComment(commentPostRequest);
    }

}
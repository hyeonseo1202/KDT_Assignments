package com.example.boardSonic.service;


import com.example.boardSonic.model.entity.Board;
import com.example.boardSonic.model.request.CommentPostRequest;
import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.repository.BoardRepository;
import com.example.boardSonic.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponse writeComment(CommentPostRequest request) {
        Optional<Board> boardOptional = boardRepository.findBoardWithCommentsByBoardNo(request.getBoardNo());
        Board board = boardOptional.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다!"));

        //board에 댓글 추가
        board.addComment(request.getCommentBody());
        boardRepository.save(board);

        return BoardResponse.from(board);
    }
}
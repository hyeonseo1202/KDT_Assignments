package com.example.boardSonic.service;


import com.example.boardSonic.model.entity.Board;
import com.example.boardSonic.model.entity.Comment;
import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.model.response.CommentResponse;
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

    //댓글 등록
    @Transactional
    public BoardResponse writeComment(Long boardNo, String comment) {
        Optional<Board> boardOptional = boardRepository.findBoardWithCommentsByBoardNo(boardNo);
        Board board = boardOptional.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다!"));

        //board에 댓글 추가
        board.addComment(comment);
        boardRepository.save(board);

        return BoardResponse.from(board);
    }
    //댓글 수정
    @Transactional
    public CommentResponse updateComment(Long commentNo, String newComment) {
        Comment comment = commentRepository.findById(commentNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. commentNo=" + commentNo));

        // Soft delete 된 댓글은 수정할 수 없도록 예외 처리
        if (comment.isDeleted()) {
            throw new IllegalArgumentException("삭제된 댓글은 수정할 수 없습니다.");
        }
        comment.setBody(newComment);  // 댓글 내용 수정
        commentRepository.save(comment); // 수정 내용 저장

        return CommentResponse.from(comment);
    }
    //댓글 삭제
    public String deleteComment(Long commentNo){
        Comment comment = commentRepository.findById(commentNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. commentNo=" + commentNo));

        comment.delete();
        commentRepository.save(comment);
        return "OK";
    }
}
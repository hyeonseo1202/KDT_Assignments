package com.example.boardSonic.service;

import com.example.boardSonic.model.DeleteStatus;
import com.example.boardSonic.model.entity.Board;
import com.example.boardSonic.model.request.BoardDeleteRequest;
import com.example.boardSonic.model.request.BoardPostRequest;
import com.example.boardSonic.model.response.BoardListResponse;
import com.example.boardSonic.model.response.BoardResponse;
import com.example.boardSonic.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    //게시글 등록
    @Transactional
    public BoardResponse writeBoard(String title, String body) {
        Board board = new Board();
        board.setTitle(title);
        board.setBody(body);
        board.setDeleteStatus(DeleteStatus.ACTIVE);

        return BoardResponse.from(boardRepository.save(board));
    }

    public List<BoardListResponse> searchBoardList(int page, int pageSize) {
        return boardRepository.findAllByDeleteStatus(
                DeleteStatus.ACTIVE,
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "boardNo"))
        ).map(BoardListResponse::from).toList();
    }

    public BoardResponse searchBoard(Long boardNo) {
        return boardRepository.findBoardWithCommentsByBoardNo(boardNo)
                .map(BoardResponse::from)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));
    }

    @Transactional
    public String deleteBoard(Long boardNo) {
        //예외
        Optional<Board> boardOptional = boardRepository.findById(boardNo);
        Board board = boardOptional.orElseThrow(() -> new RuntimeException("존재하지않는 게시물!"));

        boardRepository.delete(board);
        //게시물 삭제시 코멘트 삭제도 필요

        return "OK";
    }
}


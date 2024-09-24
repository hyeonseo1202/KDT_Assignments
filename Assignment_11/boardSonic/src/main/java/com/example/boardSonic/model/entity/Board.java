package com.example.boardSonic.model.entity;

import com.example.boardSonic.model.DeleteStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class Board {
    @Id //jakarta,javax 동일!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo; //primary key

    private String title;

    @Column(length = 1000)
    private String body;

    //soft delete 구현 => 삭제여부 플래그값
    @Enumerated(EnumType.STRING) //Enum이라는걸 JPA가 알 수 있도록 어노테이션!
    private DeleteStatus deleteStatus;

    //관계매핑
    //1개의 게시물에 N개의 댓글을 들고 있는 형태
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "DELETE_STATUS= 'ACTIVE'") //소프트삭제된 게시글 필터링
    private List<Comment> comments = new ArrayList<>();

    public Board addComment(String commentBody) {
        Comment comment = new Comment();
        comment.setBody(commentBody);
        comment.setBoard(this);
        comment.setDeleteStatus(DeleteStatus.ACTIVE);

        this.getComments().add(comment);
        return this;
    }
}

package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.entity.Reply;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1, 300).forEach(i -> {
            // 1 ~ 100 랜덤 번호
            long bno = (long)(Math.random() * 100) + 1;
            Board board = Board.builder().bno(bno).build();
            Reply reply = Reply.builder().text("Reply..........." + i).board(board).replyer("guest").build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply1(){
        Optional<Reply> result = replyRepository.findById(1L);
        Reply reply = result.get();
        System.out.println(reply);
        System.out.println(reply.getBoard());
    }
}

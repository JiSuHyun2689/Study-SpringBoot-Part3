package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying // delete와 update는 항상 필수
    @Query("delete from Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);
}

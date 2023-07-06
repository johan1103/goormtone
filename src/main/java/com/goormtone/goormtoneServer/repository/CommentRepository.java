package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment,Long> {
  @Query("select c from Comment c join fetch c.member m where c.cupStore.id = :cupStoreId order by c.createTime" +
          " desc")
  Slice<Comment> getCommentsByCupStoreId(Long cupStoreId,Pageable pageable);
}

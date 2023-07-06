package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

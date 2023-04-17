package com.remivdeursen.yelper.repository;

import com.remivdeursen.yelper.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

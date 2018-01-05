package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.ArtworkComment;

@Repository
public interface ArtworkCommentRepo extends JpaRepository<ArtworkComment, Long>{

}

package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Artwork;

@Repository
public interface ArtworkRepo extends JpaRepository<Artwork, Long>{

}

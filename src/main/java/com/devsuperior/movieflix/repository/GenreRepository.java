package com.devsuperior.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long>{

}

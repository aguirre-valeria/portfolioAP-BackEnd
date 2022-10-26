package com.ap.portfolio.repository;

import com.ap.portfolio.model.Experiencie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperiencieRepository extends JpaRepository<Experiencie,Long> {
}

package com.example.CaixaSugestaoAnonima.repositories;

import com.example.CaixaSugestaoAnonima.entities.RespostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Long> {

    List<RespostaEntity> findAllBySugestaoIdOrderByDataEnvioDesc(Long id);
}

package com.example.CaixaSugestaoAnonima.repositories;

import com.example.CaixaSugestaoAnonima.entities.SugestaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<SugestaoEntity, Long> {

    Page<SugestaoEntity> findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(
            String filtroTitulo, Pageable pageable
    );
}

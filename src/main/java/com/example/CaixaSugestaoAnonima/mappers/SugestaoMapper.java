package com.example.CaixaSugestaoAnonima.mappers;

import com.example.CaixaSugestaoAnonima.dtos.SugestaoResponse;
import com.example.CaixaSugestaoAnonima.entities.SugestaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface SugestaoMapper {

    SugestaoResponse toResponse(SugestaoEntity entity);

    default Page<SugestaoResponse> toResponse(Page<SugestaoEntity> entityPage) {
        return entityPage.map(this::toResponse);
    }
}

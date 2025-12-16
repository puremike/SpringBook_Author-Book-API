package com.puremike.db.mappers.impl;

import com.puremike.db.domain.BookEntity;
import com.puremike.db.domain.dtos.BookDTO;
import com.puremike.db.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDTO> {

    private final ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO mapTo(BookEntity book) {
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public BookEntity mapFrom(BookDTO book) {
        return modelMapper.map(book, BookEntity.class);
    }
}

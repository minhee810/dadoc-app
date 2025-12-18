package io.ministep.dadoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ministep.dadoc.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

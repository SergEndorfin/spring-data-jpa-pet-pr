package com.itkon.jpaintro.repositories;

import com.itkon.jpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

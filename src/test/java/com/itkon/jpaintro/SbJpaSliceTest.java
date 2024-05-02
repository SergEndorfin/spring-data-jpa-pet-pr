package com.itkon.jpaintro;

import com.itkon.jpaintro.domain.Book;
import com.itkon.jpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"com.itkon.jpaintro.bootstrap"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SbJpaSliceTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Order(1)
//    @Rollback(value = false)
    @Commit
    void testJpaTestSlice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
        bookRepository.save(new Book("test", "123", "me"));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaTestSliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}

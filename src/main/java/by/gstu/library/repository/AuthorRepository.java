package by.gstu.library.repository;

import by.gstu.library.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByFullNameContainingOrderByFullName(String fio);
    List<Author> findAllByFullNameContaining(String fullName);

    Page<Author> findAllByFullNameContainingOrderByFullName(String fullName, Pageable pageable);

}

package by.gstu.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors", catalog = "library")
@Data
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    @Override
    public String toString() {
        return  fullName;
    }
}

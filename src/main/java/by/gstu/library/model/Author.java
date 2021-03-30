package by.gstu.library.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors", catalog = "library")
@Data
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
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

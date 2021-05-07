package by.gstu.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genres", catalog = "library")
@Data
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String genre;
}

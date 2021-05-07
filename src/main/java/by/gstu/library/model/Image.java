package by.gstu.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "images", catalog = "library")
@Data
@NoArgsConstructor
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private byte[] image;
    @Column(name = "image_name")
    private String imageName;

    public Image(Long id) {
        this.id = id;
    }
}

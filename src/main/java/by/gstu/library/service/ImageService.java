package by.gstu.library.service;

import by.gstu.library.model.Image;
import by.gstu.library.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image get(long id) {
        return imageRepository.getOne(id);
    }

}

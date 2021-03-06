package by.gstu.library.controller;

import by.gstu.library.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ImagesController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/image/{imageId}")
    @ResponseBody
    public void getImage(@PathVariable(name = "imageId") Long imageId, HttpServletResponse response) throws IOException {
        response.getOutputStream().write(imageService.get(imageId).getImage());
        response.getOutputStream().close();
    }
}

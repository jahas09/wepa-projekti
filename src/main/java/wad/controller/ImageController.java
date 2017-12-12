//package wad.controller;
//
//import java.io.IOException;
//import java.util.Optional;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import wad.domain.ImageObject;
//import wad.repository.ImageObjectRepository;
//
//@Controller
//public class ImageController {
//
//    private ImageObjectRepository imageObjectRepository;
//    
//    @Secured("ROLE_USER")
//    @GetMapping("/images")
//    public String view() {
//        return "redirect:/images/1";
//    }
// 
//    @Secured("ROLE_USER")
//    @GetMapping(path = "/image/{id}", produces = "image/jpeg")
//    @ResponseBody
//    public byte[] viewOne(@PathVariable Long id) {            
//        return this.imageObjectRepository.getOne(id).getContent();
//    }
// 
//    @Secured("ROLE_USER")
//    @PostMapping("/images")
//    public String add(@RequestParam("file") MultipartFile file) throws IOException {
//        if (!file.getContentType().equals("image/jpeg")) {
//            return "redirect:/images";
//        }
// 
//        ImageObject ImageObject = new ImageObject();
//        ImageObject.setContent(file.getBytes());
//        imageObjectRepository.save(ImageObject);
// 
//        return "redirect:/images";
//    }
// 
//    @GetMapping("/addImage")
//    public String kuvanLisays() {
//        return "lisaaKuva";
//    }
//
//}

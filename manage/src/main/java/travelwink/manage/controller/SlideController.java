package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.Slide;
import travelwink.manage.service.MenuService;
import travelwink.manage.service.SlideService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
@RequestMapping("/slide")
public class SlideController {

    @Autowired
    SlideService slideService;

    @Autowired
    MenuService menuService;

    @RequestMapping
    public String initPage(Slide slide, Model model){
        Menu breadcrumb = menuService.findByUrl("/slide");
        model.addAttribute("breadcrumb", breadcrumb);
        List<Slide> slides = slideService.findAll();
        model.addAttribute("slides", slides);
        return "page/slide";
    }

    @RequestMapping(value = "/add", params = {"add"})
    public String add (@RequestParam(value = "imgFile", required = false) MultipartFile imgFile,
                       @RequestParam(value = "imgMobileFile", required = false) MultipartFile imgMobileFile,
                       Slide slide) {
        if (!imgFile.isEmpty()) {
            try{
                byte[] bytes1 = imgFile.getBytes();
                Path path1 = Paths.get("C:\\static\\upload\\images/" + imgFile.getOriginalFilename());
                Files.write(path1, bytes1);
            }catch (Exception e){
                e.printStackTrace();
            }
            slide.setImgSrc("upload/images/"+imgFile.getOriginalFilename());
        }
        if (!imgMobileFile.isEmpty()) {
            try{
                byte[] bytes2 = imgMobileFile.getBytes();
                Path path2 = Paths.get("C:\\static\\upload\\images/" + imgMobileFile.getOriginalFilename());
                Files.write(path2, bytes2);
            }catch (Exception e){
                e.printStackTrace();
            }
            slide.setImgMobileSrc("upload/images/"+imgMobileFile.getOriginalFilename());
        }
        slideService.addSlide(slide);
        return "redirect:/slide";
    }

}

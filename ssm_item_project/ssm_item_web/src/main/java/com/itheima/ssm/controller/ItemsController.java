package com.itheima.ssm.controller;

import com.itheima.ssm.service.ItemsService;
import  com.itheima.ssm.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService service;

    @RequestMapping("/queryItems.do")
    public ModelAndView queryItems(){
        ModelAndView mv = new ModelAndView();
        List<Items> itemsList = service.findAllItems();
        mv.addObject("itemsList" ,itemsList);
        mv.setViewName("itemsList");
        return mv;
    }

    @RequestMapping("/editItems.do")
    public ModelAndView findById(Integer id){
        Items items = service.findAllItemById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("items",items);
        mv.setViewName("editItems");
        return mv;
    }

    @RequestMapping("/updateItems.do")
    public  String updateItems(Items items, HttpServletRequest request, MultipartFile upload) throws IOException {
        String filename = upload.getOriginalFilename();
        String pictureFile;

        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName().split("_")[1];
                if (filename.equals(name)){
                    file1.delete();
                }
            }
        }

        pictureFile = UUID.randomUUID().toString().replace("-", "")+"_"+filename;
        upload.transferTo(new File(path,pictureFile));

        pictureFile = path + filename;
        items.setPic(pictureFile);
        service.updateItems(items);
        return "redirect:/items/queryItems.do";
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping("/test")
    public String test(@RequestParam Integer id) {
        System.out.println("id:"+id);
        return "請求成功";
    }
    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("id:"+student.getId());
        System.out.println("name:"+student.getName());
        return "成功";
    }
    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("info:"+info);
        return "success";
    }
    @RequestMapping("/test4/{id}")
    public String test4(@PathVariable Integer id){
        System.out.println("id:"+id);
        return "success";
    }
    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }
}

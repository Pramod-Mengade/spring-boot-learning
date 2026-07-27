package com.pramod.demo.demo.rest;

import com.pramod.demo.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
public class DemoRESTController {

    @GetMapping("/student")

    public List<Student> data(){
        List <Student> list = new ArrayList<>();
        Student s1 = new Student("Pramod" , "Mengade");
        list.add(s1);
        Student s2 = new Student("Prasad" ,"Mengade");
        list.add(s2);
        Student s3 = new Student("Pooja" ,"Mengade");
        list.add(s3);
        Student s4 = new Student("Arti" ,"Mengade");

        return list;
    }
}

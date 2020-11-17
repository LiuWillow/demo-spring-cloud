//package com.lwl;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import rx.Observable;
//import rx.Scheduler;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//
///**
// * date  2018/6/14
// * author liuwillow
// **/
//@RestController
//public class Controller {
//    @Resource
//    HiService hiService;
//
//    @GetMapping("/hi")
//    public String hi(){
////        return hiService.hi();
//        return "";
//    }
//
////    public static void main(String[] args) {
////        List<File> list = new ArrayList<>();
////        Observable.from(list)
////                .flatMap(file -> Observable.from(Objects.requireNonNull(file.listFiles())))
////                .filter(file -> file.getName().endsWith(".png"))
////                .map(File::getName)
////                .subscribeOn()
////    }
//
//}

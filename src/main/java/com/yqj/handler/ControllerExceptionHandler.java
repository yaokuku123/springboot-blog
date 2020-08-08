package com.yqj.handler;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Copyright(C),2019-2020,XXX公司
// * FileName: ControllerExceptionHandler
// * Author: yaoqijun
// * Date: 2020/8/4 16:44
// */
////Controller错误会走的拦截器
//@ControllerAdvice
//public class ControllerExceptionHandler {
//
//    //获取log对象
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView exception(HttpServletRequest request, Exception e) throws Exception {
//        //控制台输出错误日志
//        logger.error("request url: {}, exception: {}",request.getRequestURL(),e);
//
//        //将标注状态码的异常被找到后直接抛出交给spring处理
////        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
////            throw e;
////        }
//
//        ModelAndView mv = new ModelAndView();
//        //添加返回页面携带的数据
//        mv.addObject("url",request.getRequestURL());
//        mv.addObject("exception",e);
//        //返回页面
//        mv.setViewName("error/error");
//        return mv;
//    }
//}

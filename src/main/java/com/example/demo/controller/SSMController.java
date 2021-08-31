package com.example.demo.controller;

import com.example.demo.service.SSMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description SSMController
 */
@RestController
@RequestMapping(value = "/SSM")
public class SSMController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SSMController.class);

    @Autowired
    private SSMService SSMService;


    /**
     * getdataFromHttpServletRequest
     *
     * @param request request
     * @return void
     */
    @RequestMapping(value = "/saveUserMessage", method = RequestMethod.GET)
    private void saveUserMessage(HttpServletRequest request) {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        Integer age = Integer.valueOf(request.getParameter("age"));
        SSMService.saveUser(uname, password, id, age);
    }
}


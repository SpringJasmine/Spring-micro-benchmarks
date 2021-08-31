package com.example.demo.controller;

import com.example.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description InfoLeakController
 */
@RestController
@RequestMapping(value = "/infoLeak")
public class InfoLeakController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoLeakController.class);

    @Autowired
    private InfoLeakService infoLeakService;

    @Value("${tokenBean.token}")
    private String tokenDefault;
    @Value("${tokenBean.password}")
    private String passwordDefault;
    @Value("${tokenBean.id}")
    private String idDefault;

    /**
     * getdataFromHttpServletRequest
     *
     * @param request request
     * @return void
     */
    @RequestMapping(value = "/infoLeak1", method = RequestMethod.GET)
    private void infoLeak1(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        infoLeakService.infoLeakMethod(token, password, id);
    }

    /**
     * getdataFromProperties
     *
     * @return void
     */
    @RequestMapping(value = "/infoLeak2", method = RequestMethod.GET)
    private void infoLeak2() {
        String token = tokenDefault;
        String password = passwordDefault;
        String id = idDefault;
        infoLeakService.infoLeakMethod(token, password, id);
    }
}


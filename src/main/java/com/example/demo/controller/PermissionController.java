package com.example.demo.controller;

import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description PermissionController
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    //Test the AOP form using custom annotations
    @RequestMapping(value = "/perm1", method = RequestMethod.GET)
    public void perm1(HttpServletRequest request) {
        String auth = request.getParameter("auth");
        permissionService.permissionAdmin(auth);
        permissionService.permissionUser(auth);
    }

    //Test the AOP form using custom annotations
    @RequestMapping(value = "/perm2", method = RequestMethod.GET)
    public void perm2(HttpServletRequest request) {
        String auth = request.getParameter("auth");
        permissionService.accessSuccess(auth);
    }

    //Test the AOP form using custom annotations
    @RequestMapping(value = "/perm3", method = RequestMethod.GET)
    public void perm3(HttpServletRequest request) {
        String auth = request.getParameter("auth");
        permissionService.accessFail(auth);
    }
}

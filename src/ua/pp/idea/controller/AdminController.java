package ua.pp.idea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dark on 19.11.2016.
 */
@Controller
public class AdminController {

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    String viewAdmin(HttpServletRequest request, Model model){
        String scheme = request.getScheme() + "://";
        String serverName = request.getServerName();
        String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
        String contextPath = request.getContextPath();

        String webRootPath=context.getRealPath("/");

        model.addAttribute("scheme",scheme);
        model.addAttribute("serverName",serverName);
        model.addAttribute("serverPort",serverPort);
        model.addAttribute("contextPath",contextPath);
        model.addAttribute("webRootPath",webRootPath);
        return "admin";
    }
}

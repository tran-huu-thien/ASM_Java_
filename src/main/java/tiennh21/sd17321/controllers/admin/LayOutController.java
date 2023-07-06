package tiennh21.sd17321.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class LayOutController {
    @GetMapping("home")
    public String homePage(Model model){
        model.addAttribute("view","/views/home-page.jsp");
        return "layout";
    }
    @GetMapping("gioi-thieu")
    public String gioiThieu(Model model){
        model.addAttribute("view","/views/gioi-thieu.jsp");
        return "layout";
    }
    @GetMapping("contact")
    public String Contact(Model model){
        model.addAttribute("view","/views/contact.jsp");
        return "layout";
    }
}

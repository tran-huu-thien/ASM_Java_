package tiennh21.sd17321.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tiennh21.sd17321.entities.NhanVien;
import tiennh21.sd17321.repositories.NhanVienRepository;
import tiennh21.sd17321.request.Account;

import java.util.Optional;

@Controller
@RequestMapping("admin")
public class LoginController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("login")
    public String getLoginForm(Model model)
    {
        model.addAttribute("view","/views/login.jsp");
        return "layout";
    }

    @PostMapping("login")
    public String login(Model model, NhanVien nhanVien) {
    NhanVien nDatabase = nhanVienRepository.findByManPassword(nhanVien.getMa(),nhanVien.getMatKhau());
        if (nDatabase != null) {
            session.setAttribute("user", nDatabase);
            session.setAttribute("role", check(nDatabase.getCV().getTen()));
            model.addAttribute("view", "/views/home-page.jsp");
            return "layout";
        } else {
            model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
            model.addAttribute("view", "/views/login.jsp");
            return "layout";
        }
    }
    @GetMapping("logout")
    public String logout(Model model) {
        session.setAttribute("user", null);
        session.setAttribute("role", null);
        return "redirect:/admin/login";

    }
    public boolean check(String ma){
        boolean check = false;
        if(ma.equals("NV")){
            return check;
        }else{
            return true;
        }
    }
}

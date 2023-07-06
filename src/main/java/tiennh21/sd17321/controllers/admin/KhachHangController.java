package tiennh21.sd17321.controllers.admin;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiennh21.sd17321.entities.KhachHang;
import tiennh21.sd17321.repositories.KhachHangRepository;
import tiennh21.sd17321.request.KhachHangVM;
@Controller
@RequestMapping("admin/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khachHangRepository;
    private KhachHangVM vm ;

    public KhachHangController() {
        this.vm = new KhachHangVM();
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("kh", vm);
        model.addAttribute("disabled","false");

        model.addAttribute("action", "/admin/khach-hang/store");
        model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "layout";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") KhachHang khachHang, Model model
    ){
        vm.loadFromEntity(khachHang);
        model.addAttribute("kh",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("action", "/admin/khach-hang/update/" + khachHang.getId());
        model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") KhachHang khachHang,
            @Valid KhachHangVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
            return "layout";
        }else {
            khachHang.loadFromVM(vm);

            this.khachHangRepository.save(khachHang);
            return "redirect:/admin/khach-hang/index";
        }
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("kh")
                    KhachHangVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
            return "layout";
        }else {

            KhachHang kh = new KhachHang();
            kh.loadFromVM(vm);

            this.khachHangRepository.save(kh);
            return "redirect:/admin/khach-hang/index";
        }
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<KhachHang> ds = this.khachHangRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/khach-hang/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang) {
        this.khachHangRepository.delete(khachHang);
        return "redirect:/admin/khach-hang/index";
    }
}

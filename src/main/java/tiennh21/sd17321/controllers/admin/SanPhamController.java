package tiennh21.sd17321.controllers.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiennh21.sd17321.entities.*;
import tiennh21.sd17321.repositories.MauSacRepository;
import tiennh21.sd17321.repositories.NsxRepository;
import tiennh21.sd17321.repositories.SanPhamRepository;
import tiennh21.sd17321.request.MauSacVM;
import tiennh21.sd17321.request.NhanVienVM;
import tiennh21.sd17321.request.NsxVM;
import tiennh21.sd17321.request.SanPhamVM;


@Controller
@RequestMapping(value = "admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    private SanPhamVM vm;

    public SanPhamController() {
        this.vm = new SanPhamVM();
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<SanPham> ds = this.sanPhamRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/san-pham/index.jsp");
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("sp", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("action", "/admin/san-pham/store");
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "layout";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("sp")
                    SanPhamVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "layout";
        }else {

            SanPham sanPham = new SanPham();
            sanPham.loadFromVM(vm);

            this.sanPhamRepository.save(sanPham);
            return "redirect:/admin/san-pham/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham) {
        this.sanPhamRepository.delete(sanPham);
        return "redirect:/admin/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") SanPham sanPham, Model model
    ){
        vm.loadFromEntity(sanPham);
        model.addAttribute("sp",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("action", "/admin/san-pham/update/" + sanPham.getId());
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") SanPham sanPham,
            @Valid SanPhamVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "layout";
        }else {
            sanPham.loadFromVM(vm);
            this.sanPhamRepository.save(sanPham);
            return "redirect:/admin/san-pham/index";
        }
    }
}

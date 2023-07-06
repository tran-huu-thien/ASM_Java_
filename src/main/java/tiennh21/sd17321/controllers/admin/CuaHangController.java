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
import tiennh21.sd17321.entities.CuaHang;
import tiennh21.sd17321.repositories.CuaHangRepository;
import tiennh21.sd17321.request.CuaHangVM;

import java.util.List;

@Controller
@RequestMapping("admin/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangRepository cuaHangRepo;
    private CuaHangVM vm;

    public CuaHangController() {
        this.vm = new CuaHangVM();
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("ch", vm);
        model.addAttribute("action", "/admin/cua-hang/store");

        model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") CuaHang cuaHang,
            Model model
    ) {
        vm.loadFromEntity(cuaHang);
        model.addAttribute("ch", vm);
        model.addAttribute("action", "/admin/cua-hang/update/" + cuaHang.getId());
        model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") CuaHang cuaHang,
            @Valid CuaHangVM vm,
            BindingResult result,
            Model model
    ) {
        cuaHang.loadFromVM(vm);
        this.cuaHangRepo.save(cuaHang);
        return "redirect:/admin/cua-hang/index";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("ch") CuaHangVM vm,
            BindingResult result,Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/cua-hang/create.jsp");
            return "layout";
        }

        CuaHang ch = new CuaHang();
        ch.loadFromVM(vm);
        this.cuaHangRepo.save(ch);
        return "redirect:/admin/cua-hang/index";
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name="page") Integer number ,Model model) {
        Pageable pageable = PageRequest.of(number,2);
        Page<CuaHang> ds = this.cuaHangRepo.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/cua-hang/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang) {
        this.cuaHangRepo.delete(cuaHang);
        return "redirect:/admin/cua-hang/index";
    }
}

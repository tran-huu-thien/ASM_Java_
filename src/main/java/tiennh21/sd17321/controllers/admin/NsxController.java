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
import tiennh21.sd17321.entities.ChucVu;
import tiennh21.sd17321.entities.CuaHang;
import tiennh21.sd17321.entities.NhanVien;
import tiennh21.sd17321.entities.Nsx;
import tiennh21.sd17321.repositories.NsxRepository;
import tiennh21.sd17321.request.NhanVienVM;
import tiennh21.sd17321.request.NsxVM;


@Controller
@RequestMapping(value = "admin/nsx")
public class NsxController {
    @Autowired
    private NsxRepository nsxRepository;
    private NsxVM vm;

    public NsxController() {
        this.vm = new NsxVM();
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<Nsx> ds = this.nsxRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/nsx/index.jsp");
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("nsx", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("action", "/admin/nsx/store");
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "layout";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("nsx")
                    NsxVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/nsx/create.jsp");
            return "layout";
        }else {

            Nsx nsx = new Nsx();
            nsx.loadFromVM(vm);

            this.nsxRepository.save(nsx);
            return "redirect:/admin/nsx/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Nsx nsx) {
        this.nsxRepository.delete(nsx);
        return "redirect:/admin/nsx/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") Nsx nsx, Model model
    ){
        vm.loadFromEntity(nsx);
        model.addAttribute("nsx",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("action", "/admin/nsx/update/" + nsx.getId());
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") Nsx nsx,
            @Valid NsxVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/nsx/create.jsp");
            return "layout";
        }else {
            nsx.loadFromVM(vm);

            this.nsxRepository.save(nsx);
            return "redirect:/admin/nsx/index";
        }
    }
}

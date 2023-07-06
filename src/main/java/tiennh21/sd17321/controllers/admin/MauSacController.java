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
import tiennh21.sd17321.request.MauSacVM;
import tiennh21.sd17321.request.NhanVienVM;
import tiennh21.sd17321.request.NsxVM;


@Controller
@RequestMapping(value = "admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepository;
    private MauSacVM vm;

    public MauSacController() {
        this.vm = new MauSacVM();
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<MauSac> ds = this.mauSacRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/mau-sac/index.jsp");
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("ms", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("action", "/admin/mau-sac/store");
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "layout";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("ms")
                    MauSacVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
            return "layout";
        }else {

            MauSac mauSac = new MauSac();
            mauSac.loadFromVM(vm);

            this.mauSacRepository.save(mauSac);
            return "redirect:/admin/mau-sac/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac) {
        this.mauSacRepository.delete(mauSac);
        return "redirect:/admin/mau-sac/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") MauSac mauSac, Model model
    ){
        vm.loadFromEntity(mauSac);
        model.addAttribute("ms",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("action", "/admin/mau-sac/update/" + mauSac.getId());
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") MauSac mauSac,
            @Valid MauSacVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
            return "layout";
        }else {
            mauSac.loadFromVM(vm);
            this.mauSacRepository.save(mauSac);
            return "redirect:/admin/mau-sac/index";
        }
    }
}

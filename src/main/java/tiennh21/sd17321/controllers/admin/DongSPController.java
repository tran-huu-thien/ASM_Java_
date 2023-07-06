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
import tiennh21.sd17321.repositories.DongSPRepository;
import tiennh21.sd17321.repositories.NsxRepository;
import tiennh21.sd17321.request.DongSPVM;
import tiennh21.sd17321.request.NhanVienVM;
import tiennh21.sd17321.request.NsxVM;


@Controller
@RequestMapping(value = "admin/dongsp")
public class DongSPController {
    @Autowired
    private DongSPRepository dongSPRepository;
    private DongSPVM vm;

    public DongSPController() {
        this.vm = new DongSPVM();
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<DongSP> ds = this.dongSPRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/dongsp/index.jsp");
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("dsp", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("action", "/admin/dongsp/store");
        model.addAttribute("view", "/views/admin/dongsp/create.jsp");
        return "layout";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("dsp")
                    DongSPVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/admin/dongsp/create.jsp");
            return "layout";
        }else {

            DongSP dongSP = new DongSP();
            dongSP.loadFromVM(vm);

            this.dongSPRepository.save(dongSP);
            return "redirect:/admin/dongsp/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSP dongsp) {
        this.dongSPRepository.delete(dongsp);
        return "redirect:/admin/dongsp/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") DongSP dsp, Model model
    ){
        vm.loadFromEntity(dsp);
        model.addAttribute("dsp",vm);
        model.addAttribute("disabled","true");

        model.addAttribute("action", "/admin/dongsp/update/" + dsp.getId());
        model.addAttribute("view", "/views/admin/dongsp/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") DongSP dsp,
            @Valid DongSPVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {

            model.addAttribute("view", "/views/admin/dongsp/create.jsp");
            return "layout";
        }else {
            dsp.loadFromVM(vm);

            this.dongSPRepository.save(dsp);
            return "redirect:/admin/dongsp/index";
        }
    }
}

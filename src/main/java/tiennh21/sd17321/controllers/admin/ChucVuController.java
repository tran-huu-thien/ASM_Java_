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
import tiennh21.sd17321.repositories.ChucVuRepository;
import tiennh21.sd17321.request.ChucVuVM;



@Controller
@RequestMapping(value = "admin/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository chucVuRepository;
    private ChucVuVM vm;

    public ChucVuController() {
        this.vm = new ChucVuVM();
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<ChucVu> ds = this.chucVuRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/chuc-vu/index.jsp");
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cv", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("action", "/admin/chuc-vu/store");
        model.addAttribute("view", "/views/admin/chuc-vu/create.jsp");
        return "layout";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("cv")
                    ChucVuVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            return "admin/chuc-vu/create";
        }else {

            ChucVu cv = new ChucVu();
            cv.loadFromVM(vm);

            this.chucVuRepository.save(cv);
            return "redirect:/admin/chuc-vu/index";
        }
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu cv) {
        this.chucVuRepository.delete(cv);
        return "redirect:/admin/chuc-vu/index";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") ChucVu cv, Model model
    ){
        vm.loadFromEntity(cv);
        model.addAttribute("cv",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("action", "/admin/chuc-vu/update/" + cv.getId());
        model.addAttribute("view", "/views/admin/chuc-vu/create.jsp");
        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChucVu cv,
            @Valid ChucVuVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {

            model.addAttribute("view", "/views/admin/chuc-vu/create.jsp");
            return "layout";
        }else {
            cv.loadFromVM(vm);

            this.chucVuRepository.save(cv);
            return "redirect:/admin/chuc-vu/index";
        }
    }
}

package tiennh21.sd17321.controllers.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiennh21.sd17321.controllers.CTSPService;
import tiennh21.sd17321.entities.*;
import tiennh21.sd17321.repositories.*;
import tiennh21.sd17321.request.ChiTietSPVM;
import tiennh21.sd17321.request.NhanVienVM;

import java.util.*;

@Controller
@RequestMapping(value = "admin/ct-san-pham")
public class ChiTietSPController {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private NsxRepository nsxRepository;
    @Autowired
    private CTSPService ctspService;
    private ChiTietSPVM vm ;

    public ChiTietSPController() {
        this.vm = new ChiTietSPVM();
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("ctsp", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("sp", this.sanPhamRepository.findAll());
        model.addAttribute("dsp", this.dongSPRepository.findAll() );
        model.addAttribute("ms", this.mauSacRepository.findAll());
        model.addAttribute("nsx", this.nsxRepository.findAll() );
        model.addAttribute("action", "/admin/ct-san-pham/store");
        model.addAttribute("view", "/views/admin/ct-san-pham/create.jsp");

        return "layout";
    }
    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") ChiTietSP chiTietSP, Model model
    ){
        vm.loadFromEntity(chiTietSP);
        model.addAttribute("ctsp",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("nsx", this.nsxRepository.findAll() );
        model.addAttribute("ms", this.mauSacRepository.findAll() );
        model.addAttribute("dsp", this.dongSPRepository.findAll() );
        model.addAttribute("sp", this.sanPhamRepository.findAll() );
        model.addAttribute("action", "/admin/ct-san-pham/update/" + chiTietSP.getId());
        model.addAttribute("view", "/views/admin/ct-san-pham/create.jsp");
        return "layout";
    }
    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") ChiTietSP chiTietSP,
            @Valid ChiTietSPVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("sp", this.sanPhamRepository.findAll() );
            model.addAttribute("ms", this.mauSacRepository.findAll() );
            model.addAttribute("dsp", this.dongSPRepository.findAll() );
            model.addAttribute("nsx", this.nsxRepository.findAll() );
            return "admin/ct-san-pham/create";
        }else {
            chiTietSP.loadFromVM(vm);
            SanPham ch = this.sanPhamRepository.findById(vm.getSP()).get();
            chiTietSP.setSP(ch);
            MauSac ms = this.mauSacRepository.findById(vm.getMS()).get();
            chiTietSP.setMS(ms);
            Nsx nsx = this.nsxRepository.findById(vm.getNsx()).get();
            chiTietSP.setNsx(nsx);
            DongSP dsp = this.dongSPRepository.findById(vm.getDSP()).get();
            chiTietSP.setDSP(dsp);
            this.chiTietSPRepository.save(chiTietSP);
            return "redirect:/admin/ct-san-pham/index";
        }
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("ctsp")
                    ChiTietSPVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("sp", this.sanPhamRepository.findAll() );
            model.addAttribute("ms", this.mauSacRepository.findAll() );
            model.addAttribute("dsp", this.dongSPRepository.findAll() );
            model.addAttribute("nsx", this.nsxRepository.findAll() );
            model.addAttribute("view", "/views/admin/ct-san-pham/create.jsp");
            return "layout";
        }else {
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.loadFromVM(vm);
            SanPham ch = this.sanPhamRepository.findById(vm.getSP()).get();
            chiTietSP.setSP(ch);
            MauSac ms = this.mauSacRepository.findById(vm.getMS()).get();
            chiTietSP.setMS(ms);
            Nsx nsx = this.nsxRepository.findById(vm.getNsx()).get();
            chiTietSP.setNsx(nsx);
            DongSP dsp = this.dongSPRepository.findById(vm.getDSP()).get();
            chiTietSP.setDSP(dsp);
            this.chiTietSPRepository.save(chiTietSP);
            return "redirect:/admin/ct-san-pham/index";
        }
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<ChiTietSP> ds = this.chiTietSPRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/ct-san-pham/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSP chiTietSP) {
        this.chiTietSPRepository.delete(chiTietSP);
        return "redirect:/admin/ct-san-pham/index";
    }
    @GetMapping("san-pham")
    public String showlAMP(Model model) {

        List<ChiTietSP> listLamp = chiTietSPRepository.findAll();
        model.addAttribute("listLamp",listLamp);
        model.addAttribute("view", "/views/shop.jsp");
        return "layout";
    }
    @GetMapping("find")
    public String showlAMP(Model model,@RequestParam(name = "name",defaultValue = "") String name) {
        List<ChiTietSP> listLamp = chiTietSPRepository.findByNameLike(name);
        model.addAttribute("listLamp",listLamp);
        model.addAttribute("view", "/views/shop.jsp");
        return "layout";
    }
    @GetMapping("detail")
    public String detail(@RequestParam(name = "id",defaultValue = "")  UUID id, Model model) {
        try {
            Optional<ChiTietSP> l = chiTietSPRepository.findById(id);
            model.addAttribute("l",l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("view", "/views/detail-Shop.jsp");
        return "layout";
    }
}

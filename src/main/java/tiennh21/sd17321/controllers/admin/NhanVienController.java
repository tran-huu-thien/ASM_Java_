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

import tiennh21.sd17321.entities.ChucVu;
import tiennh21.sd17321.entities.CuaHang;
import tiennh21.sd17321.entities.NhanVien;
import tiennh21.sd17321.repositories.ChucVuRepository;
import tiennh21.sd17321.repositories.CuaHangRepository;
import tiennh21.sd17321.repositories.NhanVienRepository;

import tiennh21.sd17321.request.NhanVienVM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private CuaHangRepository  cuaHangRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;
    private NhanVienVM vm ;

    public NhanVienController() {
        this.vm = new NhanVienVM();
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("nv", vm);
        model.addAttribute("disabled","false");
        model.addAttribute("ch", this.cuaHangRepository.findAll() );
        model.addAttribute("cv", this.chucVuRepository.findAll() );

        model.addAttribute("action", "/admin/nhan-vien/store");
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "layout";
    }
    @GetMapping("edit/{id}")
            public String edit(
                    @PathVariable("id") NhanVien nhanVien, Model model
                ){
        vm.loadFromEntity(nhanVien);
        model.addAttribute("nv",vm);
        model.addAttribute("disabled","true");
        model.addAttribute("ch", this.cuaHangRepository.findAll() );
        model.addAttribute("cv", this.chucVuRepository.findAll() );
        model.addAttribute("action", "/admin/nhan-vien/update/" + nhanVien.getId());
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "layout";
        }

    @PostMapping("update/{id}")
    public String update(
            @PathVariable("id") NhanVien nhanVien,
            @Valid NhanVienVM vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("ch", this.cuaHangRepository.findAll() );
            model.addAttribute("cv", this.chucVuRepository.findAll() );
            model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
            return "layout";
        }else {
            nhanVien.loadFromVM(vm);
            CuaHang ch = this.cuaHangRepository.findById(vm.getCH()).get();
            nhanVien.setCH(ch);
            ChucVu cv = this.chucVuRepository.findById(vm.getCV()).get();
            nhanVien.setCV(cv);
            this.nhanVienRepository.save(nhanVien);
            return "redirect:/admin/nhan-vien/index";
        }
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("nv")
                    NhanVienVM vm,
            BindingResult result,
            Model model

    ) {
        if (result.hasErrors()) {
            model.addAttribute("ch", this.cuaHangRepository.findAll() );
            model.addAttribute("cv", this.chucVuRepository.findAll() );
            model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
            return "layout";
        }else {

            NhanVien nv = new NhanVien();
            nv.loadFromVM(vm);
            CuaHang ch = this.cuaHangRepository.findById(vm.getCH()).get();
            nv.setCH(ch);
            ChucVu cv = this.chucVuRepository.findById(vm.getCV()).get();
            nv.setCV(cv);
            this.nhanVienRepository.save(nv);
            return "redirect:/admin/nhan-vien/index";
        }
    }

    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer number,Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<NhanVien> ds = this.nhanVienRepository.findAll(pageable);
        model.addAttribute("data", ds);
        model.addAttribute("view", "/views/admin/nhan-vien/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien) {
        this.nhanVienRepository.delete(nhanVien);
        return "redirect:/admin/nhan-vien/index";
    }
    @ModelAttribute("gioiTinh")
    public Map<Boolean, String> getGioiTinh(){
        Map<Boolean,String> map = new HashMap<>();
        map.put(true,"Nam");
        map.put(false,"Nữ");
        return map;
    }
    @ModelAttribute("trangThai")
    public Map<Integer, String> getTrangThai(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Còn làm");
        map.put(0,"Nghỉ làm");
        return map;
    }
}

package tiennh21.sd17321.controllers.admin;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tiennh21.sd17321.controllers.CTSPService;
import tiennh21.sd17321.entities.Cart;
import tiennh21.sd17321.entities.ChiTietSP;
import tiennh21.sd17321.entities.Item;
import tiennh21.sd17321.entities.KhachHang;
import tiennh21.sd17321.repositories.ChiTietSPRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("admin")
public class GioHangCTController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private   ChiTietSPRepository chiTietSanPhamRepository;

    @Autowired
    private  CTSPService ctspService;

    @GetMapping("add")
    public String add(@RequestParam("ctspId") UUID ctspId, Model model) {
        try {
            Optional<ChiTietSP> l = chiTietSanPhamRepository.findById(ctspId);
            if (l.get().getSoLuongTon() > 0) {
                Item item = new Item(l.get().getId(),
                        l.get().getSP().getTen(),
                        l.get().getMS().getTen(),
                        1,
                        l.get().getGiaBan());
                Cart cartSesion = (Cart) httpSession.getAttribute("cart");
                if (cartSesion == null) {
                    Cart c = new Cart();
                    ArrayList<Item> list = new ArrayList<>();
                    list.add(item);
                 c.setItems(list);
                    httpSession.setAttribute("cart", c);
                } else {
                    Cart cart = (Cart) httpSession.getAttribute("cart");
                    ArrayList<Item> listItem = cart.getItems();
                    for (Item itemTmp : listItem) {
                        if (itemTmp.getIdCtsp().equals(ctspId)) {
                            itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                            model.addAttribute("messageShop1", "Sản Phẩm Đã thêm vào giỏ hàng");
                            return "forward:/admin/ct-san-pham/san-pham";
                        }
                    }
                    listItem.add(item);
                }
            } else {
                model.addAttribute("messageShop", "Sản Phẩm này đã được bán hết");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/admin/ct-san-pham/san-pham";
    }

    @GetMapping("/index")
    public String index(ModelMap map) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        System.out.println(cart.toString());
        ArrayList<Item> list = cart.getItems();
        map.addAttribute("gioHangChiTiet", list);
        int tongsp = 0;
        int tongDouble = 0;
        for (Item o : list) {
            tongDouble += Double.parseDouble(String.valueOf(o.getSoLuong()))
                    * Double.parseDouble(String.valueOf(o.getGiaBan()));

        }

        map.addAttribute("tongsp", list.size());
        map.addAttribute("tongth", Integer.valueOf(tongDouble));
        map.addAttribute("tamtinh", Integer.valueOf(tongDouble));

        map.addAttribute("view", "/views/gio-hang.jsp");
        return "layout";
    }

//    @GetMapping("/delete")
//    public String delete(ModelMap map, Long id) {
//        try {
//            Item.delete(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/cart/index";
//    }



}

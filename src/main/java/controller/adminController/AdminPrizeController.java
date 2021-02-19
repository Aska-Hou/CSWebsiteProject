package controller.adminController;

import domain.Page;
import domain.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.PrizeService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin/prize")
public class AdminPrizeController {

    @Autowired
    public PrizeService prizeService;

    //    管理员： 分页展示所有的prize列表
    @RequestMapping(value = "/showPrizeList")
    @ResponseBody
    public List<Prize> showPrizeList(Page page) {
        return prizeService.showPrizeList(page);
    }

    //    管理员： prize列表页数展示
    @RequestMapping(value = "/showPagesList")
    @ResponseBody
    public Page showPagesList(Prize prize){
        if (prize.getPrize_id() == 0 && prize.getName() == null){
            return prizeService.showPageList();
        }
        else {
            return prizeService.showPageList(prize);
        }
    }

    //    管理员： 根据关键词展示prize列表
    @RequestMapping(value = "/searchPrizeList")
    @ResponseBody
    public List<Prize> searchPrizeList(Prize prize, Page page) {
        //   如果未传值，则展示所有的prize
        if (prize.getPrize_id() == 0 && prize.getName().equals("null")) {
            return prizeService.showPrizeList(page);
        } else {
            List<Prize> prizes = prizeService.showPrizeList(prize, page);
            return prizes;
        }
    }

/*
    //    管理员： 加入新prize
    @RequestMapping(value = "/addNewPrize")
    public ModelAndView addNewPrize(@RequestParam(value = "img", required = true) MultipartFile img, Prize prize) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (Prize == null) {
            modelAndView.setViewName("redirect:/admin/facultyInfo.html?add=false");
            return modelAndView;
        } else {
            Prize newPrize = PrizeService.addNewPrize(img, prize);
            modelAndView.setViewName("redirect:/admin/facultyEdit.html?prof_id=" + newPrize.getProf_id() + "&add=true");
            return modelAndView;
        }
    }

    //    管理员： 查看指定prize的详细信息
    @RequestMapping(value = "/getPrizeDetails")
    @ResponseBody
    public Prize getPrizeDetails(Prize prize) {
        Prize detail = PrizeService.showPrizeDetail(prize);
        return detail;
    }

    //    管理员： 更新prize信息
    @RequestMapping(value = "/editPrize")
    public String editPrize(@RequestParam(value = "img", required = false) MultipartFile img, Prize Prize) {
        boolean result = PrizeService.updatePrize(img, Prize);
        if (result) {
            return "redirect:/admin/facultyEdit.html?prof_id=" + Prize.getProf_id() + "&update=true";
        } else {
            return "redirect:/admin/facultyEdit.html?prof_id=" + Prize.getProf_id() + "&update=false";
        }
    }

    //    删除所选Prize
    @RequestMapping(value = "/deleteSelectedPrize")
    public String deleteSelectedPrize(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() > 0) {
            boolean result = PrizeService.deleteSelectedPrize(parameterMap);
            if (result) {
                return "redirect:/admin/facultyInfo.html?delete=true";
            } else return "redirect:/admin/facultyInfo.html?delete=false";
        } else return "redirect:/admin/facultyInfo.html?delete=false";
    }

    //    删除单个Prize
    @RequestMapping(value = "/deleteOnePrize")
    public String deleteOnePrize(Prize Prize) {
        boolean result = prizeService.deleteOnePrize(Prize);
        if (result) {
            return "redirect:/admin/facultyInfo.html?delete=true";
        } else return "redirect:/admin/facultyInfo.html?delete=false";
    }
    */
}

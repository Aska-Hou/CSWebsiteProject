package controller.indexController;

import domain.Page;
import domain.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.PrizeService;

import java.util.List;

@Controller
@RequestMapping(value = "/prize")
public class PrizeController {

    @Autowired
    PrizeService prizeService;

    //    展示Prize List
    @RequestMapping(value = "/showPrizeList")
    @ResponseBody
    public List<Prize> showPrizeListByPage(Page page) {
        return prizeService.showPrizeList(page);
    }

    //    Prize List 分页
    @RequestMapping(value = "/showPageList")
    @ResponseBody
    public Page showPageList() {
        return prizeService.showPageList();
    }

    //    Index页面展示最近三条prize
    @RequestMapping(value = "/showIndexPrize")
    @ResponseBody
    public List<Prize> showIndexPrize() {
        return prizeService.showIndexPrize();
    }
}

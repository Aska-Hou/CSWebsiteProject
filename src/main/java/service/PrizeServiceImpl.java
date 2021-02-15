package service;

import dao.PrizeDao;
import domain.Page;
import domain.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    public PrizeDao prizeDao;

    @Override
    public List<Prize> showPrizeList(Page page) {
        page.setLineEachPage(6);
        int currentPage = page.getCurrentPage();
        int currentLine = (currentPage - 1) * (page.getLineEachPage());
        page.setCurrentLine(currentLine);
        return prizeDao.showAllPrize(page);
    }

    @Override
    public Page showPageList() {
        Page page = new Page();
        Integer numberOfLine = prizeDao.showNumberOfLine();
        page.setTotalLine(numberOfLine);
        page.setLineEachPage(6);
        if (numberOfLine % page.getLineEachPage() == 0){
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        }
        else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }
}

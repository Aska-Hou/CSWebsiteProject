package service;

import dao.PrizeDao;
import domain.Page;
import domain.Prize;
import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Prize> showPrizeList(Prize prize, Page page) {
        List<Prize> prizes = new ArrayList<>();

        if (prize.getPrize_id() != 0){
            prizes.add(prizeDao.selectPrizeByID(prize));
        }
        else if(!prize.getName().equals("null")){
            page.setLineEachPage(6);
            int currentPage = page.getCurrentPage();
            int currentLine = (currentPage - 1) * (page.getLineEachPage());
            page.setCurrentLine(currentLine);
            prizes = prizeDao.selectPrizeByName(prize, page);
        }

        return prizes;
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

    @Override
    public Page showPageList(Prize prize) {
        Page page = new Page();
        Integer numberOfLine = 0;
        if (prize.getPrize_id() != 0){
            numberOfLine = 1;
        }
        else {
            numberOfLine = prizeDao.showNumberOfLineByName(prize);
        }

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

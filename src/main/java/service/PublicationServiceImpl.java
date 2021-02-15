package service;

import dao.PublicationDao;
import domain.Page;
import domain.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    public PublicationDao publicationDao;

    //    展示paper信息
    @Override
    public List<Paper> showPaperList(Page page) {
        page.setLineEachPage(6);
        page.setCurrentLine((page.getCurrentPage() - 1) * page.getLineEachPage());
        return publicationDao.selectAllPublication(page);
    }

    //    展示页码
    @Override
    public Page showPageList() {
        Integer numberOfLine = publicationDao.showNumberOfLine();

//        根据总信息条数来计算总页数
        Page page = new Page();
        page.setLineEachPage(6);
        page.setTotalLine(numberOfLine);
        if (numberOfLine % page.getLineEachPage() == 0) {
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        } else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }
}

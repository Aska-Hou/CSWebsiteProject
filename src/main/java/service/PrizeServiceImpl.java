package service;

import dao.NewsDao;
import dao.PrizeDao;
import domain.News;
import domain.Page;
import domain.Prize;
import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utils.ImageStorageUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    public PrizeDao prizeDao;

    @Autowired
    public NewsDao newsDao;

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

        if (prize.getPrize_id() != 0) {
            prizes.add(prizeDao.selectPrizeByID(prize));
        } else if (!prize.getName().equals("null")) {
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
        if (numberOfLine % page.getLineEachPage() == 0) {
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        } else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }

    @Override
    public Page showPageList(Prize prize) {
        Page page = new Page();
        Integer numberOfLine = 0;
        if (prize.getPrize_id() != 0) {
            numberOfLine = 1;
        } else {
            numberOfLine = prizeDao.showNumberOfLineByName(prize);
        }

        page.setTotalLine(numberOfLine);
        page.setLineEachPage(6);
        if (numberOfLine % page.getLineEachPage() == 0) {
            page.setTotalPage(numberOfLine / page.getLineEachPage());
        } else {
            page.setTotalPage(numberOfLine / page.getLineEachPage() + 1);
        }
        return page;
    }

    @Override
    public List<News> showRecentNews() {
        return newsDao.selectRecentNews();
    }

    //   新加入 prize
    @Override
    public Prize addNewPrize(MultipartFile img, Prize prize) {
        //  保存照片
        String basePath = ImageStorageUtil.getStoreImage();
        String uuid = UUID.randomUUID().toString();
        prize.setPhoto("PrizeImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + prize.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新prize的所有信息
        Integer result = prizeDao.insertPrize(prize);
        System.out.println("Prize id: " + prize.getPrize_id());

        //  此prize的prize_id已经被mybatis填充
        if (result == 1) {
            return prize;
        } else return null;
    }

    //    Prize Detail 显示
    @Override
    public Prize showPrizeDetail(Prize prize) {
        return prizeDao.selectPrizeByID(prize);
    }

    //    删除所选prize
    @Override
    public boolean deleteSelectedPrize(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<Prize> prizes = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                Prize prize = new Prize();
                prize.setPrize_id(Integer.parseInt(key));
                prize = prizeDao.selectPrizeByID(prize);
                prizes.add(prize);
            }
        }
        Integer result = prizeDao.deletePrizesByID(prizes);
        //        删除服务器图片文件
        for (Prize prize: prizes) {
            deletePrizePhoto(prize);
        }
        if (result == prizes.size()) {
            System.out.println("Delete Prizes Successfully! ");
            return true;
        } else {
            return false;
        }
    }

    //    删除单个prize
    @Override
    public boolean deleteOnePrize(Prize prize) {
        List<Prize> prizes = new ArrayList<>();
        prizes.add(prize);
        deletePrizePhoto(prizeDao.selectPrizeByID(prize));
        Integer result = prizeDao.deletePrizesByID(prizes);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    Method: 删除faculty照片文件
    public void deletePrizePhoto(Prize prize) {
        String basePath = ImageStorageUtil.getStoreImage();
        new File(basePath + prize.getPhoto()).delete();
    }

    //  更新prize信息
    @Override
    public boolean updatePrize(MultipartFile img, Prize prize) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            prize.setPhoto(prizeDao.selectPrizeByID(prize).getPhoto());
            String basePath = ImageStorageUtil.getStoreImage();
            deletePrizePhoto(prize);
            String uuid = UUID.randomUUID().toString();
            prize.setPhoto("PrizeImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + prize.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = prizeDao.updateAllPrizeByID(prize);
        }
        //  如果图片为空，不改变图片
        else {
            result = prizeDao.updatePartPrizeByID(prize);
        }

        if (result == 1) {
            return true;
        } else
            return false;
    }

    @Override
    public List<Prize> showIndexPrize() {
        return prizeDao.selectRecentThreePrize();
    }


}

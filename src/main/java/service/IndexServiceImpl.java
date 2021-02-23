package service;

import dao.IndexDao;
import dao.NewsDao;
import domain.Index;
import domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    public IndexDao indexDao;

    @Autowired
    public NewsDao newsDao;

    @Override
    public List<News> showRecentNews() {
        return newsDao.selectRecentNews();
    }

    @Override
    public boolean addNewIndex(MultipartFile img, Index index) throws IOException {
        String uuid = UUID.randomUUID().toString();
        index.setImg("IndexImg/" + uuid + ".png");
        img.transferTo(new File("D:\\WEB-IMG\\CSWebsite\\" + index.getImg()));
        Integer result = indexDao.insertNewIndex(index);
        if (result == 1){
            return true;
        }
        else return false;
    }

    @Override
    public List<Index> showIndexList() {
        return indexDao.selectAllIndex();
    }

    @Override
    public boolean deleteIndex(Index index) {
        new File("D:\\WEB-IMG\\CSWebsite\\" + indexDao.selectIndexByID(index).getImg()).delete();
        Integer result = indexDao.deleteIndex(index);
        if (result == 1){
            return true;
        }
        else {
            return false;
        }
    }
}

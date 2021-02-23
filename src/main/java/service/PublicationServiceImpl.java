package service;

import dao.NewsDao;
import dao.PublicationDao;
import domain.Page;
import domain.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    public PublicationDao publicationDao;

    @Autowired
    public NewsDao newsDao;

    @Override
    public List<Publication> showPublicationList(Page page) {
        page.setLineEachPage(6);
        int currentPage = page.getCurrentPage();
        int currentLine = (currentPage - 1) * (page.getLineEachPage());
        page.setCurrentLine(currentLine);
        return publicationDao.showAllPublication(page);
    }

    @Override
    public List<Publication> showPublicationList(Publication publication, Page page) {
        List<Publication> publications = new ArrayList<>();

        if (publication.getPublication_id() != 0) {
            publications.add(publicationDao.selectPublicationByID(publication));
        } else if (!publication.getTitle().equals("null")) {
            page.setLineEachPage(6);
            int currentPage = page.getCurrentPage();
            int currentLine = (currentPage - 1) * (page.getLineEachPage());
            page.setCurrentLine(currentLine);
            publications = publicationDao.selectPublicationByName(publication, page);
        }

        return publications;
    }

    @Override
    public Page showPageList() {
        Page page = new Page();
        Integer numberOfLine = publicationDao.showNumberOfLine();
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
    public Page showPageList(Publication publication) {
        Page page = new Page();
        Integer numberOfLine = 0;
        if (publication.getPublication_id() != 0) {
            numberOfLine = 1;
        } else {
            numberOfLine = publicationDao.showNumberOfLineByName(publication);
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

    //   新加入 publication
    @Override
    public Publication addNewPublication(Publication publication) {
        //  向数据库插入新publication的所有信息
        Integer result = publicationDao.insertPublication(publication);
        System.out.println("Publication id: " + publication.getPublication_id());

        //  此publication的publication_id已经被mybatis填充
        if (result == 1) {
            return publication;
        } else return null;
    }

    //    Publication Detail 显示
    @Override
    public Publication showPublicationDetail(Publication publication) {
        return publicationDao.selectPublicationByID(publication);
    }

    //    删除所选publication
    @Override
    public boolean deleteSelectedPublication(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<Publication> publications = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                Publication publication = new Publication();
                publication.setPublication_id(Integer.parseInt(key));
                publication = publicationDao.selectPublicationByID(publication);
                publications.add(publication);
            }
        }
        Integer result = publicationDao.deletePublicationsByID(publications);
        if (result == publications.size()) {
            System.out.println("Delete Publications Successfully! ");
            return true;
        } else {
            return false;
        }
    }

    //    删除单个publication
    @Override
    public boolean deleteOnePublication(Publication publication) {
        List<Publication> publications = new ArrayList<>();
        publications.add(publication);
        Integer result = publicationDao.deletePublicationsByID(publications);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //  更新publication信息
    @Override
    public boolean updatePublication(Publication publication) {
        Integer result = publicationDao.updatePublicationByID(publication);

        if (result == 1) {
            return true;
        } else
            return false;
    }
}

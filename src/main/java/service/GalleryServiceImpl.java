package service;

import dao.GalleryDao;
import domain.Gallery;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utils.ImageStorageUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    public GalleryDao galleryDao;

    @Override
    public List<Gallery> showGalleryList(Page page) {
        page.setLineEachPage(6);
        int currentPage = page.getCurrentPage();
        int currentLine = (currentPage - 1) * (page.getLineEachPage());
        page.setCurrentLine(currentLine);
        return galleryDao.showAllGallery(page);
    }

    @Override
    public List<Gallery> showGalleryList(Gallery gallery, Page page) {
        List<Gallery> gallerys = new ArrayList<>();

        if (gallery.getGallery_id() != 0) {
            gallerys.add(galleryDao.selectGalleryByID(gallery));
        } else if (!gallery.getTitle().equals("null")) {
            page.setLineEachPage(6);
            int currentPage = page.getCurrentPage();
            int currentLine = (currentPage - 1) * (page.getLineEachPage());
            page.setCurrentLine(currentLine);
            gallerys = galleryDao.selectGalleryByTitle(gallery, page);
        }

        return gallerys;
    }

    @Override
    public Page showPageList() {
        Page page = new Page();
        Integer numberOfLine = galleryDao.showNumberOfLine();
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
    public Page showPageList(Gallery gallery) {
        Page page = new Page();
        Integer numberOfLine = 0;
        if (gallery.getGallery_id() != 0) {
            numberOfLine = 1;
        } else {
            numberOfLine = galleryDao.showNumberOfLineByTitle(gallery);
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
    public List<Gallery> showRecentGallery() {
        return galleryDao.selectRecentGallery();
    }

    //   新加入 gallery
    @Override
    public Gallery addNewGallery(MultipartFile img, Gallery gallery) {
        //  保存照片
        String basePath = ImageStorageUtil.getStoreImage();
        String uuid = UUID.randomUUID().toString();
        gallery.setPhoto("GalleryImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + gallery.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新gallery的所有信息
        Integer result = galleryDao.insertGallery(gallery);
        System.out.println("Gallery id: " + gallery.getGallery_id());

        //  此gallery的gallery_id已经被mybatis填充
        if (result == 1) {
            return gallery;
        } else return null;
    }

    //    Gallery Detail 显示
    @Override
    public Gallery showGalleryDetail(Gallery gallery) {
        Gallery gallery1 = galleryDao.selectGalleryByID(gallery);
        return gallery1;
    }

    //    删除所选gallery
    @Override
    public boolean deleteSelectedGallery(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<Gallery> gallerys = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                Gallery gallery = new Gallery();
                gallery.setGallery_id(Integer.parseInt(key));
                gallery = galleryDao.selectGalleryByID(gallery);
                gallerys.add(gallery);
            }
        }
        Integer result = galleryDao.deleteGalleryByID(gallerys);
        //        删除服务器图片文件
        for (Gallery gallery: gallerys) {
            deleteGalleryPhoto(gallery);
        }
        if (result == gallerys.size()) {
            System.out.println("Delete Gallerys Successfully! ");
            return true;
        } else {
            return false;
        }
    }

    //    删除单个gallery
    @Override
    public boolean deleteOneGallery(Gallery gallery) {
        List<Gallery> gallerys = new ArrayList<>();
        gallerys.add(gallery);
        deleteGalleryPhoto(galleryDao.selectGalleryByID(gallery));
        Integer result = galleryDao.deleteGalleryByID(gallerys);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    Method: 删除faculty照片文件
    public void deleteGalleryPhoto(Gallery gallery) {
        String basePath = ImageStorageUtil.getStoreImage();
        new File(basePath + gallery.getPhoto()).delete();
    }

    //  更新gallery信息
    @Override
    public boolean updateGallery(MultipartFile img, Gallery gallery) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            gallery.setPhoto(galleryDao.selectGalleryByID(gallery).getPhoto());
            String basePath = ImageStorageUtil.getStoreImage();
            deleteGalleryPhoto(gallery);
            String uuid = UUID.randomUUID().toString();
            gallery.setPhoto("GalleryImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + gallery.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = galleryDao.updateAllGalleryByID(gallery);
        }
        //  如果图片为空，不改变图片
        else {
            result = galleryDao.updatePartGalleryByID(gallery);
        }

        if (result == 1) {
            return true;
        } else
            return false;
    }

}

package service;

import domain.Gallery;
import domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface GalleryService {

    //    分页展示Gallery List内容(无关键词）
    public List<Gallery> showGalleryList(Page page);

    //    分页展示Gallery List内容(有关键词）
    public List<Gallery> showGalleryList(Gallery gallery, Page page);

    //页码展示 (无关键词）
    public Page showPageList();

    //页码展示 (有关键词）
    public Page showPageList(Gallery gallery);

    //    添加功能：
    //    1. Add界面展示recent gallery
    public List<Gallery> showRecentGallery();

    //    2. Add 功能
    public Gallery addNewGallery(MultipartFile img, Gallery gallery);


    //    查询gallery详细信息
    public Gallery showGalleryDetail(Gallery gallery);

    //    删除：
    //    1. 单个删除
    public boolean deleteOneGallery(Gallery gallery);

    //    2. 批量删除
    public boolean deleteSelectedGallery(Map<String, String[]> paraMap);

    //    更新 Gallery 信息
    public boolean updateGallery(MultipartFile img, Gallery gallery);


}

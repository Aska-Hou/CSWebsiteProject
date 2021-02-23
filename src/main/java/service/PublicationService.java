package service;

import domain.News;
import domain.Page;
import domain.Publication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface PublicationService {

    //    分页展示Publication List内容(无关键词）
    public List<Publication> showPublicationList(Page page);

    //    分页展示Publication List内容(有关键词）
    public List<Publication> showPublicationList(Publication publication, Page page);

    //页码展示 (无关键词）
    public Page showPageList();

    //页码展示 (有关键词）
    public Page showPageList(Publication publication);

    //    添加功能：
    //    Add 功能
    public Publication addNewPublication(Publication publication);


    //    查询publication详细信息
    public Publication showPublicationDetail(Publication publication);

    //    删除：
    //    1. 单个删除
    public boolean deleteOnePublication(Publication publication);

    //    2. 批量删除
    public boolean deleteSelectedPublication(Map<String, String[]> paraMap);

    //    更新 Publication 信息
    public boolean updatePublication(Publication publication);


}

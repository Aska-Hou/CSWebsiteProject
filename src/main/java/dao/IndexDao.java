package dao;

import domain.Index;

import java.util.List;

public interface IndexDao {

    public Integer insertNewIndex(Index index);

    public List<Index> selectAllIndex();

    public Integer deleteIndex(Index index);

    public Index selectIndexByID(Index index);
}

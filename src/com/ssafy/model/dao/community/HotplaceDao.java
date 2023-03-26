package com.ssafy.model.dao.community;

import com.ssafy.model.dto.community.Hotplace;

import java.sql.SQLException;
import java.util.List;

public interface HotplaceDao {
    List<Hotplace> selectRecent() throws SQLException;
    List<Hotplace> selectOrderHit() throws SQLException;
    List<Hotplace> selectById(String id) throws SQLException;

    Hotplace selectByHotplaceNo(int hotplaceNo) throws SQLException;

    int insertByHotplace(Hotplace hotplace) throws SQLException;

    int updateHitByHotplaceNo(int hotplaceNo) throws SQLException;
    int updateByHotplace(Hotplace hotplace) throws SQLException;

    int deleteByHotplaceNo(int hotplaceNo) throws SQLException;
}

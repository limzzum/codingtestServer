package com.ssafy.model.dao.community;

import com.ssafy.model.dto.community.Tip;

import java.sql.SQLException;
import java.util.List;

public interface TipDao {
    List<Tip> selectRecent() throws SQLException;
    List<Tip> selectById(String id) throws SQLException;
    Tip selectByTipNo(int tipNo) throws SQLException;

    int insertByTip(Tip tip) throws SQLException;

    int updateHitByTipNo(int tipNo) throws SQLException;
    int updateByTip(Tip tip) throws SQLException;

    int deleteByTipNo(int tipNo) throws SQLException;
}

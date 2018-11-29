package me.bestsamcn.blog.convertors;

import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.enums.CommentStatus;
import me.bestsamcn.blog.enums.PictureType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Sam
 * @Date: 2018/11/27 21:13
 */
public class PictureTypeHandler implements TypeHandler<PictureType> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, PictureType pictureType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, pictureType.getKey());
    }

    @Override
    public PictureType getResult(ResultSet resultSet, String s) throws SQLException {
        int key = resultSet.getInt(s);
        return PictureType.getKey(key);
    }

    @Override
    public PictureType getResult(ResultSet resultSet, int i) throws SQLException {
        int key = resultSet.getInt(i);
        return PictureType.getKey(key);
    }

    @Override
    public PictureType getResult(CallableStatement callableStatement, int i) throws SQLException {
        int key = callableStatement.getInt(i);
        return PictureType.getKey(key);
    }
}

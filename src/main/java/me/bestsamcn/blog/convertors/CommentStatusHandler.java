package me.bestsamcn.blog.convertors;

import me.bestsamcn.blog.enums.ArticleType;
import me.bestsamcn.blog.enums.CommentStatus;
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
public class CommentStatusHandler implements TypeHandler<CommentStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, CommentStatus commentStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, commentStatus.getKey());
    }

    @Override
    public CommentStatus getResult(ResultSet resultSet, String s) throws SQLException {
        int key = resultSet.getInt(s);
        return CommentStatus.getKey(key);
    }

    @Override
    public CommentStatus getResult(ResultSet resultSet, int i) throws SQLException {
        int key = resultSet.getInt(i);
        return CommentStatus.getKey(key);
    }

    @Override
    public CommentStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        int key = callableStatement.getInt(i);
        return CommentStatus.getKey(key);
    }
}

package me.bestsamcn.blog.convertors;

/**
 * @Author: Sam
 * @Date: 2018/11/13 21:20
 */

import me.bestsamcn.blog.enums.ArticleType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 文章类型转换类
 */
public class ArticleTypeHandler implements TypeHandler<ArticleType> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, ArticleType articleType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, articleType.getKey());
    }

    @Override
    public ArticleType getResult(ResultSet resultSet, String s) throws SQLException {
        int key = resultSet.getInt(s);
        return ArticleType.getKey(key);
    }

    @Override
    public ArticleType getResult(ResultSet resultSet, int i) throws SQLException {
        int key = resultSet.getInt(i);
        return ArticleType.getKey(key);
    }

    @Override
    public ArticleType getResult(CallableStatement callableStatement, int i) throws SQLException {
        int key = callableStatement.getInt(i);
        return ArticleType.getKey(key);
    }
}

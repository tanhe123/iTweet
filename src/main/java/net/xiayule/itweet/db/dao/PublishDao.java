package net.xiayule.itweet.db.dao;

import net.sf.json.JSONArray;
import net.xiayule.itweet.db.entity.Publish;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.validation.constraints.AssertFalse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhiyou on 16-1-25.
 */

public class PublishDao {
    private SimpleJdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(Publish publish){
        String sql = "insert into publish(P_content)values(?)";
        jdbcTemplate.update(sql,publish.getContent());
    }
    public JSONArray findall(){
        String sql = "select * from publish order by P_id DESC limit 5";
        List list = jdbcTemplate.queryForList(sql);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray;
    }
}

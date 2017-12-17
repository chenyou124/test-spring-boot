package name.taolei.zealot.test.springboot.web.mybatis.dao;

import name.taolei.zealot.test.springboot.web.mybatis.config.Mapper;
import name.taolei.zealot.test.springboot.web.mybatis.entity.Test;

@Mapper
public interface TestDao {
    Test getById(int id);

    void update(Test test);
}

package name.taolei.zealot.test.springboot.web.mvcInnerTomcat.dao;

import name.taolei.zealot.test.springboot.web.mvcInnerTomcat.config.mybatis.Mapper;
import name.taolei.zealot.test.springboot.web.mvcInnerTomcat.entity.Test;

@Mapper
public interface TestDao {
    Test getById(int id);

    void update(Test test);
}

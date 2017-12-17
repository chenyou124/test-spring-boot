package name.taolei.zealot.test.springboot.web.withoutParent.son.dao;

import name.taolei.zealot.test.springboot.web.withoutParent.son.config.mybatis.Mapper;
import name.taolei.zealot.test.springboot.web.withoutParent.son.entity.Test;

@Mapper
public interface TestDao {
    Test getById(int id);

    void update(Test test);
}

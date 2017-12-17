package name.taolei.zealot.test.springboot.web.withoutParent.son.service;

import name.taolei.zealot.test.springboot.web.withoutParent.son.dao.TestDao;
import name.taolei.zealot.test.springboot.web.withoutParent.son.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    @Autowired
    private TestDao testDao;

    public String doSomething(){
        Test test = testDao.getById(2);
        test.setA("asdf");
        testDao.update(test);
        test = testDao.getById(2);
        return "index";
    }
}

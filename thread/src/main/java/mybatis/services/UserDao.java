package mybatis.services;

import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from xxx")
    public void query();
}

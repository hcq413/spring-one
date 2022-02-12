package service;

public class Userimpl implements UserDao {

    /**
     * 获取名称
     *
     * @param name 名字
     * @return {@link String}
     */
    @Override
    public String getName(String name) {
        return "他的名字是:"+name;
    }
}

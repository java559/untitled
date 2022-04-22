package JDBC.dao_.test;

import JDBC.dao_.dao.ActorDAO;
import JDBC.dao_.dao.AdminDAO;
import JDBC.dao_.domain.Actor;
import JDBC.dao_.domain.Admin;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testDAO {
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors =
                actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("==============查询结果=============");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        Actor actor =
                actorDAO.querySingle("select * from actor where id = ?", Actor.class, 3);
        System.out.println("==============查询单行结果=============");
        System.out.println(actor);

        Object obj = actorDAO.queryScalar("select name from actor where id = ?", 2);
        System.out.println("==============查询单行单列结果=============");
        System.out.println(obj);

        int update =
                actorDAO.update("insert into actor values (null,?,?,?,?)",
                        "张无忌", "男", "2000-11-11", "999");
        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");

    }

    @Test
    public void testAdminDAO(){
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> admins = adminDAO.queryMulti("select * from admin", Admin.class);
        System.out.println(admins);
    }
}

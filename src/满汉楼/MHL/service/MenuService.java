package 满汉楼.MHL.service;

import 满汉楼.MHL.dao.MenuDAO;
import 满汉楼.MHL.domain.Menu;

import java.util.List;

public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> list() {
        List<Menu> menus = menuDAO.queryMulti("select * from menu", Menu.class);
        return menus;
    }

    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }

}

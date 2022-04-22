package JDBC.dao_.test;

import JDBC.dao_.dao.GoodsDAO;
import JDBC.dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class testGoods {
    @Test
    public void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();

//        int update1 =
//                goodsDAO.update("insert into goods values (?,?,?)",
//                        30, "小米手机", 1000);
//        System.out.println(update1 > 0 ? "执行成功" : "执行没有影响表");

//        int update2 = goodsDAO.update("delete from Goods where id = ?",
//                20);
//        System.out.println(update2 > 0 ? "执行成功" : "执行没有影响表");
//
//        int update3 = goodsDAO.update("update Goods set price = ? where id = ?",
//                5000, 10);
//        System.out.println(update3 > 0 ? "执行成功" : "执行没有影响表");


        List<Goods> goodses = goodsDAO.queryMulti("select * from goods",
                Goods.class);
        System.out.println("==============查询结果==============");
        for (Goods goods : goodses) {
            System.out.println(goods);
        }

        Goods goods = goodsDAO.querySingle("select * from goods where id = ?",
                Goods.class, 10);
        System.out.println("==============查询单行结果==============");
        System.out.println(goods);

        Object obj = goodsDAO.queryScalar("select goods_name from goods where id = ?",
                10);
        System.out.println("==============查询单行单列结果==============");
        System.out.println(obj);

    }
}

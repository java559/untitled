package 满汉楼.MHL.service;

import 满汉楼.MHL.dao.BillDAO;
import 满汉楼.MHL.dao.MultiTableDAO;
import 满汉楼.MHL.domain.Bill;
import 满汉楼.MHL.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

public class BillService {

    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    public boolean orderMenu(int menuId, int nums, int diningTableId) {

        String billID = UUID.randomUUID().toString();

        int update = billDAO.update("insert into bill values (null,?,?,?,?,?,now(),'未结账')",
                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }

    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId=menu.id",
                MultiTableBean.class);
    }

    public boolean hasPayBillByDiningTableId(int diningTableId){
        Bill bill = billDAO.querySingle("select * from bill where diningTableId=? and state='未结账' limit 0,1",
                Bill.class, diningTableId);
        return bill != null;
    }

    public boolean payBill(int diningTableId,String padMode){
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'",
                padMode, diningTableId);

        if (update <= 0){
            return false;
        }

        if (!diningTableService.updateDiningTableToFree(diningTableId,"空")){
            return false;
        }

        return true;

    }

}

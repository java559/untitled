package 面向对象.房屋出租系统.view;

import 面向对象.房屋出租系统.domain.House;
import 面向对象.房屋出租系统.service.HouseService;
import 面向对象.房屋出租系统.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char choice;
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        do {
            System.out.println("\n--------------面向对象.房屋出租系统--------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房源");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");
            System.out.print("请选择（1-6）：");
            choice = Utility.readChar();
            switch (choice) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }

    public void listHouses() {
        System.out.println("-------------房屋列表--------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null)
                break;
            System.out.println(houses[i]);
        }
        System.out.println("-------------房屋列表完成---------------");
    }

    public void addHouse() {
        System.out.println("--------------添加房屋--------------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("--------------添加房屋成功--------------");
        } else {
            System.out.println("--------------添加房屋失败--------------");
        }
    }

    public void delHouse() {
        System.out.println("--------------删除房屋--------------");
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("--------------放弃删除房屋--------------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("--------------删除房屋成功--------------");
            } else {
                System.out.println("--------------房屋编号不存在，删除失败--------------");
            }
        } else {
            System.out.println("--------------放弃删除房屋--------------");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y')
            loop = false;
    }

    public void findHouse() {
        System.out.println("--------------查找房屋--------------");
        System.out.print("请输入待查找房屋的编号(-1退出):");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("--------------放弃查找房屋--------------");
            return;
        }
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
            System.out.println(house);
        } else {
            System.out.println("--------------房屋编号不存在，查找失败--------------");
        }
    }

    public void updateHouse() {
        System.out.println("--------------修改房屋--------------");
        System.out.print("请输入待修改房屋的编号(-1退出):");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("--------------放弃修改房屋--------------");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null){
            System.out.println("--------------房屋编号不存在，修改失败--------------");
            return;
        }

        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, house.getName());
        house.setName(name);

        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, house.getPhone());
        house.setPhone(phone);

        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(16, house.getAddress());
        house.setAddress(address);

        System.out.print("月租(" + house.getRent() + "):");
        int rent = Utility.readInt(house.getRent());
        house.setRent(rent);

        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, house.getState());
        house.setState(state);

    }

}

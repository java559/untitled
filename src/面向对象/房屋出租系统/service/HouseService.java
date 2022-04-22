package 面向对象.房屋出租系统.service;

import 面向对象.房屋出租系统.domain.House;

public class HouseService {

    private House[] houses;
    private int houseNums = 0;
    private int idCounter = 0;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (houseNums == houses.length) {
            System.out.println("数组已满");
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }

    public House findById(int findId) {
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

}

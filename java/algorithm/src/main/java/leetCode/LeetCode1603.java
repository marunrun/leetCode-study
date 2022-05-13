package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1603 {


    class ParkingSystem {

        Map<Integer, Integer> map = new HashMap<>();

        public ParkingSystem(int big, int medium, int small) {
            map.put(1, big);
            map.put(2, medium);
            map.put(3, small);
        }

        public boolean addCar(int carType) {
            if (map.get(carType) > 0) {

                map.put(carType, map.get(carType) - 1);
                return true;
            }
            return false;
        }
    }

}

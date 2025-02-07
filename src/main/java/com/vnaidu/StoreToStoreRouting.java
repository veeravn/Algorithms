package com.vnaidu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class StoreToStoreRouting extends Base{

    static class Store {

        private final Integer storeId;
        private final List<Store> neighborStores;

        public Store(int storeId) {
            this.storeId = storeId;
            this.neighborStores = new ArrayList<>();
        }

        public Integer getStoreId() {
            return storeId;
        }

        public List<Store> getNeighborStores() {
            return neighborStores;
        }

        public void addNeighbor(Store store) {
            this.neighborStores.add(store);
        }
    }

    public static boolean canReach(Store origin, int destinationId) {
        if (origin == null) return false;
        if (origin.getStoreId() == destinationId) return true;

        Set<Integer> visited = new HashSet<>();
        Queue<Store> queue = new LinkedList<>();
        queue.add(origin);
        visited.add(origin.getStoreId());

        while (!queue.isEmpty()) {
            Store current = queue.poll();
            for (Store neighbor : current.getNeighborStores()) {
                if (neighbor.getStoreId() == destinationId) {
                    return true;
                }
                if (!visited.contains(neighbor.getStoreId())) {
                    visited.add(neighbor.getStoreId());
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Store store1 = new Store(1);
        Store store2 = new Store(2);
        Store store3 = new Store(3);
        Store store4 = new Store(4);
        Store store5 = new Store(5);

        store1.addNeighbor(store2);
        store2.addNeighbor(store3);
        store3.addNeighbor(store4);
        store4.addNeighbor(store5);

        logger.info(Boolean.toString(canReach(store1, 5))); // Output: true
        logger.info(Boolean.toString(canReach(store1, 6))); // Output: false
    }
}

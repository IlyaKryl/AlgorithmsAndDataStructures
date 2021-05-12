package GreedyAlgorithms.KnapsackProblem;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final int maxWeight; //максимальная вместимость рюкзака
    private List<Item> items;
    private int currentWeight; //текущий вес всех вещей в рюкзаке
    private int currentCost;   //текущая стоимость всех вещей в рюкзаке

    public Bag(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
        currentCost = 0;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public void getItems() {
        System.out.println("Предметы в рюкзаке:");
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public void addItem(Item item) {
        items.add(item);
        currentWeight += item.getWeight();
        currentCost += item.getCost();
    }

    @Override
    public String toString() {
        return "Вес рюкзака с предметами составляет: " + currentWeight + "\n" +
                "Общая стоимость вещей в рюкзаке: " + currentCost;
    }
}

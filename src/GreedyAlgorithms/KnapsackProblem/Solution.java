package GreedyAlgorithms.KnapsackProblem;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("гитара", 7, 800));
        items.add(new Item("утюг", 6, 500));
        items.add(new Item("чайник", 3, 300));
        items.add(new Item("лампа", 4, 500));
        items.add(new Item("телевизор", 15, 2000));
        items.add(new Item("ваза", 2, 450));
        items.add(new Item("миксер", 1, 400));
        items.add(new Item("блендер", 3, 200));

        Collections.sort(items);  //сортируем предметы по стоимости от большего к меньшему

        Bag firstBag = new Bag(30);
        fillBackpack(firstBag, items);

        System.out.println(firstBag);
        firstBag.getItems();

        Bag secondBag = new Bag(30);
        effectiveFillBackpack(secondBag, items);

        System.out.println(secondBag);
        secondBag.getItems();
    }
    // O(N)
    public static void fillBackpack(Bag bag, List<Item> items) {
        /*
        мы начинаем проходить по отсортированному по стоимости списку элементов и складывать их в сумку,
        если позволяет вместимость. Если же не позволяет, элемент будет пропущен и продолжится
        проход по остальным элементам до конца списка.
         */
        for (Item item : items) {
            if (bag.getMaxWeight() > bag.getCurrentWeight() + item.getWeight()) {
                bag.addItem(item);
            }
        }
    }

    public static void effectiveFillBackpack(Bag bag, List<Item> items) {
        /*
        вычисляем соотношение цены и веса (стоимость одной единицы веса) для каждого предмета
        и уже по этим значениям сортируем их
        */
        Map<Double, Item> sortByRatio = new TreeMap(Collections.reverseOrder());
        for (Item item : items) {
            sortByRatio.put((double) item.getCost() / item.getWeight(), item);
        }

        for (Map.Entry<Double, Item> entry : sortByRatio.entrySet()) {
            if(bag.getMaxWeight() > bag.getCurrentWeight() + entry.getValue().getWeight()) {
                bag.addItem(entry.getValue());
            }
        }
    }
}

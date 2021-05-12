package GreedyAlgorithms.RefuelingProblem;

public class Solution {
    public static void main(String[] args) {
        int[] stations = {0, 250, 475, 950, 1100, 1275, 1500, 1750, 1900, 2000};
        System.out.println(minStops(stations, 500));
    }

    private static int minStops(int[] stations, int capacity) {
        int result = 0; // оптимальное количество остановок
        int currentStop = 0;

        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&
                stations[nextStop + 1] - stations[currentStop] <= capacity)
                nextStop++;

            if (currentStop == nextStop)
                return -1; // невозможно доехать из точки A в точку B

            if (nextStop < stations.length - 1)
                result++;

            currentStop = nextStop;
        }
        return result;
    }
}

package gann;

import java.util.Arrays;

public class GeneticAlgorithm {

    public int populationSize = 10;
    public int genSize = 22;

    public boolean isValid() {
        if (populationSize > 0
                && genSize > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        // INITIALIZATION
        Individu[] population = new Individu[populationSize];
        // GENERATE POPULASI AWAL
        for (int i = 0; i < populationSize; i++) {
            population[i] = new Individu(genSize);
            System.out.println(population[i]);
        }
    }
}

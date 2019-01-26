package chapter4;

public class TSP {
    public static int maxGenerations = 3000;
    public static void main(String[] args){
        int numCities = 100;
        City cities[] = new City[numCities];
        for(int cityIndex = 0; cityIndex < numCities; cityIndex++){
            int xPos = (int)(100 * Math.random());
            int yPos = (int)(100 * Math.random());
            cities[cityIndex] = new City(xPos, yPos);
        }
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.001,0.9,2,5);
        Population population = ga.initPopulation(cities.length);
        //TODO: evaluate population
        int generation = 1;
        while(ga.isTerminationConditionMet(generation, maxGenerations) == false){
            //TODO: print fittest individual from population
            //TODO: apply crossover
            //TODO: apply mutation
            //TODO: evaluate population
            generation++;
        }
        //TODO: display result;
    }

}

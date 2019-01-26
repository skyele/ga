package chapter4;

import java.util.Currency;

public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    protected int tournamentSize;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount, int tournamentSize){
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSize = tournamentSize;
    }

    public Population initPopulation(int chromosomeLength){
        Population population = new Population(this.populationSize, chromosomeLength);
        return population;
    }


    public boolean isTerminationConditionMet(int generationsCount, int maxGenerations){
        return (generationsCount > maxGenerations);
    }

    public Individual selectParent(Population population){
        Population tournament = new Population(this.tournamentSize);
        population.shuffle();
        for(int i = 0; i < this.tournamentSize; i++){
            Individual tournamentIndividual = population.getIndividual(i);
            tournament.setIndividual(i, tournamentIndividual);
        }
        return tournament.getFittest(0);
    }

    public double calFitness(Individual individual, City cities[]){
        Route route = new Route(individual, cities);
        double fitness = 1 / route.getDistance();
        individual.setFitness(fitness);
        return fitness;
    }
}
package chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    @Override
    public int hashCode(){
        int hash = Arrays.hashCode(this.chromosome);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Individual individual = (Individual) obj;
        return Arrays.equals(this.chromosome, individual.chromosome);
    }

    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength){
        int[] individual;
        individual = new int[chromosomeLength];

        for(int gene = 0; gene < chromosomeLength; gene++){
            individual[gene] = gene;
        }
        this.chromosome = individual;
    }

    public Individual(Timetable timetable){
        int numClasses = timetable.getNumClasses();

        int chromosomeLength = numClasses * 3;
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;
        for(Group group : timetable.getGroupsAsArray()){
            for(int moduleId : group.getModuleIds()){
                int timeslotId = timetable.getRandomTimeslot().getTimeslotId();
                newChromosome[chromosomeIndex] = timeslotId;
                chromosomeIndex++;

                int roomId = timetable.getRandomRoom().getRoomId();
                newChromosome[chromosomeIndex] = roomId;
                chromosomeIndex++;

                Module module = timetable.getModule(moduleId);
                newChromosome[chromosomeIndex] = module.getRandomProfessorId();
                chromosomeIndex++;
            }
        }
        this.chromosome = newChromosome;
    }

    public int[]  getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }

    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chromosome.length; gene++) {
            output += this.chromosome[gene];
        }
        return output;
    }

    public boolean containsGene(int gene){
        for(int i = 0; i < this.chromosome.length; i++){
            if(this.chromosome[i] == gene){
                return true;
            }
        }
        return false;
    }
}

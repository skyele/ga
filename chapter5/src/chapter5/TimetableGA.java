package chapter5;

public class TimetableGA {
    public static void main(String[] args){
        //TODO: create timetable and initialize with all the available courses, rooms, timeslots, professors, modules, and groups
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        //TODO: initialize population
        //TODO: evaluate population

        int generation = 1;
        //TODO: add termination condition
        while (true){
            //System.out.println("G" + generation + " Best fitness: " + population.);
            //TODO: apply crossover
            //TODO: apply mutation
            //TODO: evaluate population
            generation++;
        }
        //TODO: print final fitness
        //TODO: print final timetable
    }

    private static Timetable initializeTimetable(){
        Timetable timetable = new Timetable();

        timetable.addRoom(1, "A1", 15);
        timetable.addRoom(2, "B1", 30);
        timetable.addRoom(4, "D1", 20);
        timetable.addRoom(5, "F1", 25);

        timetable.addTimeslot(1, "Mon 9:00 - 11:00");
        timetable.addTimeslot(2, "Mon 11:00 - 13:00");
        timetable.addTimeslot(3, "Mon 13:00 - 15:00");
        timetable.addTimeslot(4, "Tue 9:00 - 11:00");
        timetable.addTimeslot(5, "Tue 11:00 - 13:00");
        timetable.addTimeslot(6, "Tue 13:00 - 15:00");
        timetable.addTimeslot(7, "Wed 9:00 - 11:00");
        timetable.addTimeslot(8, "Wed 11:00 - 13:00");
        timetable.addTimeslot(9, "Wed 13:00 - 15:00");
        timetable.addTimeslot(10, "Thu 9:00 - 11:00");
        timetable.addTimeslot(11, "Thu 11:00 - 13:00");
        timetable.addTimeslot(12, "Thu 13:00 - 15:00");
        timetable.addTimeslot(13, "Fri 9:00 - 11:00");
        timetable.addTimeslot(14, "Fri 11:00 - 13:00");
        timetable.addTimeslot(15, "Fri 13:00 - 15:00");

        timetable.addProfessor(1, "Dr P Smith");
        timetable.addProfessor(2, "Mrs E Mitchell");
        timetable.addProfessor(3, "Dr R Williams");
        timetable.addProfessor(4, "Mr A Thompson");

        timetable.addModule(1, "cs1", "Computer Science", new int[]{1, 2});
        timetable.addModule(2, "en1", "English", new int[]{1, 3});
        timetable.addModule(3, "ma1", "Maths", new int[]{1, 2});
        timetable.addModule(4, "ph1", "Physics", new int[]{3, 4});
        timetable.addModule(5, "hi1", "History", new int[]{4});
        timetable.addModule(6, "dr1", "Drama", new int[]{1, 4});

        timetable.addGroup(1, 10, new int[]{1, 3, 4});
        timetable.addGroup(2, 30, new int[]{2, 3, 5, 6});
        timetable.addGroup(3, 18, new int[]{3, 4, 5});
        timetable.addGroup(4, 25, new int[]{1, 4});
        timetable.addGroup(5, 20, new int[]{2, 3 ,5});
        timetable.addGroup(6, 22, new int[]{1, 4, 5});
        timetable.addGroup(7, 16, new int[]{1, 3});
        timetable.addGroup(8, 18, new int[]{2, 6});
        timetable.addGroup(9, 24, new int[]{1, 6});
        timetable.addGroup(10, 25, new int[]{3 ,4});
        
        return timetable;
    }
}

package me.estrela.java2020.switchcases;

public class WorkingWeek {

    private static final WorkingWeek workingWeek = new WorkingWeek();

    public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    private static class IllegalDayException extends IllegalStateException {
        public IllegalDayException(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(workingWeek.getWorkDone8(Day.MONDAY));
        System.out.println(workingWeek.getWorkDone14(Day.MONDAY));
        System.out.println(workingWeek.getWorkDone8(Day.TUESDAY));
        System.out.println(workingWeek.getWorkDone14(Day.TUESDAY));
        System.out.println(workingWeek.getWorkDone8(Day.WEDNESDAY));
        System.out.println(workingWeek.getWorkDone14(Day.WEDNESDAY));
        System.out.println(workingWeek.getWorkDone8(Day.FRIDAY));
        System.out.println(workingWeek.getWorkDone14(Day.FRIDAY));
        try {
            System.out.println(workingWeek.getWorkDone8(Day.SATURDAY));
        } catch (IllegalDayException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(workingWeek.getWorkDone14(Day.SATURDAY));
        } catch (IllegalDayException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getWorkDone8(Day day) {
        String workDone;
        switch (day) {
            case MONDAY:
                workDone = drinkCoffee();
                break;
            case TUESDAY:
            case WEDNESDAY:
                return doSomeWork();
            case THURSDAY:
                return getThingsDone();
            case FRIDAY:
                System.out.println("Friday!");
                return areWeDoneYet();
            default:
                throw new IllegalDayException("Weekend");
        }
        return workDone;
    }

    private String getWorkDone14(Day day) {
        return switch (day) {
            case MONDAY -> drinkCoffee();
            case TUESDAY, WEDNESDAY -> doSomeWork();
            case THURSDAY -> getThingsDone();
            case FRIDAY -> {
                System.out.println("Friday!");
                yield areWeDoneYet(); // break in Java 12
            }
            default -> throw new IllegalDayException("Weekend");
        };
    }

    private String drinkCoffee() {
        return "drinkCoffee";
    }

    private String doSomeWork() {
        return "doSomeWork";
    }

    private String getThingsDone() {
        return "getThingsDone";
    }

    private String areWeDoneYet() {
        return "areWeDoneYet";
    }

}

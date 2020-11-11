package me.estrela.java2020.hnpe;

public class Buggy {

    private static final Buggy buggy = new Buggy();

    public static void main(String[] args) {

        var repeated = buggy.repeatName(null);
        System.out.println(repeated);

    }

    private String repeatName(String name) {
        return name.repeat(5);
    }

}

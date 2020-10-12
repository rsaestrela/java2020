package me.estrela.java2020.textblocks;

import java.time.LocalDate;

public class Newspaper {

    private static final Newspaper newspaper = new Newspaper();

    private static final String TITLE = """
                New York
                  Times
            """;

    public static void main(String[] args) {
        newspaper.printCover(LocalDate.now().toString());
        newspaper.printContent();
    }

    private void printCover(String day) {
        System.out.println(TITLE + """
                Date
                """ + day);
    }

    private void printContent() {
        System.out.println(getHeadline());
        System.out.println(getTextContent1());

    }

    private String getHeadline() {
        return "%s things happened today".formatted(10);
    }

    private String getTextContent1() {
        return "\t\tOh my".stripIndent() + " " + "\t\t\t\tgosh".stripIndent();
    }

}

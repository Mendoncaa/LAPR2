package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface ReadDate {

    LocalDate readDateFromConsole(Scanner scanner, DateTimeFormatter formatter, String prompt);
}

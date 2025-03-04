package bot.parsers;

import bot.exception.DateTimeParseBotException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DatetimeParser {

    /**
     * Returns a LocalDateTime object of based on the String argument read from data/task.txt
     *
     * @param time Formatted in 'd/MM/yyyy HH:mm'
     * @return LocalDateTime object
     * @throws DateTimeParseBotException if the String Argument was not formatted correctly
     */
    public static LocalDateTime parseTimeInput(String time) throws
            DateTimeParseBotException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
            return LocalDateTime.parse(time, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseBotException("Please write your dateTime as d/MM/yyyy HH:mm");
        }
    }

    /**
     * Returns a String representation of a LocalDateTime object
     *
     * @param time LocalDateTime object
     * @return String representation of a LocalDateTime object
     */
    public static String reformatTimeOutput(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
        return time.format(formatter);
    }

    /**
     * Returns a LocalDateTime object of based on the String argument from user input
     *
     * @param time String argument from user input formatted as 'd/MM/yyyy HH:mm'
     * @return LocalDateTime object
     * @throws DateTimeParseBotException if the String Argument was not formatted correctly
     */
    public static LocalDateTime convertToLocalDateTime(String time) throws
            DateTimeParseBotException {
        try {
            return LocalDateTime.parse(time);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseBotException("The dateTime format is corrupted " +
                    "in the ./data/bot.task.txt.");
        }
    }
}

package Models;

import Utils.ConvertGrade;
import Utils.DateUtils;

import java.text.ParseException;

public class Line {

    private static final String SEPERATOR = "|";

    private String date;
    private String danishGrade;
    private String error;

    public Line(String date, String danishGrade) {
        this.date = date;
        this.danishGrade = danishGrade;
    }

    private String getGrade() {
        try {
            return ConvertGrade.convertGrade(danishGrade);
        } catch (ConvertGrade.NotADanishGradeException e) {
            if (error == null) {
                error = e.getMessage();
            } else {
                error += " & " + e.getMessage();
            }
            return "";
        }
    }

    private String getDate() {
        try {
            return DateUtils.isDateValid(date) ? date : "";
        } catch (ParseException e) {
            if (error == null) {
                error = e.getMessage();
            } else {
                error += " & " + e.getMessage();
            }
            return "";
        }
    }

    @Override
    public String toString() {
        String newDate = getDate();
        String newGrade = getGrade();
        String error = this.error != null ? this.error : "";
        return String.format("%1$8s %2$s   %3$1s   %2$s %4$s", newDate, SEPERATOR, newGrade, error);
    }
}
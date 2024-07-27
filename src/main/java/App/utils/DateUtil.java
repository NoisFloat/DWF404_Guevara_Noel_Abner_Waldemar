package App.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static java.sql.Date convertStringToDate(String dateStr) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = format1.parse(dateStr);
        } catch (ParseException e1) {
            try {
                date = format2.parse(dateStr);
            } catch (ParseException e2) {
                date = new Date();  // Si falla, retorna la fecha de hoy
            }
        }
        return (java.sql.Date) date;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println(convertStringToDate("2023-07-27")); // Formato AAAA-MM-DD
        System.out.println(convertStringToDate("27-07-2023")); // Formato DD-MM-AAAA
        System.out.println(convertStringToDate("fecha inválida")); // Fecha de hoy
    }
}

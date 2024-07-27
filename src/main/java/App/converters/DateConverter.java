package App.converters;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateConverter")
public class DateConverter implements Converter<Date> {
    private static final String[] DATE_FORMATS = {"dd-MM-yyyy", "yyyy-MM-dd"};

    @Override
    public Date getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        for (String format : DATE_FORMATS) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                // Continue to the next format
            }
        }
        throw new IllegalArgumentException("Invalid date format. Please use " + String.join(" or ", DATE_FORMATS));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Date value) {
        if (value == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATS[0]);
        return sdf.format(value);
    }
}

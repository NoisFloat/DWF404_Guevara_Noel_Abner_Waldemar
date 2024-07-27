package App.converters;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.convert.ConverterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@FacesConverter("dateConverter")
public class DateConverter implements Converter<String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat sdfStrict = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public String getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            // Validate the date format
            sdfStrict.setLenient(false);
            sdfStrict.parse(value);
            return value; // Return the string if it's a valid date
        } catch (ParseException e) {
            // Throw a ConverterException with a custom message
            throw new ConverterException("Invalid date format. Please use yyyy-MM-dd.", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, String value) {
        // Simply return the input string as is
        return value;
    }
}

package com.example.utility;

import java.time.YearMonth;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, String> {
    
    @Override
    public String convertToDatabaseColumn(YearMonth attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString(); 
    }

    @Override
    public YearMonth convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return YearMonth.parse(dbData); 
    }
}

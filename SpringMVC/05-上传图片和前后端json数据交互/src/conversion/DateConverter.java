package conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//S:传递类型	T：转换后类型
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String dateInput) {
		try {
			if (dateInput != null) {
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return df.parse(dateInput);
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}

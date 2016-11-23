package diverse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by alexandru.dima on 10/12/2016.
 */
public class dateformat {

    public static void main(String[] args) throws ParseException {
        String input = "october 11, 1984";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Date parse = sdf.parse("18/Feb/2012");
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        System.out.println(c.get(Calendar.MONTH)-3);
//        System.out.println(input);
    }
}

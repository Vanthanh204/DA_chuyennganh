package uti;

import java.text.NumberFormat;
import java.util.Locale;

public class Format {
	 private static final NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

	    public static String money(int amount) {
	        return vnFormat.format(amount);
	    }

}

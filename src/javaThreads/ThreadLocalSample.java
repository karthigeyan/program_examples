package javaThreads;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalSample {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };

    // Java 8
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal1 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public class UserService {
        public void main(String[] args) {

        }

        public String birthDate(int userId) {
//            Date birthDate = birthDateFromDB( id );
//            final SimpleDateFormat df = ThreadSafeFormatter.dateFormatThreadLocal.get();
//            return df.format(birthDate);
            return "";
        }
    }
}

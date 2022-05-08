import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    protected int num = 1;
    private static Logger logger;

    private Logger() {
    }

    public void log(String msg) {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);

        System.out.println("[" + strDate + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}

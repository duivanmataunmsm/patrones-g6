package com.edu.grupo6;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {

    private static Logger logger;

    private Logger createLogger() {
        Logger log = Logger.getLogger("ChessLog");
        SimpleDateFormat format = new SimpleDateFormat("MM-dd_HHmmss");
        try {
            FileHandler fh = new FileHandler("chess_"+ format.format(Calendar.getInstance().getTime()) +".log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return log;
    }

    public Logging() {}

    public Logger getLogger() {
        if(this.logger == null) {
            this.setLogger(createLogger());
        }

        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}

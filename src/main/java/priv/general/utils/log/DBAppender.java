package priv.general.utils.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

public class DBAppender extends UnsynchronizedAppenderBase<ILoggingEvent>{

	
	@Override
	protected void append(ILoggingEvent eventObject) {

//    	String msg = eventObject.getFormattedMessage();
//		String id = SystemUtils.getUserId();
//		String ip = SystemUtils.getRemoteAddr();
//		String timestamp = String.valueOf(System.currentTimeMillis());
		
//		String SQL = "insert into log (id, ip, datetime, msg) values (" +id + "," + ip + "," + timestamp + "," + msg + ");";
			
	
	}

}

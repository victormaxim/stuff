package base.data;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by optaros on 8/16/14.
 */
public enum NPMESSAGING {

	INVALID_LOGIN_ERR_MESSAGE,
	INVALID_LOGIN_ERR_MESSAGE2,
	MAIL_PIGALOG_SUCCESS,
	SEARCH_NO_RESULTS,
	SEARCH_ALTERNATIVE_TEXT,
	REGISTRATION_SUCCESS;

	String propValue;

	NPMESSAGING(){
		Properties properties = new Properties();

		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ENUS-DATA.properties"));
			this.propValue = properties.getProperty(this.name());
		} catch (IOException e) {
			throw new RuntimeException("Cannot find properties file", e);
		}
	}

	public String get() {
		return propValue;
	}


	}

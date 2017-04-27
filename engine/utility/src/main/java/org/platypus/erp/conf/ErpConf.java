package org.platypus.erp.conf;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ErpConf {

    boolean LOAD_DEMO_DATA = Boolean.parseBoolean(System.getProperty("org.toto.erp.data.demo.loadJson", "true"));

    /**
     * This property is always read from the server config.<br/>
     * the value must be a unsingned int<br/>
     * <strong>Default value is 10 ms</strong>
     * @return the time in ms before the {@linkplain org.platypus.erp.interceptor.logger.Loggable} interceptor start the long running task logger
     * @see Integer#parseInt(String)
     */
    static int getDelayMilliSecond(){
        return Integer.parseInt(System.getProperty("org.toto.erp.interceptor.maxLongMethod", "10"));
    }

    /**
     * This property is always read from the server config.<br/>
     * the value must be a integer<br/>
     * <strong>Default value is 15 lines</strong>
     * @return the number of line to display when a error occurred
     * @see Integer#parseInt(String)
     */
    static int getMaxLineDetails() {
        return Integer.parseInt(System.getProperty("org.toto.erp.interceptor.maxLineError", "15"));
    }

    /**
     * This property is always read from the server config.<br/>
     * the value must be a boolean<br/>
     * <strong>Default value is true</strong>
     * @return if the interceptor log the long running task
     * @see Boolean#parseBoolean(String)
     * @see ErpConf#getDelayMilliSecond() to configure the delay
     */
    static boolean useLongRunnigTask() {
        return Boolean.parseBoolean(System.getProperty("org.toto.erp.interceptor.longRunnigTask.use", "true"));
    }
}

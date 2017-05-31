package org.platypus.erp.interceptor.logger;

import org.platypus.erp.conf.ErpConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;

public class MethodInfosLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodInfosLogger.class);
	private final Logger realLogger;
	private boolean useTraceLog = true;
	
	public MethodInfosLogger(Logger realLogger) {
		this.realLogger = realLogger;
	}
	
	public void logInfo(MethodInfos methodInfos) {
		if (methodInfos.getTime() >= ErpConf.getDelayMilliSecond()) {
			if (realLogger.getName().contains("LongRunning")) {
				realLogger.info("{}, {}, [id={}], {}, {}", methodInfos.getMethod(),
						parametersToString(methodInfos.getParameters()), 
						methodInfos.getUniqueId(), methodInfos.getThreadName(), methodInfos.getTime());
			} else {
				realLogger.info("{}, {}, [id={}], {}", methodInfos.getMethod(),
						parametersToString(methodInfos.getParameters()), 
						methodInfos.getUniqueId(), methodInfos.getTime());
			}
		} else {
			realLogger.info("{}, {}, {}", methodInfos.getMethod(),
					parametersToString(methodInfos.getParameters()), methodInfos.getTime());
		}
	}

	public void logTrace(MethodInfos methodInfos) {
		for (Object parameter : methodInfos.getParameters()) {
			printXml("input", parameter);
		}
		if (methodInfos.getReturnObject() != null) {
			printXml("output", methodInfos.getReturnObject());
		}
	}
	
	private String parametersToString(List<Object> parameters) {
		String strParameters = "";
		for (Object parameter : parameters) {
			if (parameter == null) {
				strParameters += "null";
			} else if (parameter instanceof List) {
				strParameters += "List";
			} else if (isPrimitiveType(parameter)) {
				strParameters += parameter.toString();
			} else {
				strParameters += parameter.getClass().getSimpleName();
			}
			strParameters += " ";
		}
		return strParameters.replace("\n", "").replace("\r", "");
	}

	private void printXml(String type, Object parameter) {
		if (parameter == null) {
			logDetail(type + " {}", "null");
		} else if (parameter instanceof List) {
			StringBuilder buffer = new StringBuilder();
			List<?> list = (List<?>) parameter;
			for (int i = 0 ; i < list.size() && i < ErpConf.getMaxLineDetails(); i++) {
				buffer.append(objectToString(list.get(i)));
			}
			logDetail(type + "list {}", buffer.toString());
		} else if (parameter instanceof Date) {
			logDetail(type + " date : {}", parameter.toString());
		} else {
			logDetail(type + " {}", objectToString(parameter));
		}
	}

	private void logDetail(String format, String arg) {
		arg = split(arg, ErpConf.getMaxLineDetails());
		if (useTraceLog) {
			realLogger.trace(format, arg);
		} else {
			realLogger.info(format, arg);
		}
	}
	
	private String split(String val, int numberOfLines) {
		String newLine = "\n";
		int index = val.indexOf(newLine);
		int nb = 1;
		while (index != -1 && nb < numberOfLines - 1) {
			index = val.indexOf(newLine, index + 1);
			nb++;
		}
		return index == - 1 ? val : val.substring(0, index) + newLine + "...";
	}
	
	private String objectToString(Object parameter) {
		if (isPrimitiveType(parameter)) {
			return parameter.getClass().getSimpleName() + " : " + parameter.toString() + "\n";
		} else {
			return objectToXml(parameter);
		}
	}
	
	private boolean isPrimitiveType(Object object) {
		boolean primitiveType = false;
		if (object instanceof Date ||
				object instanceof String ||
				object instanceof Number) {
			primitiveType = true;
		}
		return primitiveType;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String objectToXml(Object parameter) {
		try {
			StringWriter stringWriter = new StringWriter();
			JAXBContext jc = JAXBContext.newInstance(parameter.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			String namespaceURI = null;
			Package pack = parameter.getClass().getPackage();
			if (pack != null) {
				namespaceURI = pack.getName();
			}
			QName qName = new QName(namespaceURI, parameter.getClass().getSimpleName());
			JAXBElement root = new JAXBElement(qName, parameter.getClass(), parameter);
			marshaller.marshal(root, stringWriter);
			return stringWriter.toString();
		} catch (Exception e) {
			String errorText = "error marshal object : " + parameter;
			LOGGER.error(errorText, e);
			return errorText;
		}
	}

	public void setUseTraceLog(boolean useTraceLog) {
		this.useTraceLog = useTraceLog;
	}
	
}

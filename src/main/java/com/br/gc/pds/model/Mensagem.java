package com.br.gc.pds.model;

import java.util.List;

public class Mensagem {
	private int messageType;
	private int requestId;
	private String objectReference;
	private String methodId;
	private String arguments;
	
	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getObjectReference() {
		return objectReference;
	}

	public void setObjectReference(String objectReference) {
		this.objectReference = objectReference;
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		return ""+ messageType+";"+ requestId + ";"
				+ objectReference + ";" + methodId + ";" + arguments;
	}

}

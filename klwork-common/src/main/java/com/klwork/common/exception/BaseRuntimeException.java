/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.klwork.common.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class BaseRuntimeException.
 */
public class BaseRuntimeException extends RuntimeException {
	public static final Logger logger = LoggerFactory.getLogger(BaseRuntimeException.class);
	private static final long serialVersionUID = 1L;
	/**
	 * 加工后的错误提示信息
	 */
	private String errorMessage;
	
	//注意：errorCode + messageArgs与message(构造函数的入参)的区别：
	//1、errorCode + messageArgs是为了提示给用户的信息，而用户界面就会考虑国际化。errorCode对应错误提示的串信息，
	//messageArgs是对应串的补充信息，例如：“USER_ID违反UK_T_USER_ID约束”（表示UserId列违反了唯一约束），此错误
	//提示将被分解为：1001 = {0}违反{1}约束，那么：errorCode值为1001，messageArgs={"USER_ID","UK_T_USER_ID"}；
	//2、构造函数的message入参，此提示是用于记录日志，供分析错误用，不会直接提示给业务人员。
	
	/**
	 * @param logMessage 记录日志的消息
	 */
	public BaseRuntimeException(String logMessage) {
		super(logMessage);
		//setDefaultErrorCode();
	}
	
	/**
	 * @param logMessage 记录日志的消息
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 */
	public BaseRuntimeException(String logMessage, String errorCode) {
		super(logMessage);
		initErrorMessage(errorCode);
	}
	
	/**
	 * @param logMessage 记录日志的消息
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArg 异常描述的参数，用于错误描述中仅有一个参数的情况
	 */
	public BaseRuntimeException(String logMessage, String errorCode, Object messageArg) {
		super(logMessage);
		initErrorMessage(errorCode, messageArg);
	}

	/**
	 * @param logMessage  记录日志的消息
	 * @param errorCode   错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArgs 异常描述的参数，用于错误描述中仅有一个或多个参数的情况
	 */
	public BaseRuntimeException(String logMessage, String errorCode, Object[] messageArgs) {
		super(logMessage);
		initErrorMessage(errorCode, messageArgs);
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 */
	public BaseRuntimeException(String logMessage, Throwable cause) {
		super(logMessage, cause);
		setDefaultErrorCode();
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 */
	public BaseRuntimeException(String logMessage, Throwable cause, String errorCode) {
		super(logMessage, cause);
		initErrorMessage(errorCode);
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArg 异常描述的参数，用于错误描述中仅有一个参数的情况
	 */
	public BaseRuntimeException(String logMessage, Throwable cause, String errorCode, Object messageArg) {
		super(logMessage, cause);
		initErrorMessage(errorCode, messageArg);
	}

	/**
	 * @param logMessage  记录日志的消息
	 * @param cause       引起异常的原始异常
	 * @param errorCode   错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArgs 异常描述的参数，用于错误描述中仅有一个或多个参数的情况
	 */
	public BaseRuntimeException(String logMessage, Throwable cause, String errorCode, Object[] messageArgs) {
		super(logMessage, cause);
		initErrorMessage(errorCode, messageArgs);
	}

	/**
	 * @param cause 引起异常的原始异常
	 */
	public BaseRuntimeException(Throwable cause) {
		super(cause);
		setDefaultErrorCode();
	}
	
	/**
	 * 设置错误消息的错误代码，用于在构造函数中没有设置errorCode的情况。如果在构造函数中设置的errorCode，那么此设置将覆盖原设置。
	 * 
	 * @param errorCode 错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 */
	public void initErrorMessage(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * 设置错误消息的错误代码，用于在构造函数中没有设置errorCode和messageArg的情况。如果在构造函数中设置的errorCode和messageArg，那么此设置将覆盖原设置。
	 * 
	 * @param errorCode 错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArg 异常描述的参数，用于错误描述中仅有一个参数的情况
	 */
	public void initErrorMessage(String errorCode, Object messageArg) {
		initErrorMessage(errorCode, new Object[] {messageArg});
	}
	
	private String errorCode;
	private Object[] messageArgs;
	
	/**
	 * 设置错误消息的错误代码，用于在构造函数中没有设置errorCode和messageArgs的情况。如果在构造函数中设置的errorCode和messageArgs，那么此设置将覆盖原设置。
	 * 
	 * @param errorCode   错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArgs 异常描述的参数，用于错误描述中仅有一个或多个参数的情况
	 */
	protected void initErrorMessage(String errorCode, Object[] messageArgs) {
		this.errorCode = errorCode;
		this.messageArgs = messageArgs;
	}
	
	/**
	 * 设置默认的ErrorCode
	 */
	protected void setDefaultErrorCode() {
		this.errorCode = "ERR-000";
	}
	
	/**
	 * 得到具体的错误消息
	 */
	public String getErrorMessage() {
		if(errorMessage == null) {
			if(errorCode != null) {
				StringBuffer sb = new StringBuffer(errorCode).append(":");
				//sb.append(I18nMessasgeSource.findText("error", errorCode, messageArgs));
				errorMessage = sb.toString();
			} else {
				//如果未定义ErrorCode，那么直接将未国际化的日志信息作为提示信息。
				errorMessage = this.getMessage();
			}
		}
		return errorMessage;
	}
	
}

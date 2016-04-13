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

/**
 * The Class ApplicationException.
 */
public class ApplicationException extends BaseRuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param logMessage 记录日志的消息
	 */
	public ApplicationException(String logMessage) {
		super(logMessage);
	}
	
	/**
	 * @param logMessage 记录日志的消息
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 */
	public ApplicationException(String logMessage, String errorCode) {
		super(logMessage, errorCode);
	}
	
	/**
	 * @param logMessage 记录日志的消息
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArg 异常描述的参数，用于错误描述中仅有一个参数的情况
	 */
	public ApplicationException(String logMessage, String errorCode, Object messageArg) {
		super(logMessage, errorCode, messageArg);
	}

	/**
	 * @param logMessage  记录日志的消息
	 * @param errorCode   错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArgs 异常描述的参数，用于错误描述中仅有一个或多个参数的情况
	 */
	public ApplicationException(String logMessage, String errorCode, Object[] messageArgs) {
		super(logMessage, errorCode, messageArgs);
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 */
	public ApplicationException(String logMessage, Throwable cause) {
		super(logMessage, cause);
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 */
	public ApplicationException(String logMessage, Throwable cause, String errorCode) {
		super(logMessage, cause, errorCode);
	}

	/**
	 * @param logMessage 记录日志的消息
	 * @param cause      引起异常的原始异常
	 * @param errorCode  错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArg 异常描述的参数，用于错误描述中仅有一个参数的情况
	 */
	public ApplicationException(String logMessage, Throwable cause, String errorCode, Object messageArg) {
		super(logMessage, cause, errorCode, messageArg);
	}

	/**
	 * @param logMessage  记录日志的消息
	 * @param cause       引起异常的原始异常
	 * @param errorCode   错误代码，此错误代码将对应一条可国际化的异常描述，此类似与Oracle等的错误代码
	 * @param messageArgs 异常描述的参数，用于错误描述中仅有一个或多个参数的情况
	 */
	public ApplicationException(String logMessage, Throwable cause, String errorCode, Object[] messageArgs) {
		super(logMessage, cause, errorCode, messageArgs);
	}

}

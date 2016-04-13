package com.klwork.spring.vertx.req;

import io.vertx.ext.web.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReqHandle
 *
 * @author Young
 * @date 2015/11/21 0021
 */
public class ReqHandle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqHandle.class);

    private static final String SESSION_USER = "user";

    public static void setOperator(Session session, String operator) {
        RequestThreadLocal requestThreadLocal = RequestThreadLocal.getInstance();
        requestThreadLocal.setUser(operator);
        session.put(SESSION_USER, operator);
    }

    public static RequestThreadLocal bindRequest(Session session) {


        String user = (String) session.get(SESSION_USER);
        RequestThreadLocal reqThreadLocal = RequestThreadLocal.getInstance();
        reqThreadLocal.setUser(user);

        if (LOGGER.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder("======================================================\n");
            sb.append(reqThreadLocal);
            sb.append("\n======================================================");
            LOGGER.debug(sb.toString());
        }

        return reqThreadLocal;
    }

    public static void unbindRequest() {
        RequestThreadLocal.getInstance().clear();
    }

}

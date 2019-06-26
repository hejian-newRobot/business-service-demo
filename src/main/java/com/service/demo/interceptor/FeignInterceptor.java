package com.service.demo.interceptor;

import com.service.demo.util.StringUtil;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import feign.RequestInterceptor;
import feign.RequestTemplate;


/**
 * 处理Feign调用其他系统的时候，往请求头里面加上 token这个参数
 * RequestInterceptor
 *
 * @author hejian
 * 2019/6/25 12:30
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {

    private static String AUTHORIZATION = "Authorization";

    private static String ACCESS_TOKEN = "access_token";

    @Override
    public void apply(RequestTemplate template) {
        HttpServletRequest request = Objects.requireNonNull(getHttpServletRequest());
        String authorization = getHeaders(request).get(AUTHORIZATION);
        if (!StringUtil.isNullOrEmpty(authorization)) {
            template.header(AUTHORIZATION, authorization);
        } else {
            template.query(ACCESS_TOKEN, getParams(request).get(ACCESS_TOKEN));
        /*    //只对url结束做 ？号检查
            if (template.url().endsWith("?")) {
                template.append(param);
            } else {
                template.append("?" + param);
            }*/
        }
    }

    private javax.servlet.http.HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    private Map<String, String> getHeaders(javax.servlet.http.HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = String.valueOf(request.getParameter(key));
            map.put(key, value);
        }
        return map;

    }
}

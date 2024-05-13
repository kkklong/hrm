package com.qiujie.handler;

import com.alibaba.fastjson.JSON;
import com.qiujie.dto.ResponseDTO;
import com.qiujie.enums.BusinessStatusEnum;
import com.qiujie.util.WebUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String str = JSON.toJSONString(new ResponseDTO(BusinessStatusEnum.FORBIDDEN));
        // 给出异常提示信息
        WebUtil.renderString(response, str);
    }
}

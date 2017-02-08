package com.wangdh.learner.rop.sample;

import com.rop.annotation.ServiceMethodBean;
import com.rop.session.SimpleSession;
import com.wangdh.learner.rop.request.LogonRequest;
import com.wangdh.learner.rop.response.LogonResponse;

@ServiceMethodBean(version = "1.0")
public class UserService extends AbstractUserService {

	@Override
	public Object getSession(LogonRequest request) {

		// 创建会话
		SimpleSession session = new SimpleSession();
		session.setAttribute("userName", request.getUserName());
		request.getRopRequestContext().addSession("mockSessionId1", session);

		// 返回响应
	    LogonResponse logonResponse = new LogonResponse();
        logonResponse.setSessionId("mockSessionId1");
        
        return logonResponse;
	}
}

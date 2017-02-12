package com.wangdh.learner.rop.sample;

import java.util.UUID;

import com.rop.RopRequest;
import com.rop.annotation.IgnoreSignType;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.session.SimpleSession;
import com.wangdh.learner.rop.request.LogonRequest;
import com.wangdh.learner.rop.response.LogonResponse;

@ServiceMethodBean()
public class UserService {

	@ServiceMethod(method = "user.getSession", version = "1.0", needInSession = NeedInSessionType.YES)
	public Object getSession(RopRequest request) {

		LogonResponse logonResponse  = new LogonResponse();
		logonResponse.setSessionId(request.getRopRequestContext().getSession().getAttribute("userName").toString());
		
		return logonResponse;
	}

	@ServiceMethod(method = "user.login", version = "", needInSession = NeedInSessionType.NO, ignoreSign = IgnoreSignType.NO)
	public Object login(LogonRequest logonRequest) {
		String sessionId = UUID.randomUUID().toString();
		
		SimpleSession session = new SimpleSession();
		session.setAttribute("userName", sessionId);
		logonRequest.getRopRequestContext().addSession(sessionId, session);

		LogonResponse logonResponse = new LogonResponse();
		logonResponse.setSessionId(sessionId);

		return logonResponse;
	}

	@ServiceMethod(method = "user.logout", needInSession = NeedInSessionType.YES)
	public Object logout(RopRequest request) {
		request.getRopRequestContext().removeSession();

		LogonResponse logonResponse = new LogonResponse();
		logonResponse.setSessionId("true");

		return logonResponse;
	}
}

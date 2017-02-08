package com.wangdh.learner.rop.sample;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.wangdh.learner.rop.request.LogonRequest;

public interface UserServiceInterface {
	@ServiceMethod(method = "user.getSession", version = "1.0", needInSession = NeedInSessionType.NO)
	Object getSession(LogonRequest request);
}

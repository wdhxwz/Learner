package com.wangdh.learner.dubbo.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import  com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.validation.Validation;
import com.alibaba.dubbo.validation.Validator;

import javax.validation.ConstraintViolationException;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-20
 */
@Activate(group = { Constants.CONSUMER, Constants.PROVIDER }, value = Constants.VALIDATION_KEY, order = 10000)
public class ValidatorFilter implements Filter {
    private Validation validation;

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (validation != null && ! invocation.getMethodName().startsWith("$")
                && ConfigUtils.isNotEmpty(invoker.getUrl().getMethodParameter(invocation.getMethodName(), Constants.VALIDATION_KEY))) {
            try {
                Validator validator = validation.getValidator(invoker.getUrl());
                if (validator != null) {
                    validator.validate(invocation.getMethodName(), invocation.getParameterTypes(), invocation.getArguments());
                }
            } catch (RpcException e) {
                throw e;
            } catch (Throwable t) {
                if(t instanceof ConstraintViolationException){
                    RpcResult result = new RpcResult();
                    result.setValue("校验出错");

                    return result;
                }

                throw new RpcException(t.getMessage(), t);
            }
        }
        return invoker.invoke(invocation);
    }
}

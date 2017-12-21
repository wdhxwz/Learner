package com.wangdh.learner.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangdh.learner.dubbo.api.ValidationService;
import com.wangdh.learner.dubbo.model.ValidationParameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-20
 */
@Service(validation = "true",filter = "validatorFilter")
public class ValidationServiceImpl implements ValidationService {
    @Override
    public String save(@NotNull ValidationParameter parameter) {

        return  "";
    }

    @Override
    public void update(ValidationParameter parameter) {

    }

    @Override
    public void delete(@Min(1) int id) {

    }
}

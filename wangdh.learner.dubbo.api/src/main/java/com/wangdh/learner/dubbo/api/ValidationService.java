package com.wangdh.learner.dubbo.api;

import com.wangdh.learner.dubbo.model.ValidationParameter;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wangdh
 * @Description 缺省可按服务接口区分验证场景，如：@NotNull(groups = ValidationService.class)
 * @date 2017-12-20
 */
public interface ValidationService {
    // 与方法同名接口，首字母大写，用于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选
    // 同时验证Update组规则
    @GroupSequence(Update.class)
    @interface Save{}
    String save(@NotNull ValidationParameter parameter);

    @interface Update{}
    void update(ValidationParameter parameter);

    // 直接对基本类型参数验证
    void delete(@Min(1) int id);
}

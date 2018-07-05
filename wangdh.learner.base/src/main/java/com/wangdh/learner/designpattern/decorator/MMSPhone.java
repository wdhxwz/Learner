package com.wangdh.learner.designpattern.decorator;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/5 19:08
 * @Description:
 */
public class MMSPhone extends CellPhoneDecorator{
    public MMSPhone(CellPhone cellPhone) {
        super(cellPhone);
    }

    @Override
    public String message() {
        return super.message() + ";我这电话是能发彩信的";
    }
}
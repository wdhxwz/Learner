package com.wangdh.learner.designpattern.decorator;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/5 19:01
 * @Description:
 */
public abstract class CellPhoneDecorator implements CellPhone{
    private CellPhone cellPhone;

    public CellPhoneDecorator(CellPhone cellPhone){
        this.cellPhone = cellPhone;
    }

    @Override
    public String call() {
        return cellPhone.call();
    }

    @Override
    public String play() {
        return cellPhone.play();
    }

    @Override
    public String message() {
        return cellPhone.message();
    }
}

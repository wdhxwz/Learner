package com.wangdh.learner.designpattern.decorator;

/**
 * 功能描述:
 * 装饰者模式的应用：
 *      1  典型的：I/O流，很多类，超级多的类看着API看的头昏，I/O流就是可以通过层层地包装进行读取文件，像缓冲流就是将字符流进行了包装等等。
 *
 *       2 想起来以前用GUI做的飞机大战，我方飞机可以有一个炮筒，两个炮筒，升级飞机什么的，这样就可以在飞机类不动的情况下使用装饰者模式进行装饰呀，而且可以层层包装，无限制地升级和降级。
 *
 * 小总结：
 *       1  、被装饰者是最原始的物品，装饰者模式就是用一个一个的装饰器将被装饰者一层一层地包装起来，然后就成了想要的样子。
 *
 *       2、装饰者设计模式设计的原则是：对扩展开放、对修改关闭。这句话在体现在装饰者模式就是对于想要在基础功能上扩展的时候，只需要装饰器继承装饰者的抽象类，实现新的功能或者延展功能就可以对原物品(对象)进行包装扩展，对于修改原类的代码则是关闭的。
 *
 *       3、装饰器本身是没有价值的，必须依赖物品（对象）本身。就像例子中的手机，没有了手机，你空有一个摄像头，怎么让别人视频，没有了手机，你空有一个手机VR控制，怎么让人家玩VR游戏？装饰器离不开最原本的物品本身。
 *
 *       4、不只是一个装饰器整体包装了物品，而是各个装饰器的组合可以让物品变的更强大，不受任何限制，我们可以随意的组合，可以随意的拆分。
 *
 *
 * @auther: dw_wangdonghong
 * @date: 2018/7/5 19:13
 * @param:
 * @return:
 */
public class App {
    public static void main(String[] args){
        // 基本手机
        CellPhone cellPhone = new HWCellPhone();
        System.out.println(cellPhone.call());
        System.out.println(cellPhone.play());
        System.out.println(cellPhone.message());

        // 能视频电话的手机
        cellPhone = new VideoPhone(cellPhone);
        System.out.println(cellPhone.call());
        System.out.println(cellPhone.play());
        System.out.println(cellPhone.message());

        // 能视频电话 + 发彩信的手机
        cellPhone = new MMSPhone(cellPhone);
        System.out.println(cellPhone.call());
        System.out.println(cellPhone.play());
        System.out.println(cellPhone.message());

        // 能视频电话 + 发彩信 + VR玩游戏的手机
        cellPhone = new VRPhone(cellPhone);
        System.out.println(cellPhone.call());
        System.out.println(cellPhone.play());
        System.out.println(cellPhone.message());
    }
}
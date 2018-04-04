package com.wangdh.learner.base.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer测试<br/>
 * mark <= position <= limit <= capacity <br/>
 * mark : 一个备忘位置,mark()设置mark = position;resrt() 设置  position = mark <br/>
 * capacity ： 缓存区的容量,初始化时设置，不能改变<br/>
 * limit : 缓存区第一个不能被读或写的元素位置<br/>
 * position:下一个要别读或写的元素下标
 * Created by Administrator on 2018/4/3.
 */
public class ByteBufferDemo {

    public static void main(String[] args){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H');
        buffer.put((byte) 'E');
        buffer.put((byte) 'L');
        buffer.put((byte) 'L');
        buffer.put((byte) 'O');

        // 每调用一次get或put,position会后移一位
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());


        // 读取之前，将position置于起始位置
        // mark()设置mark = position
        buffer.mark().position(0);

        System.out.println(buffer.get());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());

        System.out.println("OK");
    }
}
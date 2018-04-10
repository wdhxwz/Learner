package com.wangdh.learner.base.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangdh
 * @Description
 * @date 2018-01-31
 */
public class ListDemo {
    public static void main(String[] args){
        // List按添加顺序
        List<String> list = new ArrayList<>(4);
        list.add("a");
        list.add("c");
        list.add("b");
        List<String> subList = list.subList(1,2);
        subList.set(0,"hi");
        list.forEach((str)->{
            System.out.println(str);
        });
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }

        // 将ArrayList变成线程安全
        Collections.synchronizedList(list);

        // 链表
        List<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");

        // 线程安全列表
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("123");
        copyOnWriteArrayList.remove("123");

        // TreeSet按字母顺序
        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("b");
        treeSet.forEach((str)->{
            System.out.println(str);
        });

        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("c");
        hashSet.add("b");
        for(int i=1;i<6;i++){
            System.out.println("第"+i+"次");
            hashSet.forEach((str)->{
                System.out.println(str);
            });
        }

        Collections.sort(list);
        Arrays.asList(123,321);

        // Deque
        // ArrayDeque
        // LinkedList
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put(null,null);

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null,null);


        // value 不能为null
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("key",null);
    }
}

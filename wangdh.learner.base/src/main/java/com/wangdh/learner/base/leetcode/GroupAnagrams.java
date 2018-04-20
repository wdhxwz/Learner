package com.wangdh.learner.base.leetcode;

import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    public static void main(String[] args){
        String[] list = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        // 1.将String[]数组转成map,key为原字符串，value为原字符串的排序字符串
        Map<String,String> map = new HashMap<>(16);
        for (int index = 0;index < list.length; index ++){
            String source = list[index];
            char[] chars = source.toCharArray();
            Arrays.sort(chars);
            map.put(source,new String(chars));
        }

        // 2.倒置转换后的map，将相同value的key形成list
        Map<String,List<String>> resultMap = new HashMap();
        for (Map.Entry<String,String> entry: map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(!resultMap.containsKey(value)){
                resultMap.put(value,new ArrayList<String>());
            }
            resultMap.get(value).add(key);
        }

        // 3.取出结果Map的Value
        List<List<String>> resultList = new ArrayList<>();
        for (List<String> l:resultMap.values()) {
            resultList.add(l);
        }
        resultList.forEach(a -> System.out.println(a));
    }
}
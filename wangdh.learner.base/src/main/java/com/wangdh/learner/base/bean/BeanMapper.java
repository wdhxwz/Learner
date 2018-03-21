package com.wangdh.learner.base.bean;

import com.wangdh.learner.base.Student;
import org.dozer.DozerBeanMapper;

import java.lang.reflect.Field;
import java.util.*;

/**
 *  bean 映射器 <br/>
 *  基于dozer-5.5.1
 * Created by Administrator on 2018/3/21.
 */
public class BeanMapper {
    private BeanMapper(){

    }

    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 构造新的destinationClass实例对象，通过source对象中的字段内容
     * 映射到destinationClass实例对象中，并返回新的destinationClass实例对象。
     *
     * @param source 源数据对象
     * @param destinationClass 要构造新的实例对象Class
     */
    public static <T> T map(Object source, Class<T> destinationClass)
    {
        return dozer.map(source, destinationClass);
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass)
    {
        List destinationList = new ArrayList();
        for (Iterator i = sourceList.iterator(); i.hasNext(); ) {
            Object sourceObject = i.next();
            Object destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }

        return destinationList;
    }

    /**
     * 将对象source的所有属性值拷贝到对象destination中.
     *
     * @param source 对象source
     * @param destinationObject 对象destination
     */
    public static void copy(Object source, Object destinationObject)
    {
        dozer.map(source, destinationObject);
    }

    public static <T> Map<String, T> toMap(Object target) {
        return toMap(target,false);
    }

    /**
     * 将目标对象的所有属性转换成Map对象
     *
     * @param target 目标对象
     * @param ignoreParent 是否忽略父类的属性
     *
     * @return Map
     */
    public static <T> Map<String, T> toMap(Object target,boolean ignoreParent) {
        return toMap(target,ignoreParent,false);
    }

    /**
     * 将目标对象的所有属性转换成Map对象
     *
     * @param target 目标对象
     * @param ignoreParent 是否忽略父类的属性
     * @param ignoreEmptyValue 是否不把空值添加到Map中
     *
     * @return Map
     */
    public static <T> Map<String, T> toMap(Object target,boolean ignoreParent,boolean ignoreEmptyValue) {
        return toMap(target,ignoreParent,ignoreEmptyValue,new String[0]);
    }

    /**
     * 将目标对象的所有属性转换成Map对象
     *
     * @param target 目标对象
     * @param ignoreParent 是否忽略父类的属性
     * @param ignoreEmptyValue 是否不把空值添加到Map中
     * @param ignoreProperties 不需要添加到Map的属性名
     */
    public static <T> Map<String, T> toMap(Object target,boolean ignoreParent,boolean ignoreEmptyValue,String... ignoreProperties) {
        Map<String, T> map = new HashMap<String, T>();
        List<Field> fields = Arrays.asList(target.getClass().getDeclaredFields());

        for (Iterator<Field> it = fields.iterator(); it.hasNext();) {
            Field field = it.next();
            field.setAccessible(true);

            T value = null;
            try {
                value = (T) field.get(target);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (ignoreEmptyValue
                    && ((value == null || value.toString().equals(""))
                    || (value instanceof Collection && ((Collection<?>) value).isEmpty())
                    || (value instanceof Map && ((Map<?,?>)value).isEmpty()))) {
                continue;
            }

            boolean flag = true;
            String key = field.getName();

            for (String ignoreProperty:ignoreProperties) {
                if (key.equals(ignoreProperty)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                map.put(key, value);
            }
        }

        return map;
    }

    public static void main(String[] args){
        Student student = new Student();
        student.setAge(22);
        student.setName("cxx");

        Map map = BeanMapper.toMap(student);

        System.out.println(map);

        map = BeanMapper.map(student,Map.class);
        System.out.println(map);

        Student student2 = BeanMapper.map(map,Student.class);
        System.out.println(student2);
    }
}
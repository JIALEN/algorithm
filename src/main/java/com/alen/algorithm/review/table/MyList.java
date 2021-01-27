package com.alen.algorithm.review.table;

/**
 * @author lijialun
 * @Desc
 * @create 2020-12-27 13:00
 **/
public interface MyList {
    // 求容量
    int size();

    // 是否为空
    boolean isEmpty();

    // 判断是否存在
    boolean contains(Object o);

    // 清空集合
    void clear();

    // 返回添加是否成功
    boolean add(Object object);

    // 返回删除是否成功
    boolean remove(int index);

    // 获取索引位置的值
    Object get(int index);

}

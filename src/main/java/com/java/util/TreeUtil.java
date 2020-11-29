package com.java.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
public class TreeUtil {
    /**
     * 菜单层级关系
     * @param treeList
     * @param pid
     * @return
     */

    public static List<MenuNode> toTree(List<MenuNode> treeList, int pid) {
        List<MenuNode> retList = new ArrayList<MenuNode>();
        for (MenuNode parent : treeList) {
            if (pid==parent.getPid()) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }
    private static MenuNode findChildren(MenuNode parent, List<MenuNode> treeList) {
        for (MenuNode child : treeList) {
            if (parent.getId()==(child.getPid())) {
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<MenuNode>());
                }
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}
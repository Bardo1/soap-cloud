package org.wzx.cloud.util;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
//    public static TreeNode toMovieListTree(List<T> list) {
//        List<TreeNode> res = new ArrayList<>();
//        XMovieFileDO root = null;
//        TreeNode rootNode = new TreeNode();
//        for (int i = 0; i < list.size(); i++) {
////        for(XMovieFileDO tmp:list){
//            XMovieFileDO tmp = list.get(i);
//            if ("/".equals(tmp.getUrl()) && "/".equals(tmp.getName())) {
//                root = tmp;
//                list.remove(tmp);
//                rootNode.setLabel(tmp.getName());
//                rootNode.setChildren(new ArrayList<TreeNode>());
//                rootNode.setObj(root);
//                break;
//            }
//        }
//        rootNode = toTree(rootNode, list, root);
//        return rootNode;
//    }
//
//    private static TreeNode toTree(TreeNode parentnode, List<XMovieFileDO> reslist, XMovieFileDO parent) {
//        for (int i = 0; i < reslist.size(); i++) {
////        for(XMovieFileDO tmp:list){
//            XMovieFileDO tmp = reslist.get(i);
//            if (tmp.getParentid().equals(parent.getId())) {
//                TreeNode leaf = new TreeNode();
//                leaf.setLabel(tmp.getName());
//                leaf.setObj(tmp);
//                leaf.setChildren(new ArrayList<>());
//                List<TreeNode> children = parentnode.getChildren();
//                children.add(leaf);
//                parentnode.setChildren(children);
//                reslist.remove(tmp);
//                leaf = toTree(leaf, reslist, tmp);
//                i = -1;
//            }
//        }
//        return parentnode;
//    }
}

package com.atguigu.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    //    @Autowired
//    CategoryDao categoryDao; 其实就是baseMapper
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构
        ////2。1 找到所有的一级分类
        List<CategoryEntity> level1 = entities.stream().filter(entity -> entity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                }).sorted((a, b) -> a.getSort() - b.getSort()).collect(Collectors.toList());

        return level1;
    }

    /**
     * 查找所有菜单的子菜单，根据数据库中的结构将会形成三级树形树形结构
     **/
//    private List<CategoryEntity> getChildren1(CategoryEntity father, List<CategoryEntity> entities) {
//        //for循环写法 ，错了 没能形成三级树形结构
////        List<CategoryEntity> children = new ArrayList<>();
////        for (CategoryEntity x : entities) {
////            if (Objects.equals(x.getParentCid(), father.getCatId())) children.add(x);
////        }
////        return children;
//
//        //流 + 递归写法
//        List<CategoryEntity> collect = entities.stream().filter(x -> {
//            return Objects.equals(x.getParentCid(), father.getCatId());
//        }).map(entity -> {
//            entity.setChildren(getChildren1(entity, entities));
//            return entity;
//        }).sorted((a, b) -> {
//            return (a.getSort() == null) ? 0 : a.getSort() - (b.getSort() == null ? 0 : b.getSort());
//        }).collect(Collectors.toList());
//        return collect;
//    }

    //普通递归写法
    private List<CategoryEntity> getChildren(CategoryEntity father, List<CategoryEntity> all) {
        List<CategoryEntity> children = new ArrayList<CategoryEntity>();
        for (CategoryEntity x : all) {
            if (Objects.equals(x.getParentCid(), father.getCatId())) children.add(x);
        }
        for (CategoryEntity child : children)
            child.setChildren(getChildren(child, all));
        children.sort((a, b) -> (a.getSort() == null ? 0 : a.getSort()) - (b.getSort() == null ? 0 : b.getSort()));
        return children;
    }
}
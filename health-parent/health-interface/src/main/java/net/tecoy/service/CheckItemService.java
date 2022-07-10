/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/3 23:22
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;


import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.pojo.CheckItem;

import java.util.List;

/**
 * 检查项管理
 * @author Tecoy
 */
public interface CheckItemService {
    /**
     * 新增
     * @param checkItem
     * @return
     */
    boolean add(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 通过id删除数据项
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 编辑检查项
     * @param checkItem
     * @return
     */
    boolean edit(CheckItem checkItem);

    /**
     * 通过id查询检查项数据
     * @param id
     * @return
     */
    CheckItem queryById(Integer id);

    /**
     * 查询所有检查项
     * @return
     */
    List<CheckItem> queryAll();
}

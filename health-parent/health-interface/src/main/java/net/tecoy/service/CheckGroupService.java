/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/4 17:12
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.pojo.CheckGroup;

import java.util.List;

/**
 * 检查组管理
 * @author Tecoy
 */
public interface CheckGroupService {

    /**
     * 新增检查组
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    boolean add(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    CheckGroup queryById(Integer id);

    /**
     * 查询关联的检查服务id
     * @param id
     * @return
     */
    List<Integer> queryCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 编辑检查组
     * @param checkGroup
     * @param ids
     * @return
     */
    boolean edit(CheckGroup checkGroup, Integer[] ids);

    /**
     * 删除检查组
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 查询所有检查组
     * @return
     */
    List<CheckGroup> queryAll();
}

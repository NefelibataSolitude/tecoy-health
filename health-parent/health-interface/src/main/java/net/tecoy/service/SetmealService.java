/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/6 18:45
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * 套餐管理
 * @author Tecoy
 */
public interface SetmealService {
    /**
     * 添加套餐
     * @param setmeal
     * @param ids
     * @return
     */
    boolean add(Setmeal setmeal, Integer[] ids);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 查询关联关系
     * @param id
     * @return
     */
    List<Integer> selectAssociation(Integer id);

    /**
     * id查询
     * @param id
     * @return
     */
    Setmeal selectById(Integer id);

    /**
     * 套餐编辑
     * @param setmeal
     * @param ids
     * @return
     */
    boolean edit(Setmeal setmeal, Integer[] ids);

    /**
     * 删除套餐
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有套餐信息
     * @return
     */
    List<Setmeal> selectAll();

    /**
     * 套餐数据统计
     * @return
     */
    List<Map<String, Object>> selectCount();


}

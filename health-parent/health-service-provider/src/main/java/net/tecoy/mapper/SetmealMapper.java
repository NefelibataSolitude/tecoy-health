/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/6 20:08
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import com.github.pagehelper.Page;
import net.tecoy.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Tecoy
 */
public interface SetmealMapper {
    /**
     * 添加套餐
     * @param setmeal
     * @return
     */
    int add(Setmeal setmeal);

    /**
     * 新增关联关系
     * @param map
     * @return
     */
    int addAssociation(Map<String, Integer> map);

    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<Setmeal> selectByCondition(String queryString);

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
     * @return
     */
    int edit(Setmeal setmeal);

    /**
     * 删除关联关系
     * @param setmealId
     * @return
     */
    int deleteAssociation(Integer setmealId);

    /**
     * 删除套餐
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询所有套餐
     * @return
     */
    List<Setmeal> selectAll();

    /**
     * 套餐统计
     * @return
     */
    List<Map<String, Object>> selectCount();

}

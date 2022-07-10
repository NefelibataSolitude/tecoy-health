/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 14:08
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.entity.Result;
import net.tecoy.pojo.Order;

import java.util.Map;

/**
 * 体检预约
 * @author Tecoy
 */
public interface OrderService {

    /**
     * 体检预约
     * @param map
     * @return
     * @throws Exception
     */
    Result add(Map<String, String> map) throws Exception;

    /**
     * 通过Id查询体检预约信息
     * @param id
     * @return
     */
    Map<String, Object> selectById(Integer id) throws Exception;
}

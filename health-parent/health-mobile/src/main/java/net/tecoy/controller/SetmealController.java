/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/8 19:43
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.pojo.Setmeal;
import net.tecoy.service.SetmealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;

    /**
     * 查询所有套餐
     * @return
     */
    @RequestMapping("getAllSetmeal")
    public Result getAllSetmeal() {
        try {
            List<Setmeal> setmeals = setmealService.selectAll();
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeals);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }

    /**
     * 根据id查询套餐详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        try {
            Setmeal setmeal = setmealService.selectById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }
}

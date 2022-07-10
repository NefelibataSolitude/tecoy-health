/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/3 23:19
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.entity.Result;
import net.tecoy.pojo.CheckItem;
import net.tecoy.service.CheckItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 检查项管理
 *
 * @author Tecoy
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    /**
     * 新增检查项
     *
     * @param checkItem
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            // 服务调用失败
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return checkItemService.pageQuery(queryPageBean);
    }

    /**
     * 删除检查项
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('CHECKITEM_DELETE')")
    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            return checkItemService.deleteById(id) ? new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS) : new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
    }

    /**
     * 编辑检查项
     * @param checkItem
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem) {
        boolean flag = false;
        try {
            flag = checkItemService.edit(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.EDIT_CHECKITEM_SUCCESS : MessageConstant.EDIT_CHECKITEM_FAIL);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            CheckItem checkItem = checkItemService.queryById(id);
            return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    /**
     * 查询所有检查项数据
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<CheckItem> checkItemList = checkItemService.queryAll();
            return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItemList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }
}

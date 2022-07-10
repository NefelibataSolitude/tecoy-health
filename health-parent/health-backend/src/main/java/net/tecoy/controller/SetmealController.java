/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/5 20:10
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.constant.RedisConstant;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.entity.Result;
import net.tecoy.pojo.Setmeal;
import net.tecoy.service.SetmealService;
import net.tecoy.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 体检套餐
 * @author Tecoy
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;
    private final JedisPool jedisPool;

    public SetmealController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 图片上传七牛云
     * @param imgFile
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) {
        // 获取图片后缀
        String originalFilename = imgFile.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index - 1);
        String fileName = UUID.randomUUID() + suffix;
        String downloadUrl;
        try {
            QiniuUtils.uploadQiniu(imgFile.getBytes(), fileName);
            // 向redis集合中添加图片名称
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
    }


    /**
     * 新增套餐
     * @param setmeal
     * @param checkgroupIds
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds) {
        boolean flag = false;
        try {
            flag = setmealService.add(setmeal, checkgroupIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.ADD_SETMEAL_SUCCESS : MessageConstant.ADD_SETMEAL_FAIL);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult page(@RequestBody QueryPageBean queryPageBean) {
        return setmealService.pageQuery(queryPageBean);
    }


    /**
     * 查询关联数据
     * @param id
     * @return
     */
    @RequestMapping("/findCheckgroupIdsBySetmealId")
    public Result findCheckgroupIdsBySetmealId(Integer id) {
        try {
            List<Integer> list = setmealService.selectAssociation(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }

    }

    /**
     * id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Setmeal setmeal = setmealService.selectById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }

    /**
     * 套餐编辑
     * @param setmeal
     * @param checkgroupIds
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody Setmeal setmeal, Integer[] checkgroupIds) {
        boolean flag = false;
        try {
            flag = setmealService.edit(setmeal, checkgroupIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.EDIT_SETMEAL_SUCCESS : MessageConstant.EDIT_SETMEAL_FAIL);
    }

    /**
     * 删除套餐
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Integer id) {
        boolean flag = false;
        try {
            flag = setmealService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.DELETE_SETMEAL_SUCCESS : MessageConstant.DELETE_SETMEAL_FAIL);
    }

}

/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 18:20
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service;

import net.tecoy.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 会员管理
 * @author Tecoy
 */
public interface MemberService {

    /**
     * 通过手机号查询
     * @param telephone
     * @return
     */
    Member selectByTelephone(String telephone);

    /**
     * 添加会员
     * @param member
     * @return
     */
    boolean add(Member member);

    /**
     * 通过月份统计会员数量
     * @param months
     * @return
     */
    List<Integer> countMemberByMonth(List<String> months);

}

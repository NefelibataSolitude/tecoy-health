/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 18:22
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import net.tecoy.mapper.MemberMapper;
import net.tecoy.pojo.Member;
import net.tecoy.service.MemberService;
import net.tecoy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member selectByTelephone(String telephone) {
        return memberMapper.selectByTelephone(telephone);
    }

    @Override
    public boolean add(Member member) {
        String password = member.getPassword();
        if (password != null) {
            password = MD5Utils.md5(password);
            member.setPassword(password);
        }
        return memberMapper.add(member) > 0;
    }

    @Override
    public List<Integer> countMemberByMonth(List<String> months) {
        List<Integer> list = new ArrayList<>();
        for (String month : months) {
            int count = memberMapper.countMemberByDate(null, month + "-31");
            list.add(count);
        }
        return list;
    }
}

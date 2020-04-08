package ink.icopy.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import ink.icopy.base.entity.User;
import ink.icopy.base.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhengguang
 */
@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> queryUserList() {
        QueryWrapper<User> or = Wrappers.<User>query().eq("id", 3).or(q -> q.eq("name", "Sandy"));
        List<User> users = userMapper.selectList(or);
        users.forEach(u -> log.info(u.toString()));
        return users;
    }
}

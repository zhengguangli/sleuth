package ink.icopy.base.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.icopy.base.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lizhengguang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

package ink.icopy.base.service.iml;

import ink.icopy.base.service.IAccountService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lizhengguang
 */
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void increaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update(
                "update tb_account set frozen = frozen + ? where acct_id = ?", amount, accountId);
    }
}

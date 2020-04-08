package ink.icopy.base.service.iml;

import ink.icopy.base.service.IAccountService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lizhengguang
 */
public class AccountServiceConfirmImpl implements IAccountService {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void increaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update(
                "update tb_account set amount = amount + ?, frozen = frozen - ? where acct_id = ?",
                amount,
                amount,
                accountId);
    }
}

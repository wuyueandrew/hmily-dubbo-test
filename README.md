# hmily-dubbo-test

-- sql初始化
CREATE TABLE xx_hmily_account (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    user_name varchar(50) NOT NULL COMMENT '用户名',
    balance BIGINT NOT NULL DEFAULT 0 COMMENT '余额',
    freeze BIGINT NOT NULL DEFAULT 0 COMMENT '冻结余额',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分布式事务账户表';

INSERT INTO xx_hmily_account VALUES (1, '用户1', 10000, 0), (2, '用户2', 10000, 0);

try confirm cancel 的事务通过MySQL本地事务完成
幂等性可以通过增加个reqId实现

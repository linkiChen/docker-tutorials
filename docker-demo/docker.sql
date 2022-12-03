-- 部门表
CREATE TABLE demo_dept(
    id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    dept_name VARCHAR(32) NOT NULL COMMENT '部门名称',
    dept_code VARCHAR(20) NOT NULL COMMENT '部门编号',
    PRIMARY KEY (id)
);

-- 员工表
CREATE TABLE demo_employees(
    id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    dept_id INT(11) NOT NULL COMMENT '所属部门ID',
    name VARCHAR(32) COMMENT '员工名称',
    age INT(4) COMMENT '年龄',
    gender int(4) COMMENT '性别 0-女,1-男',
    PRIMARY KEY (id)
);
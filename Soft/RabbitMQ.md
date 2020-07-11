# RabbitMQ

1.安装erlang

2.安装rabbitmq

3.rabbitmq相关命令

| 命令                                                    | 描述                          |
| ------------------------------------------------------- | ----------------------------- |
| systemctl start rabbitmq-server.service                 | 启动服务                      |
| systemctl stop rabbitmq-server.service                  | 关闭服务                      |
| systemctl status rabbitmq-server.service                | 查看服务状态                  |
| rabbitmq-plugins enable rabbitmq_management             | 开启管理界面插件              |
| rabbitmqctl add_user Username Password                  | 添加用户                      |
| rabbitmqctl set_permissions -p "/" admin '.*' '.*' '.*' | 赋予用户权限                  |
| rabbitmqctl set_user_tags admin administrator           | 赋予用户角色                  |
| rabbitmqctl delete_user Username                        | 删除用户                      |
| rabbitmqctl change_password Username Newpassword        | 修改用户密码                  |
| rabbitmqctl list_users                                  | 查看用户列表                  |
| rabbitmqctl add_vhost NewVirtualHostName                | 新建一个Virtual Host          |
| rabbitmqctl list_vhosts                                 | 查看系统当前有几个Virtual Hos |






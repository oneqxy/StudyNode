# Windows使用时的一些小问题

## **1.当一个文件层级太深删不掉怎么办**

1.在删不掉的文件下面创建一个新文件夹

2.在当前文件夹下执行命令robocopy 新建文件名 删不掉文件名 /purge



## 2.如何将启动盘还原成普通U盘

1.在cmd中输入diskpart

2.在cmd中输入list disk 查看磁盘索引

3.在cmd中输入select disk 1	选择磁盘索引

4.在cmd中输入clean 清空磁盘
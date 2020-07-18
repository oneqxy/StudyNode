package com.qin.myspringboot.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 
 * </p>
 *
 * @author qxy
 * @since 2020-07-17
 */
@Data
@Alias("permission")
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
@ApiModel(value="Permission对象", description="")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识，递增")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "资源类型,[menu|button]")
    @TableField("resource_type")
    private String resourceType;

    @ApiModelProperty(value = "资源路径")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view")
    @TableField("permission")
    private String permission;

    @ApiModelProperty(value = "父编号")
    @TableField("parentid")
    private Integer parentid;

    @ApiModelProperty(value = "父编号列表")
    @TableField("parentids")
    private String parentids;

    @ApiModelProperty(value = "是否可用 0不可用 1可用")
    @TableField("available")
    private Boolean available;


}

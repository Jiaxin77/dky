package hci.dky.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * borg_scale
 * @author 
 */
@Data
public class BorgScale implements Serializable {
    /**
     * borg量表id
     */
    private Long id;

    /**
     * 所属方案id
     */
    private Long planId;

    /**
     * 系统名称

     */
    private String systemname;

    private static final long serialVersionUID = 1L;
}
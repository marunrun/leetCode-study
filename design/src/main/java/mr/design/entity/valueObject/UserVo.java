package mr.design.entity.valueObject;

import lombok.Data;

@Data
public class UserVo {
    String telephone;
    String password;

    public UserVo(String telephone, String password) {
        this.telephone = telephone;
        this.password = password;
    }
}

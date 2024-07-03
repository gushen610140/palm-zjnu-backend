package icu.sunway.palmzjnubackend.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {
    private String openid;
    private String sessionKey;
}

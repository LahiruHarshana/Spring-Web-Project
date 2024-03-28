package lk.ijse.spring.service.util;

import java.util.UUID;

/**
 * @author : L.H.J
 * @File: UtilMatter
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-28, Thursday
 **/
public class UtilMatter {
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}

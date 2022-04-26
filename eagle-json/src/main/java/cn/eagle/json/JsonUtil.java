package cn.eagle.json;

import cn.eagle.json.jackson.JacksonUtil;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.util.List;
@UtilityClass
public class JsonUtil {
    
    @SneakyThrows
    public String toJsonString(Object object) {
        return JacksonUtil.toJsonString(object);
    }
    
    @SneakyThrows
    public byte[] toJsonByte(Object object) {
        return JacksonUtil.toJsonByte(object);
    }
    
    
    public <T> T parseObject(String text, Class<T> clazz) {
        return JacksonUtil.parseObject(text, clazz);
    }
    
    public <T> T parseObject(byte[] bytes, Class<T> clazz) {
        return JacksonUtil.parseObject(bytes, clazz);
    }
    
    public <T> List<T> parseArray(String text, Class<T> clazz) {
        return JacksonUtil.parseArray(text, clazz);
    }
}

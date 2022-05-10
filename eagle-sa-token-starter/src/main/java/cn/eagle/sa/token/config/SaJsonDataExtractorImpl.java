package cn.eagle.sa.token.config;

import cn.canary.core.AbstractJsonDataExtractor;
import cn.canary.core.dto.response.MultiResponse;
import cn.canary.core.dto.response.PageResponse;
import cn.canary.core.dto.response.SingleResponse;
import cn.dev33.satoken.util.SaResult;
import org.springframework.stereotype.Component;

/**
 * 将Sa-Token的响应实体转换为canary的，以便统一标准
 *
 * @author yaojx
 */
@Component
public class SaJsonDataExtractorImpl extends AbstractJsonDataExtractor {
    
    
    @Override
    public SingleResponse toSingle(Object source) {
        SingleResponse singleResponse = new SingleResponse();
        if (source instanceof SaResult) {
            SaResult saResult = (SaResult) source;
            Integer code = saResult.getCode();
            singleResponse.setSuccess(code.equals(200));
            singleResponse.setCode(code.toString());
            singleResponse.setResult(saResult.getData());
        }
        return singleResponse;
    }
    
    @Override
    public MultiResponse toMulti(Object source) {
        return null;
    }
    
    @Override
    public PageResponse toPage(Object sasourceResult) {
        return null;
    }
}

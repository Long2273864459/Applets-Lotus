package cc.mrbird.febs.common.service;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.ImageType;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.properties.FebsProperties;
import cc.mrbird.febs.common.properties.ValidateCodeProperties;
import cc.mrbird.febs.common.utils.HttpContextUtil;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 验证码服务，
 * 如果febs.enable-redis-cache=true，则存redis，否则存session
 *
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
public class ValidateCodeService {

    private final FebsProperties properties;
    private RedisService redisService;
    @Value("${" + FebsProperties.ENABLE_REDIS_CACHE + "}")
    private boolean enableRedisCache;

    @Autowired(required = false)
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    private Captcha createCaptcha(ValidateCodeProperties code) {
        Captcha captcha;
        if (StringUtils.equalsIgnoreCase(code.getType(), ImageType.GIF)) {
            captcha = new GifCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        } else {
            captcha = new SpecCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        }
        captcha.setCharType(code.getCharType());
        return captcha;
    }

    private void setHeader(HttpServletResponse response, String type) {
        if (StringUtils.equalsIgnoreCase(type, ImageType.GIF)) {
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        } else {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
    }
}

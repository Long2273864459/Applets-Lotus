package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.ICourseIntentionService;
import cc.mrbird.febs.system.service.IExcellentCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExcellentCourseServiceImpl extends ServiceImpl<UserMapper, User> implements IExcellentCourseService {

}

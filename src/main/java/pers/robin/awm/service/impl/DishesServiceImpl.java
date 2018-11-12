package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.DishesMapper;
import pers.robin.awm.exception.CheckException;
import pers.robin.awm.model.Dishes;
import pers.robin.awm.service.DishesService;
import pers.robin.awm.util.UploadUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DishesServiceImpl implements DishesService {

    @Autowired
    private DishesMapper dishesMapper;

    @Override
    public List<Dishes> findByCondition(Map<String, Object> map, int pageId) {
        PageHelper.startPage(pageId, PageConfig.size);
        return dishesMapper.selectByCondition(map);
    }

    @Override
    public Dishes findById(Integer id) {
        return dishesMapper.selectByPrimaryKey(id);
    }

    private void check(Dishes dishes) {
        if (dishes.getName() == null) {
            throw new CheckException("dishes name can not be null");
        } else if (dishes.getProvider() == null) {
            throw new CheckException("provider can not be null");
        } else if (dishes.getPrice() == null) {
            throw new CheckException("price can not be null");
        } else if (dishes.getStatus() == null) {
            throw new CheckException("status can not be null");
        }
    }

    @Override
    public int create(Dishes dishes) {
        check(dishes);
        dishesMapper.insertSelective(dishes);
        return dishes.getId();
    }

    @Override
    public int updateById(Dishes dishes) {
        return dishesMapper.updateByPrimaryKeySelective(dishes);
    }

    @Override
    public int deleteById(Integer id) {
        return dishesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Dishes> getDishesByProvider(Integer providerId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("provider", providerId);
        return dishesMapper.selectByCondition(map);
    }

    @Override
    @Transactional
    public String updateImg(Dishes dishes, MultipartFile img, String basePath) {
        if (dishes == null) {
            throw new CheckException("dishes id is not exists");
        }
        String path = basePath + UploadUtil.uploadImage(img);
        dishes.setImg(path);
        updateById(dishes);
        return path;
    }
}

package pers.robin.awm.service;

import org.springframework.web.multipart.MultipartFile;
import pers.robin.awm.model.Dishes;
import pers.robin.awm.model.Shop;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DishesService {

    List<Dishes> findByCondition(Map<String, Object> map, int pageId);

    Dishes findById(Integer id);

    int create(Dishes dishes);

    int updateById(Dishes dishes);

    int deleteById(Integer id);

    List<Dishes> getDishesByProvider(Integer providerId);

    String updateImg(Dishes dishes, MultipartFile img, String basePath);
}

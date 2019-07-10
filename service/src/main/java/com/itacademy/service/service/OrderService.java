package com.itacademy.service.service;

import com.itacademy.database.dao.OrderDao;
import com.itacademy.database.entity.OrderEntity;
import com.itacademy.database.entity.UserEntity;
import com.itacademy.database.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private static final OrderService INSTANCE = new OrderService();
    private final OrderDao orderDao = OrderDao.getInstance();

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public static OrderService getInstance() {
        return INSTANCE;
    }

    public Optional<OrderEntity> getById(Long id) {
        Optional<OrderEntity> getid = orderDao.getId(id);
        return getid;
    }

    public List<OrderEntity> getAll(Integer pageNumber, Integer pageCount) {
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageCount);
        List<OrderEntity> all = orderRepository.getAll(pageRequest);
        return all;
    }

    public List<OrderEntity> getUserOrders(Integer pageNumber, Integer pageCount) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageCount);
        List<OrderEntity> list = orderRepository.getUserList(pageRequest, userEntity.getId());
        return list;
    }

}

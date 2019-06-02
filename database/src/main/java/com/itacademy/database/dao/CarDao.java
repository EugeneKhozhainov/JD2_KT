package com.itacademy.database.dao;

import com.itacademy.database.dao.util.SessionManager;
import com.itacademy.database.entity.*;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static com.itacademy.database.dao.util.SessionManager.getSession;

public class CarDao extends BaseDaoImpl<Long, CarEntity> {

    private static final CarDao INSTANCE = new CarDao();

    public static CarDao getInstance() {
        return INSTANCE;
    }

    public CarEntity getDefaultCar() {
        return CarEntity.builder()
                .brand("BMW")
                .model("X5")
                .price(5555.0)
                .status(String.valueOf(CarStatus.DAMAGED))
                .build();

    }

    public List<CarEntity> getEntriesWithFilter(Session session, String brand, String model, Double price, Integer pageNumber, Integer pageCount) {
        Query<CarEntity> query = session
                .createQuery(
                        "select e from CarEntity e where e.brand = :brand and e.model = :model and e.price > :price order by e.price ", CarEntity.class)
                .setParameter("brand", brand)
                .setParameter("model", model)
                .setParameter("price", price);

        query.setFirstResult((pageNumber - 1) * pageCount);
        query.setMaxResults(pageCount);
        List<CarEntity> carEntities = query.list();
        return carEntities;
    }

    public List<CarEntity> getEntriesWithFilter(String brand, String model, Double price, Integer pageNumber, Integer pageCount) {
        @Cleanup Session session = getSession();
        try {
            return getEntriesWithFilter(session, brand, model, price, pageNumber, pageCount);
        } finally {
            session.close();
        }
    }

}

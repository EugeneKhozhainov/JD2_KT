package com.itacademy.test;

import com.itacademy.database.dao.CarDao;
import com.itacademy.database.entity.CarEntity;
import com.itacademy.database.entity.CarStatus;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import javax.smartcardio.Card;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EntriesWithFilterTest {
    public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public final CarDao carDao = CarDao.getInstance();

    @Test
    public void checkEntriesWithFilter(){
        @Cleanup Session session = factory.openSession();
        CarEntity car = CarEntity.builder()
                .brand("Ford")
                .model("Focus")
                .price(100.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();
        CarEntity car2 = CarEntity.builder()
                .brand("Ford")
                .model("Focus")
                .price(120.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();
        CarEntity car3 = CarEntity.builder()
                .brand("Ford")
                .model("Focus")
                .price(100.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();
        CarEntity car4 = CarEntity.builder()
                .brand("Ford")
                .model("Focus")
                .price(130.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();
        CarEntity car5 = CarEntity.builder()
                .brand("Ford")
                .model("Focus")
                .price(100.0)
                .status(String.valueOf(CarStatus.WORKING))
                .build();

        session.save(car);
        session.save(car2);
        session.save(car3);
        session.save(car4);
        session.save(car5);

        List<CarEntity> carList = CarDao.getInstance().getEntriesWithFilter(session,"Ford", "Focus", 50.0, 1, 5);
        assertEquals(carList.size(), 5);
        session.close();
    }
}

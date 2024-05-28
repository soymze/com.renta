package com.renta.renta.dataAccess;

import com.renta.renta.entities.Booking;
import com.renta.renta.entities.Car;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class CarSpecifications {

    public static Specification<Car> hasBrand(String brand) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("brand"), brand);
    }

    public static Specification<Car> hasType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<Car> hasYear(int year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
    }


    public static Specification<Car> hasFuel(String fuel) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("fuel"), fuel);
    }

    public static Specification<Car> hasNotBooked(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {
            Subquery<Booking> subQuery = query.subquery(Booking.class);
            Root<Booking> subQueryRoot = subQuery.from(Booking.class);
            subQuery.select(subQueryRoot);

            subQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root, subQueryRoot.get("car")),
                    criteriaBuilder.between(subQueryRoot.get("bookDate"), startDate, endDate)
            ));

            return criteriaBuilder.not(criteriaBuilder.exists(subQuery));
        };
    }

    public static Specification<Car> byId(Long carId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), carId);
    }
}

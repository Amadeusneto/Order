package br.com.amadeus.order.repository;

import br.com.amadeus.order.dto.request.FilterOrderRequest;
import br.com.amadeus.order.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderSpecification {
    public Specification<Order> getOrderByFilter(FilterOrderRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates = preparePredicateLike("orderCode", request.getOrderCode(), criteriaBuilder, root, predicates);
            predicates = preparePredicateLike("registrationDate", request.getRegistrationDate(), criteriaBuilder, root, predicates);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static List<Predicate> preparePredicateLike(String fieldName, String fieldValue,
                                                       CriteriaBuilder criteriaBuilder, Root<Order> root,
                                                       List<Predicate> predicates) {
        if (!Objects.isNull(fieldValue) && !fieldValue.isEmpty()) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(fieldName)), "%" + fieldValue + "%"));
        }
        return predicates;
    }
}

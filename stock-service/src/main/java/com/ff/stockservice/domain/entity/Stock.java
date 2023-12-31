package com.ff.stockservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Table(schema = "stock", name = "t_stock")
@Entity
@ToString
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "description")
  private String description;

  @Column(name = "available_amount")
  private Integer availableAmount;

  @Column(name = "price")
  private Double price;

  @Column(name = "cost")
  private Double cost;

  @Column(name = "is_active", columnDefinition = "boolean default false")
  private Boolean isActive;

}

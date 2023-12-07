package com.ff.orderservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(schema = "\"order\"", name = "t_order_item")
@Entity
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @Column(name = "stock_id")
  private Long stockId;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "price")
  private Double price;

  @Column(name = "purchased_quantity")
  private Integer purchasedQuantity;

  @Column(name = "product_image_url")
  private String productImageUrl;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "product_description")
  private String productDescription;
}
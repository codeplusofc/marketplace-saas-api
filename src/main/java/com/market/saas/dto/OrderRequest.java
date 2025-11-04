package com.market.saas.dto;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private List<ItemRequest> items;

    public OrderRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    //TODO: REMOVER ESSA CLASSE ABAIXO E MIGRAR PARA UMA NOVA CLASSE
    public static class ItemRequest {
        private Long productId;
        private int quantity;

        public ItemRequest() {
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
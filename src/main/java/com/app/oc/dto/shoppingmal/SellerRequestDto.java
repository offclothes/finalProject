package com.app.oc.dto.shoppingmal;

import com.app.oc.entity.Address;
import com.app.oc.entity.ShoppingMal;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 입점 신청 api 사용 시 요청 데이터
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRequestDto {

    private String memberId;
    @NotNull
    private String shopName;
    @NotNull
    private Address address;
    @NotNull
    private String email;
    @NotNull
    private String shopTel;

    public ShoppingMal toShoppingmal() {
        return ShoppingMal.builder()
                .shopName(shopName)
                .address(address)
                .email(email)
                .shopTel(shopTel)
                .build();
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
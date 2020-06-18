package com.ujjaval.ecommerce.commondataservice.entity.sql.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ujjaval.ecommerce.commondataservice.entity.sql.info.ProductInfo;
import com.ujjaval.ecommerce.commondataservice.entity.sql.images.ClothesTypeImages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class GenderCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String gender;

    @OneToMany(mappedBy = "genderCategory")
    @JsonIgnore
    private List<ProductInfo> productInfos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "genderCategory")
    @JsonIgnore
    private List<ClothesTypeImages> clothesTypeImages;

    public GenderCategory(String gender) {
        this.gender = gender;
    }
}
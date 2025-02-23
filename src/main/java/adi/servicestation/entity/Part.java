package adi.servicestation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "parts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    private String partNumber;
    private Integer quantity;
    private BigDecimal price;
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_id")
    private Repair repair;
}

//    public boolean isPartAvailable(Long partId, int requiredQuantity) {
//        Part part = partRepository.findById(partId)
//                .orElseThrow(() -> new RuntimeException("Запчасть не найдена!"));
//        return part.getQuantity() >= requiredQuantity;
//    }


//    public void deductPart(Long partId, int usedQuantity) {
//        Part part = partRepository.findById(partId)
//                .orElseThrow(() -> new RuntimeException("Запчасть не найдена!"));
//
//        if (part.getQuantity() >= usedQuantity) {
//            part.setQuantity(part.getQuantity() - usedQuantity);
//            partRepository.save(part);
//        } else {
//            throw new RuntimeException("Недостаточно запчастей на складе!");
//        }
//    }

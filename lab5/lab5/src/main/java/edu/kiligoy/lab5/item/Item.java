package edu.kiligoy.lab5.item;

/*
@author   Dtest
@project   lab5
@class  Item
@version  1.0.0
@since 08.04.2025 - 13.11
*/
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Item extends AuditMetaData {

    @Id
    private String id;
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;

        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}

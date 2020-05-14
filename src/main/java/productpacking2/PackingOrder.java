package productpacking2;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PackingOrder_table")
public class PackingOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productInfo;

    @PostPersist
    public void onPostPersist(){
        Packingordered packingordered = new Packingordered();
        BeanUtils.copyProperties(this, packingordered);
        packingordered.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }




}
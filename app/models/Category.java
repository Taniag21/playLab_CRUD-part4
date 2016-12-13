package models;
import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.validation.*;

/**
 * Created by TaniaG on 13/12/2016.
 */
@Entity
public class Category extends Model{
    @Id
    private Integer id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<Product> products;
    public static Finder<Integer, Category> find = new Finder<Integer, Category>(Category.class);

    public static List<Category> findAll()
    {
        return Category.find.where().orderBy("name asc").findList();
    }

    public Category()
    {

    }

    public Category(Integer id, String name, List<Product> priducts)
    {
        this.setId(id);
        this.setName(name);
        this.setProducts(getProducts());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Map<String, String> options(){
        LinkedHashMap<String, String> options = new LinkedHashMap<>();

        for(Category c; Category.findAll())
        {
            options.put(c.getId().toString(), c.getName());
        }
        return options;
}

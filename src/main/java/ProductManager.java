public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        this.repo.save(product);
    }

    public Product[] findAll() {
        Product[] all = this.repo.findAll();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


}

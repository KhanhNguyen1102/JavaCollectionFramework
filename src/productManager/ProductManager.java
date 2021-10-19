package productManager;

import productManager.product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> productList ;

    public ProductManager(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ProductManager() {
        this.productList= new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product){
        productList.add(product);
        System.out.println("Đã thêm thành công");
    }
    public void add(int index,Product product){
        productList.add(index,product);
        System.out.println("Đã thêm thành công");
    }
    public void print(){
        for (Product product: productList) {
            System.out.println(product);
        }
        System.out.println("=========================");
    }
    public int findByID(int id){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void findByName(String name){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)){
                System.out.println(productList.get(i)); ;
            }
        }
        System.out.println("Ko tìm thấy sản phầm này"); ;
    }
    public void updateByID(int id,Product product){
        int index = findByID(id);
        if (index != -1){
            productList.set(index,product);
            System.out.println("Đã cập nhật thành công");
        }else {
            System.out.println("Không tìm thấy id này ");
        }
    }
    public void deleteByID(int id){
        int index = findByID(id);
        if(index != -1){
            productList.remove(index);
            System.out.println("Đã xóa thành công");
        }else {
            System.out.println("Không tìm thấy id này");
        }
    }
    public void sortMinToMax(){
        productList.sort((Comparator.comparingDouble(Product::getPrice)));
    }
    public int compare(Product o1,Product o2){
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
    public void sortMaxtoMin(){
        productList.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    }
    public static void main(String[] args) {
        ProductManager productArrayList = new ProductManager();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm sản phẩm tại ví trí tùy ý");
            System.out.println("3. Sửa thông tin sản phẩm ");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Tìm sản phẩm theo tên ");
            System.out.println("6. Sắp xếp các sản phẩm từ bé đến lớn theo giá ");
            System.out.println("7. Sắp xếp các sản phẩm từ lớn đến bé theo giá ");
            System.out.println("0. Exit ");
            System.out.println("Enter your choice: ");
//            choice = input.nextInt();
//            Id ko nên cho nhập mà chỉ tăng lên để tránh trùng
//            try catch để khi lỗi cho nhập lại
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
                choice = input.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("Điền id của sản phầm muốn thêm ");
                    int id = input.nextInt();
                    System.out.println("Điền tên của sản phẩm muốn thêm");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Điền giá của sản phẩm muốn thêm");
                    double price = input.nextDouble();
                    productArrayList.add(new Product(id, name, price));
                    productArrayList.print();
                    break;
                case 2:
                    System.out.println("Điền vị trí muốn thêm");
                    int index = input.nextInt();
                    System.out.println("Điền id của sản phầm muốn thêm ");
                    int id1 = input.nextInt();
                    System.out.println("Điền tên của sản phẩm muốn thêm");
                    input.nextLine();
                    String name1 = input.nextLine();
                    System.out.println("Điền giá của sản phẩm muốn thêm");
                    double price1 = input.nextDouble();
                    productArrayList.add(new Product(id1, name1, price1));
                    productArrayList.print();
                    break;
                case 3:
                    System.out.println("Điền vị trí muốn sửa");
                    int index1 = input.nextInt();
                    System.out.println("Bạn muốn sửa id thành ");
                    int id2 = input.nextInt();
                    System.out.println("Bạn muốn sửa tên thành ");
                    input.nextLine();
                    String name2 = input.nextLine();
                    System.out.println("Bạn muốn sửa giá thành");
                    double price2 = input.nextDouble();
                    productArrayList.updateByID(index1,new Product(id2, name2, price2));
                    productArrayList.print();
                    break;
                case 4:
                    System.out.println("Nhập id sản phẩm muốn xóa ");
                    int index2 = input.nextInt();
                    productArrayList.deleteByID(index2);
                    productArrayList.print();
                    break;
                case 5:
                    System.out.println("Nhập tên sản phẩm muốn tìm ");
                    input.nextLine();
                    String nameToFind = input.nextLine();
                    productArrayList.findByName(nameToFind);
                    productArrayList.print();
                    break;
                case 6:
                    productArrayList.sortMinToMax();
                    productArrayList.print();
                    break;
                case 7:
                    productArrayList.sortMaxtoMin();
                    productArrayList.print();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}

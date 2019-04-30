public class MenuItem {
	  private double price;
	  private String name;
	  private String imageName;

	  public MenuItem(double price, String name, String imageName) {
	      this.price = price;
	      this.name = name;
	      this.imageName = imageName;
	  }

	  public double getPrice() { return price; }

	  public String getName() { return name; }

	  public String getFileName() { return imageName; }
}
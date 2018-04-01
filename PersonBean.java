package sdsu;

public class PersonBean implements java.io.Serializable {

	private String name="John";
	private String color="red";
	public PersonBean() {}


	public String getColor() {
		return color;
		}

	public String getName() {
		return name;
		}

	public void setColor(String c) {
		color = c;
		}

	public void setName(String c) {
		name = c;
		}
	}

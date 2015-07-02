package pt.aor.paj.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="total")
public class Total {
	private int total;
	
	public Total(){}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	

}

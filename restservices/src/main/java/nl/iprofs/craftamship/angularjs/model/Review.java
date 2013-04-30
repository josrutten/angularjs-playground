package nl.iprofs.craftamship.angularjs.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"newspaper", "comments"})
public class Review implements Serializable {

	private static final long serialVersionUID = 1620957260232881634L;

	private String newspaper;
	private String comments;

	public Review() {}

	public Review(String newspaper, String comments) {
		this.newspaper = newspaper;
		this.comments = comments;
	}
	public String getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		return newspaper == null ? 0 : newspaper.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Review other = (Review) obj;
		if ((newspaper == null && other.newspaper != null) 
				|| !newspaper.equals(other.newspaper)) {
			return false;
		}
		return true;
	}
}

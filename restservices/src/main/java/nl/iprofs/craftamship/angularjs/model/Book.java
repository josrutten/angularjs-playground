package nl.iprofs.craftamship.angularjs.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "title", "author", "price", "reviews"})
public class Book implements Serializable {

	private static final long serialVersionUID = 1990046696838790622L;

	private String id;
	private String title;
	private String author;
	private BigDecimal price;
	@XmlElement(name = "reviews")
    private List<Review> reviews;
	
	public Book() {}
	public Book(String id) {
		this.id = id;
	}
	public Book(String id, String title, String author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;	
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<Review> getReviews() {
		if (reviews == null) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(reviews);
		}
	}
	public Book addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<Review>();
		}
		reviews.add(review);
		return this;
	}
	public void removeReview(Review review) {
		if (reviews != null) {
			reviews.remove(review);
		}
	}
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Book other = (Book) obj;
		if ((id == null && other.id != null) 
				|| !id.equals(other.id)) {
			return false;
		}
		return true;
	}
}

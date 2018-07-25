package com.scp.HibenateNew;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table( name="Book_Detail")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Book_type")
@DiscriminatorValue(value="Book_Data")

public class BookSingleinheritance {
@Id
@GeneratedValue(strategy=GenerationType.TABLE)
	int B_Id;
	double B_price;
	String B_author;
	public BookSingleinheritance(int b_Id, double b_price, String b_author) {
		super();
		B_Id = b_Id;
		B_price = b_price;
		B_author = b_author;
	}
	
	public BookSingleinheritance() {
		super();
	}

	public int getB_Id() {
		return B_Id;
	}
	public void setB_Id(int b_Id) {
		B_Id = b_Id;
	}
	
	public double getB_price() {
		return B_price;
	}
	public void setB_price(double b_price) {
		B_price = b_price;
	}
	public String getB_author() {
		return B_author;
	}
	public void setB_author(String b_author) {
		B_author = b_author;
	}	
}
@Entity
@DiscriminatorValue(value="COMICBOOK")
class ComicBook extends BookSingleinheritance
{
	String C_name;

	public ComicBook(int b_Id,double b_price, String b_author, String c_name) {
		super(b_Id, b_price, b_author);
		C_name = c_name;
	}
	
	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}
	
}
@Entity
@DiscriminatorValue(value="TECHNICALBOOKS")
class TechnicalBook extends BookSingleinheritance
{
	String T_name;

	public TechnicalBook(int b_Id, double b_price, String b_author, String t_name) {
		super(b_Id, b_price, b_author);
		T_name = t_name;
	}
	
	public String getT_name() {
		return T_name;
	}

	public void setT_name(String t_name) {
		T_name = t_name;
	}
	
}
package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Data")
public class Data 
{

	/**
	 * @return the data_id
	 */
	@Id
	@Column(name="data_id")
	@SequenceGenerator(allocationSize=1,name="DataSeq",sequenceName="DATA_SEQ")
	@GeneratedValue(generator="DataSeq",strategy=GenerationType.SEQUENCE)
	private Integer data_id;

	@Column(name="Wt")
	private Double Wt;
	
	@Column(name="w")
	private Double w;
	
	@Column(name="IHMHt")
	private Double IHM;
	
	@Column(name="successrate")
	private Double successrate;
	@Column(name="total")
	private Double total;
	@Column(name="totalsuccess")
	private Double totalsuccess;
	@Column(name="totalfailed")
	private Double totalfailed;
	public Integer getData_id() {
		return data_id;
	}
	/**
	 * @param data_id the data_id to set
	 */
	public void setData_id(Integer data_id) {
		this.data_id = data_id;
	}
	/**
	 * @return the wt
	 */
	public Double getWt() {
		return Wt;
	}
	/**
	 * @param wt the wt to set
	 */
	public void setWt(Double wt) {
		Wt = wt;
	}
	/**
	 * @return the w
	 */
	public Double getW() {
		return w;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(Double w) {
		this.w = w;
	}
	/**
	 * @return the iHM
	 */
	public Double getIHM() {
		return IHM;
	}
	/**
	 * @param iHM the iHM to set
	 */
	public void setIHM(Double iHM) {
		IHM = iHM;
	}
	/**
	 * @return the successrate
	 */
	public Double getSuccessrate() {
		return successrate;
	}
	/**
	 * @param successrate the successrate to set
	 */
	public void setSuccessrate(Double successrate) {
		this.successrate = successrate;
	}
	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the totalsuccess
	 */
	public Double getTotalsuccess() {
		return totalsuccess;
	}
	/**
	 * @param totalsuccess the totalsuccess to set
	 */
	public void setTotalsuccess(Double totalsuccess) {
		this.totalsuccess = totalsuccess;
	}
	/**
	 * @return the totalfailed
	 */
	public Double getTotalfailed() {
		return totalfailed;
	}
	/**
	 * @param totalfailed the totalfailed to set
	 */
	public void setTotalfailed(Double totalfailed) {
		this.totalfailed = totalfailed;
	}
	
	
}

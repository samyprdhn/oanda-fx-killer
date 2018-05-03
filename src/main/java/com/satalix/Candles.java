package com.satalix;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Candles implements Serializable {

	private Long volume;
	
	@JsonProperty(value="mid")
	private Price price;

	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSSSSSSS'Z'")
	private Date time;
	private Boolean complete;

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSSSSSSS'Z'")
	public Date getTime() {
		return time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSSSSSSS'Z'")
	public void setTime(Date time) {
		this.time = time;
	}

	public Boolean isComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}

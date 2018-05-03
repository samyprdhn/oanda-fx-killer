package com.satalix.app.util;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.satalix.Price;

public class HeikenAshiConverter implements Serializable {

	public HeikenAshiConverter() {

	}

	private Double HAClose;

	private Double HAOpen;

	private Double HAHigh;

	private Double HALow;

	public Double getHAClose() {
		return HAClose;
	}

	public void setHAClose(Double hAClose) {
		HAClose = hAClose;
	}

	public Double getHAOpen() {
		return HAOpen;
	}

	public void setHAOpen(Double hAOpen) {
		HAOpen = hAOpen;
	}

	public Double getHAHigh() {
		return HAHigh;
	}

	public void setHAHigh(Double hAHigh) {
		HAHigh = hAHigh;
	}

	public Double getHALow() {
		return HALow;
	}

	public void setHALow(Double hALow) {
		HALow = hALow;
	}

	public HeikenAshiConverter convert(ArrayList<Price> priceList) {

		HeikenAshiConverter heikenAshiConverter = new HeikenAshiConverter();
//
//		for (int i = 0; i < priceList.size(); i++) {
//			heikenAshiConverter.setHAClose((priceList.get(i).getOpen() + priceList.get(i).getH() + priceList.get(i).getL()
//					+ priceList.get(i).getC()) / 4);
//			if (i > 0) {
//				heikenAshiConverter.setHAOpen((priceList.get(i - 1).getO() + priceList.get(i - 1).getC() / 2));
//			} else {
//				heikenAshiConverter.setHAOpen(0D);
//			}
//
//			List<Double> hahighlist = Arrays.asList(priceList.get(i).getH(), priceList.get(i).getO(),
//					priceList.get(i).getC());
//			Collections.sort(hahighlist);
//			heikenAshiConverter.setHAHigh(hahighlist.get(0));
//
//			List<Double> halowlist = Arrays.asList(priceList.get(i).getH(), priceList.get(i).getO(),
//					priceList.get(i).getC());
//			Collections.sort(hahighlist);
//			heikenAshiConverter.setHALow(halowlist.get(2));

		return heikenAshiConverter;
	}
	// HA-Open = (HA-Open(-1) + HA-Close(-1)) / 2

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

	// Open(0) + High(0) + Low(0) + Close(0)) / 4
	//
	// 2. The Heikin-Ashi Open is the average of the prior Heikin-Ashi
	// candlestick open plus the close of the prior Heikin-Ashi candlestick.
	//
	//
	// 3. The Heikin-Ashi High is the maximum of three data points:
	// the current period's high, the current Heikin-Ashi
	// candlestick open or the current Heikin-Ashi candlestick close.
	//
	// HA-High = Maximum of the High(0), HA-Open(0) or HA-Close(0)
	//
	// 4. The Heikin-Ashi low is the minimum of three data points:
	// the current period's low, the current Heikin-Ashi
	// candlestick open or the current Heikin-Ashi candlestick close.
	//
	// HA-Low = Minimum of the Low(0), HA-Open(0) or HA-Close(0)

}

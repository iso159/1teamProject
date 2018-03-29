package com.cafe24.iso159.goods.service;

public class GoodsCart {
	private String pointGoodsCartCode;
	private String pointGoodsOrderCode;
	private String osCodeOrder;
	private String pointGoodsCode;
	private int cartCount;
	private int cartPointSum;
	private String pointGoodsCartDate;

	public String getPointGoodsCartCode() {
		return pointGoodsCartCode;
	}

	public void setPointGoodsCartCode(String pointGoodsCartCode) {
		this.pointGoodsCartCode = pointGoodsCartCode;
	}

	public String getPointGoodsOrderCode() {
		return pointGoodsOrderCode;
	}

	public void setPointGoodsOrderCode(String pointGoodsOrderCode) {
		this.pointGoodsOrderCode = pointGoodsOrderCode;
	}

	public String getOsCodeOrder() {
		return osCodeOrder;
	}

	public void setOsCodeOrder(String osCodeOrder) {
		this.osCodeOrder = osCodeOrder;
	}

	public String getPointGoodsCode() {
		return pointGoodsCode;
	}

	public void setPointGoodsCode(String pointGoodsCode) {
		this.pointGoodsCode = pointGoodsCode;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	public int getCartPointSum() {
		return cartPointSum;
	}

	public void setCartPointSum(int cartPointSum) {
		this.cartPointSum = cartPointSum;
	}

	public String getPointGoodsCartDate() {
		return pointGoodsCartDate;
	}

	public void setPointGoodsCartDate(String pointGoodsCartDate) {
		this.pointGoodsCartDate = pointGoodsCartDate;
	}

	@Override
	public String toString() {
		return "pointGoodsCart [pointGoodsCartCode=" + pointGoodsCartCode + ", pointGoodsOrderCode="
				+ pointGoodsOrderCode + ", osCodeOrder=" + osCodeOrder + ", pointGoodsCode=" + pointGoodsCode
				+ ", cartCount=" + cartCount + ", cartPointSum=" + cartPointSum + ", pointGoodsCartDate="
				+ pointGoodsCartDate + "]";
	}

}
